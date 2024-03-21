-- Genre(id_genre, name, id_supgenre*(genre))
drop table if exists genre;
create table genre (
                       id_genre serial primary key,
                       name varchar(50) not null,
                       id_supgenre int references genre(id_genre)
--	foreign key id_supgenre references genre(id_genre)
);

alter table genre
    add constraint unique_genre_name unique(name);


-- Movie(id_movie, title, duration, description, rating, special_requirenment)
drop table if exists movie;
create table movie(
                      id_movie serial primary key,
                      title varchar(255) not null,
                      duration int not null,
                      description varchar(500) not null,
                      rating numeric(4,2) not null,
                      special_requirement varchar(255)
);

alter table movie
    add column poster text default 'https://t4.ftcdn.net/jpg/04/73/25/49/360_F_473254957_bxG9yf4ly7OBO5I0O5KABlN930GwaMQz.jpg';

alter table movie
    add constraint rating_btw_1_and_10 check(rating between 1 and 10);

alter table movie
    alter column special_requirement set default 'None';


-- Movie_Genre(id_movie*(movie), id_genre*(genre))
drop table if exists movie_genre;
create table movie_genre(
                            id_movie int references movie(id_movie),
                            id_genre int references genre(id_genre),
                            constraint pk_movie_genre primary key (id_movie, id_genre)
--	foreign key (id_movie, id_genre)
);


-- Cinema(id_cinema, name, address, city, country)
drop table if exists cinema;
create table cinema(
                       id_cinema serial primary key,
                       name varchar(255) not null,
                       address varchar(255) not null,
                       city varchar(255) not null,
                       country varchar(255) not null
);


-- Hall(id_hall, hall_number, screen_type, id_cinema*(cinema))
drop table if exists hall;
create table hall(
                     id_hall serial primary key,
                     hall_number int not null,
                     screen_type varchar(100) not null,
                     id_cinema int not null,
                     foreign key (id_cinema) references cinema(id_cinema)
);


-- Projection(id_projection, date_time, id_movie*(movie), id_hall*(hall))
drop table if exists projection;
create table projection(
                           id_projection serial primary key,
                           date_time timestamp not null,
                           id_movie int not null references movie(id_movie),
                           id_hall int not null references hall(id_hall)
);

-- Add additional_price column to projection table
alter table projection
    add column start_price numeric(6,2) not null default 10.00;


-- Seat(id_seat, id_hall*(hall), row, number)
drop table if exists seat;
create table seat(
                     id_seat serial,
                     id_hall int references hall(id_hall),
                     seat_row int not null,
                     seat_number int not null,
                     primary key (id_seat, id_hall)
--	constraint pk_id_seat primary key (id_seat, id_hall)
);

alter table seat
    add constraint unique_row_and_seat unique(id_hall, seat_row, seat_number);


-- Customer(id_customer, first_name, last_name, sex, age)
drop table if exists customer;
create table customer(
                         id_customer serial primary key,
                         first_name varchar(100) not null,
                         last_name varchar(100) not null,
                         sex varchar(100) not null,
                         age int not null
);


-- Ticket (id_ticket, price, payment_method, (id_seat, id_hall)*(seat) , id_projection*(projection),id_customer*(customer))
drop table if exists ticket;
create table ticket(
                       id_ticket serial primary  key,
                       price numeric(6,2),
                       payment_method varchar(100),
                       id_seat int not null,
                       id_hall int not null,
                       foreign key (id_seat, id_hall) references seat(id_seat, id_hall),
                       id_projection int not null references projection(id_projection),
                       id_customer int references customer(id_customer)
);

alter table ticket
    add constraint unique_seat_and_projection unique(id_seat, id_projection);

alter table ticket
    alter column price set default 10.00,
add constraint non_negative_price check(price >= 0);