-- STATISTICS

-- gledanost na filmovi
drop view if exists most_viewed_movies_view;
create view most_viewed_movies_view as(
                                      select
                                                  row_number() over () as id,
                                                  m.id_movie,
                                                  m.poster,
                                                  m.title,
                                                  count(t.id_customer) as ticket_count
                                      from ticket t
                                               join projection p on t.id_projection  = p.id_projection
                                               join movie m on p.id_movie = m.id_movie
                                      group by 2,3,4
                                      order by 5 desc
                                          );

select * from most_viewed_movies_view;

-- najpopularni zanrovi
drop view if exists most_popular_genres_view;
create view most_popular_genres_view as(
                                       select
                                                   row_number() over () as id,
                                                   g.name,
                                                   count(g.name) as ticket_count
                                       from movie m
                                                join movie_genre mg on mg.id_movie = m.id_movie
                                                join genre g on g.id_genre = mg.id_genre
                                                join projection p on p.id_movie = m.id_movie
                                                join ticket t on t.id_projection = p.id_projection
                                       group by 2
                                       order by ticket_count desc
                                           );

select * from most_popular_genres_view;


-- najcesti klienti
drop view if exists most_frequent_customers_view;
create view most_frequent_customers_view as(
                                           select
                                                       row_number() over () as id,
                                                       c.id_customer,
                                                       c.first_name,
                                                       c.last_name,
                                                       count(t.id_ticket) as ticket_count
                                           from ticket t
                                                    join customer c on t.id_customer = c.id_customer
                                           group by 2,3,4
                                           order by ticket_count desc
                                               );

select * from most_frequent_customers_view;

-- najprofitabilen film/proekcija za film
drop view if exists most_profitable_movies_view;
create view most_profitable_movies_view as(
                                          select
                                                      row_number() over () as id,
                                                      m.id_movie,
                                                      m.poster,
                                                      m.title,
                                                      sum(t.price) as total_revenue
                                          from movie m
                                                   join projection p on m.id_movie = p.id_movie
                                                   join ticket t on t.id_projection= p.id_projection
                                          group by 2,3,4
                                          order by total_revenue desc
                                              );

select * from most_profitable_movies_view;

-- najpopularni termini za film
drop view if exists most_popular_movie_times_view;
create view most_popular_movie_times_view as(
                                                       select
                                                                   row_number() over () as id,
                                                                   p.date_time::time as projection_time,
                                                                   count(t.id_ticket) as ticket_count
                                                       from projection p
                                                                join ticket t on p.id_projection = t.id_projection
                                                       where t.id_customer is not null
                                                       group by projection_time
                                                       order by ticket_count desc
                                                           );