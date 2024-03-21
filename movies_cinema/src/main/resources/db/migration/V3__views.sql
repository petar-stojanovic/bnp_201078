-- VIEWS

-- Приказ на сите филмови со жанровите
drop view if exists movie_with_genres_view;
create view movie_with_genres_view as(
                                     select
                                                 row_number() over () as id,
                                                 m.id_movie,
                                                 m.title,
                                                 m.duration,
                                                 m.description,
                                                 m.rating,
                                                 m.special_requirement,
                                                 m.poster,
                                                 string_agg(g.name, ', ') as genres
                                     from movie m
                                              join movie_genre mg on mg.id_movie = m.id_movie
                                              join genre g on g.id_genre = mg.id_genre
                                     group by 2,3,4,5,6,7,8);

select * from movie_with_genres_view;


-- Приказ на сите проекции за филмот
drop view if exists all_projections_for_movie_view;
create view all_projections_for_movie_view as (
                                                         select
                                                                     row_number() over () as id,
                                                                     p.id_movie as id_movie,
                                                                     p.id_projection as id_projection,
                                                                     p.date_time as date_time,
                                                                     h.hall_number as hall_number,
                                                                     h.screen_type as screen_type,
                                                                     p.start_price as start_price,
                                                                     c.name as cinema_name
                                                         from projection p
                                                                  join hall h on p.id_hall = h.id_hall
                                                                  join cinema c on h.id_cinema =c.id_cinema
                                                         order by date_time
                                                             );

select * from all_projections_for_movie_view;



-- Приказ на сите тикети за проекцијата
drop view if exists all_tickets_for_projection_view;
create view all_tickets_for_projection_view as(
                                              select
                                                          row_number() over () as id,
                                                          p.id_projection as id_projection,
                                                          t.id_ticket as id_ticket,
                                                          p.date_time as projection_time,
                                                          t.price as price,
                                                          s.id_seat as id_seat,
                                                          s.seat_row as seat_row,
                                                          s.seat_number as seat_number,
                                                          (t.id_customer is not null) AS is_bought,
                                                          t.id_customer,
                                                          h.screen_type as screen_type,
                                                          c.name as cinema_name,
                                                          c.city as city,
                                                          c.country as country,
                                                          h.hall_number as hall_number
                                              from ticket t
                                                       left join projection p on t.id_projection = p.id_projection
                                                       left join seat s on s.id_seat = t.id_seat
                                                       left join hall h on p.id_hall = h.id_hall
                                                       left join cinema c on c.id_cinema = h.id_cinema
                                                  );

select * from all_tickets_for_projection_view;
select * from all_tickets_for_projection_view where id_projection = 25;
select * from ticket where id_projection =24;


-- Приказ на корисник со сите купени карти до сега, сите детали за тикетите (седиште, сала),
drop view if exists all_tickets_by_user_view;
create view all_tickets_by_user_view as(
                                       select
                                                   row_number() over () as id,
                                                   c.id_customer as id_customer,
                                                   p.date_time as date_time,
                                                   m.poster as poster,
                                                   m.id_movie as id_movie,
                                                   m.title as movie_title,
                                                   m.special_requirement as special_requirement,
                                                   t.price as ticket_price,
                                                   t.payment_method as payment_method,
                                                   s.seat_row as row_number,
                                                   s.seat_number as col_number,
                                                   h.screen_type as screen_type,
                                                   cin.name as cinema_name
                                       from customer c
                                                join ticket t on t.id_customer = c.id_customer
                                                join seat s on s.id_seat = t.id_seat
                                                join projection p on p.id_projection = t.id_projection
                                                join hall h on h.id_hall = p.id_hall
                                                join cinema cin on cin.id_cinema = h.id_cinema
                                                join movie m on p.id_movie = m.id_movie
                                           );



select * from all_tickets_by_user_view;
select * from all_tickets_by_user_view where id_customer = 13;


---------------------

-- Приказ на тикетот со деталите за филмот, седиштетото и салата која се оджува
drop view if exists ticket_info_view;
create view ticket_info_view as (
                                select
                                            row_number() over () as id,
                                            t.id_ticket as id_ticket,
                                            t.id_customer as id_customer,
                                            t.price as price,
                                            p.date_time as date_time,
                                            s.id_hall as id_hall,
                                            s.seat_row as row_number,
                                            s.seat_number as col_number,
                                            m.id_movie as id_movie,
                                            m.title as movie_title,
                                            m.duration as duration,
                                            h.hall_number as hall_number
                                from ticket t
                                         join seat s on s.id_seat = t.id_seat
                                         join hall h on s.id_hall = h.id_hall
                                         join projection p on p.id_projection = t.id_projection
                                         join movie m on m.id_movie = p.id_movie
                                    );