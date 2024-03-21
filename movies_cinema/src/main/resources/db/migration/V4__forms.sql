-- FORMS

--- customer
create or replace function insert_customer (
    first_name varchar(100),
    last_name varchar(100),
    sex varchar(100),
    age int
)
    returns void as
$$
begin
    insert into customer(first_name, last_name, sex, age)
    values ($1, $2, $3, $4);
end;
$$
    language plpgsql;

--delete from customer
--where first_name= 'Nikola' and last_name='Hristov';
--select insert_customer('Nikola', 'Hristov', 'Male', 21);
--
--select * from customer;



--- movie
--DROP FUNCTION insert_movie(character varying,integer,character varying,numeric,character varying,text) ;
create or replace function insert_movie(
    title varchar(255),
    duration int,
    description varchar(500),
    rating numeric(4,2),
    special_requirement varchar(255),
    poster text
)
    returns int as
$$
declare
    new_movie movie;
begin
    insert into movie(title, duration, description, rating, special_requirement, poster)
    values ($1, $2, $3, $4, $5, $6)
    returning * into new_movie;
    return new_movie.id_movie;
end;
$$
    language plpgsql;

--select insert_movie('Inception', 148, 'A mind-bending thriller', 8.7, 'PG-13', 'https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg');

select * from movie;


--BEGIN;
--UPDATE accounts SET balance = balance - 100.00
--    WHERE name = 'Alice';
---- etc etc
--COMMIT;


--- movie genre
create or replace function insert_movie_genre(
    id_movie int,
    id_genre int
)
    returns void as
$$
begin
    insert into movie_genre(id_movie, id_genre)
    values ($1, $2);
end;
$$
    language plpgsql;

--select insert_movie_genre (1, 16);
--delete from movie_genre where id_movie = 1 and id_genre = 16;
--select * from movie_genre;



--- projection
create or replace function insert_projection(
    date_time timestamp,
    id_movie int,
    id_hall int,
    start_price numeric(6,2)
)
    returns void as
$$
begin
    insert into projection(date_time, id_movie, id_hall, start_price)
    values ($1, $2, $3, $4);
end;
$$
    language plpgsql;

--select insert_projection ('2023-11-11 20:00', 1, 1);
--delete from projection where id_projection = 17;
--select * from projection where id_movie = 1 and id_hall = 1;

create or replace function release_tickets_for_projection()
    returns trigger as
$$
begin

    -- Insert new tickets for all seats in the hall
    insert into ticket(price, payment_method, id_seat, id_hall, id_projection, id_customer)
    select
        case
            when seat_row <= 1 THEN new.start_price * 1.3 -- increase if in first row
            else new.start_price
            end,
        null,
        id_seat,
        new.id_hall,			-- projection hall_id,
        new.id_projection, 		-- projection projection_id,
        NULL
    from seat
    where id_hall = new.id_hall;

    return new;
end;
$$
    language plpgsql;


-- TRIGGER WHEN CREATING PROJECTION
--drop trigger if exists release_tickets_trigger on projection;
create trigger release_tickets_trigger
    after insert
    on projection
    for each row
execute function release_tickets_for_projection();


--- projection
drop function if exists customer_buys_ticket;
create or replace function customer_buys_ticket(
    id_customer int,
    id_ticket int,
    payment_method varchar(100)
)
    returns void as
$$
begin
    update ticket t
    set id_customer = $1, payment_method = $3
    where t.id_ticket = $2;
end;
$$
    language plpgsql;