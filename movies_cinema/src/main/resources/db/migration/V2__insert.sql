--truncate table cinema restart identity cascade;
insert into cinema(name, address, city, country)
values ('Cineplexx',   'Manapo',      'Skopje',  'North Macedonia'),
       ('mts Dvorana', 'Dečanska 14', 'Beograd', 'Serbia');

select * from cinema;


--truncate table genre, movie_genre restart identity cascade;
insert into genre(name)
values  ('Action'),          ('Comedy'),
        ('Drama'),           ('Horror'),
        ('Science Fiction'), ('Fantasy'),
        ('Adventure'),       ('Thriller'),
        ('Mystery'),         ('Romance'),
        ('Animation'),       ('Family'),
        ('Musical'),         ('Western'),
        ('Documentary');

insert into genre(name)
values  ('Superhero'),       ('Spy'),
        ('Romantic Comedy'), ('Satire'),
        ('Crime Drama'),     ('Historical Drama'),
        ('Slasher'),         ('Supernatural Horror'),
        ('Cyberpunk'),       ('Time Travel'),
        ('Fairy Tale'),      ('Magic'),
        ('Survival'),        ('Treasure Hunt'),
        ('Psychological'),   ('Crime Thriller'),
        ('Detective'),       ('Romantic Fantasy'),
        ('2D Animation'),    ('3D Animation'),
        ('Family Comedy'),   ('Family Fantasy');

update genre
set id_supgenre = (select id_genre from genre where name = 'Action')
where name in ('Superhero', 'Spy');

update genre
set id_supgenre = (select id_genre from genre where name = 'Comedy')
where name in ('Romantic Comedy', 'Satire');

update genre
set id_supgenre = (select id_genre from genre where name = 'Drama')
where name in ('Crime Drama', 'Historical Drama');

update genre
set id_supgenre = (select id_genre from genre where name = 'Horror')
where name in ('Slasher', 'Supernatural Horror');

update genre
set id_supgenre = (select id_genre from genre where name = 'Science Fiction')
where name in ('Cyberpunk', 'Time Travel');

update genre
set id_supgenre = (select id_genre from genre where name = 'Fantasy')
where name in ('Fairy Tale', 'Magic');

update genre
set id_supgenre = (select id_genre from genre where name = 'Adventure')
where name in ('Survival', 'Treasure Hunt');

update genre
set id_supgenre = (select id_genre from genre where name = 'Thriller')
where name in ('Psychological', 'Crime Thriller');

update genre
set id_supgenre = (select id_genre from genre where name = 'Mystery')
where name in ('Detective');

update genre
set id_supgenre = (select id_genre from genre where name = 'Romance')
where name in ('Romantic Fantasy');

update genre
set id_supgenre = (select id_genre from genre where name = 'Animation')
where name in ('2D Animation', '3D Animation');

update genre
set id_supgenre = (select id_genre from genre where name = 'Family')
where name in ('Family Comedy', 'Family Fantasy');

select * from genre;

--truncate table movie restart identity cascade;
insert into movie(title, duration, description, rating, special_requirement)
values  ('Inception',      			 148, 'A mind-bending thriller',                  8.7, 'PG-13'),
        ('The Dark Knight',          152, 'A superhero film',                         9.0, 'PG-13'),
        ('Titanic',                  195, 'A romantic drama',                         7.8, 'PG'),
        ('The Shawshank Redemption', 142, 'A story of hope and friendship in prison', 9.3, 'R'),
        ('Pulp Fiction',             154, 'A nonlinear crime film',                   8.9, 'R'),
        ('The Matrix',               136, 'A groundbreaking sci-fi action film',      8.7, 'PG-13'),
        ('Forrest Gump',             142, 'A heartwarming tale of a simple man',      8.8, 'PG'),
        ('The Godfather',            175, 'A powerful crime drama',                   9.2, 'R'),
        ('Interstellar',             169, 'A space exploration epic',                 8.6, 'PG-13');

select * from movie;

--truncate table movie_genre restart identity cascade;
insert into movie_genre(id_movie, id_genre)
values  (1, (select id_genre from genre where name = 'Action')),
        (1, (select id_genre from genre where name = 'Science Fiction')),
        (2, (select id_genre from genre where name = 'Action')),
        (2, (select id_genre from genre where name = 'Superhero')),
        (2, (select id_genre from genre where name = 'Science Fiction')),
        (3, (select id_genre from genre where name = 'Romance')),
        (4, (select id_genre from genre where name = 'Drama')),
        (4, (select id_genre from genre where name = 'Thriller')),
        (5, (select id_genre from genre where name = 'Drama')),
        (5, (select id_genre from genre where name = 'Adventure')),
        (6, (select id_genre from genre where name = 'Science Fiction')),
        (6, (select id_genre from genre where name = 'Adventure')),
        (7, (select id_genre from genre where name = 'Drama')),
        (8, (select id_genre from genre where name = 'Drama')),
        (8, (select id_genre from genre where name = 'Thriller')),
        (9, (select id_genre from genre where name = 'Science Fiction')),
        (9, (select id_genre from genre where name = 'Time Travel'));


select * from movie_genre;

--truncate table hall restart identity cascade;
insert into hall(hall_number, screen_type, id_cinema)
values  (1, 'Standard', 1), -- cinema 1
        (2, 'IMAX',     1),
        (1, 'Standard', 2), -- cinema 2
        (2, '3D',       2);

select * from hall;

--truncate table seat restart identity cascade;
insert into seat (id_hall, seat_row, seat_number)
values  (1,1,1), (1,1,2), (1,1,3), (1,2,1), (1,3,1), (1,2,2), (1,3,3), (1,2,3), (1,3,2), -- hall 1,
        (2,1,1), (2,1,2), (2,1,3), (2,2,1), (2,3,1), (2,2,2), (2,3,3), (2,2,3), (2,3,2), -- hall 2
        (3,1,1), (3,1,2), (3,1,3), (3,2,1), (3,3,1), (3,2,2), (3,3,3), (3,2,3), (3,3,2), -- hall 3
        (4,1,1), (4,1,2), (4,1,3), (4,2,1), (4,3,1), (4,2,2), (4,3,3), (4,2,3), (4,3,2); -- hall 4

select * from seat;

--truncate table projection restart identity cascade;
insert into projection(date_time, id_movie, id_hall)
values  ('2023-11-11 20:00', 1, 1), -- hall 1
        ('2023-11-12 20:00', 2, 1),
        ('2024-01-05 20:30', 3, 2), -- hall 2
        ('2023-11-22 16:00', 4, 2),
        ('2023-12-17 21:30', 5, 3), -- hall 3
        ('2023-11-16 19:30', 6, 3),
        ('2023-12-02 20:00', 7, 4), -- hall 4
        ('2024-01-05 21:00', 8, 4);

select * from projection;

--truncate table customer restart identity cascade;
insert into customer (first_name, last_name, sex, age)
values  ('Petar',   'Stojanovic', 'Male',   22),
        ('Filip',   'Filipovski', 'Male',   33),
        ('Milan',   'Milanovski', 'Male',   25),
        ('Dimitar', 'Dimevski',   'Male',   54),
        ('Bojan',   'Bojanski',   'Male',   35),
        ('Jovana',  'Jovanovska', 'Female', 68),
        ('Megi',    'Megevska',   'Female', 26),
        ('Monika',  'Monikova',   'Female', 42);

select * from customer;

--truncate table ticket restart identity cascade;
insert into ticket(price, payment_method, id_seat, id_hall, id_projection, id_customer)
values  (10.00, 'Credit Card', (select id_seat from seat where id_hall=1 and seat_row=1 and seat_number=2), 1, 1, 1),
        (12.50, 'Cash',        (select id_seat from seat where id_hall=1 and seat_row=1 and seat_number=1), 1, 2, 2),
        (13.99, 'Debit Card',  (select id_seat from seat where id_hall=2 and seat_row=2 and seat_number=3), 2, 3, 3),
        (8.99,  'Debit Card',  (select id_seat from seat where id_hall=2 and seat_row=2 and seat_number=2), 2, 4, 4),
        (20.00, 'Cash',        (select id_seat from seat where id_hall=3 and seat_row=3 and seat_number=3), 3, 5, 5),
        (13.00, 'Credit Card', (select id_seat from seat where id_hall=3 and seat_row=3 and seat_number=1), 3, 6, 6),
        (9.99,  'Cash',        (select id_seat from seat where id_hall=4 and seat_row=1 and seat_number=2), 4, 7, 7),
        (15.00, 'Debit Card',  (select id_seat from seat where id_hall=4 and seat_row=3 and seat_number=3), 4, 8, 8);


insert into ticket(price, payment_method, id_seat, id_hall, id_projection, id_customer)
values  (15.00, 'Credit Card', (select id_seat from seat where id_hall=2 and seat_row=2 and seat_number=2), 2, 2, 1),
        (9.50, 'Cash',        (select id_seat from seat where id_hall=1 and seat_row=1 and seat_number=3), 1, 2, 2),
        (15.99, 'Debit Card',  (select id_seat from seat where id_hall=2 and seat_row=1 and seat_number=3), 2, 2, 3),
        (2.99,  'Debit Card',  (select id_seat from seat where id_hall=2 and seat_row=3 and seat_number=2), 2, 5, 4),
        (25.00, 'Cash',        (select id_seat from seat where id_hall=3 and seat_row=3 and seat_number=3), 3, 3, 5),
        (43.00, 'Credit Card', (select id_seat from seat where id_hall=3 and seat_row=1 and seat_number=1), 3, 6, 6),
        (8.99,  'Cash',        (select id_seat from seat where id_hall=4 and seat_row=2 and seat_number=2), 4, 1, 7),
        (22.00, 'Debit Card',  (select id_seat from seat where id_hall=4 and seat_row=3 and seat_number=1), 4, 7, 8);

select * from ticket;



update movie
set poster = 'https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p7825626_p_v8_af.jpg'
where title = 'Inception';

update movie
set poster = 'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg'
where title = 'The Dark Knight';

update movie
set poster = 'https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_FMjpg_UX1000_.jpg'
where title = 'Titanic';

update movie
set poster = 'https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg'
where title = 'The Shawshank Redemption';

update movie
set poster = 'https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg'
where title = 'Pulp Fiction';

update movie
set poster = 'https://consequence.net/wp-content/uploads/2019/03/The-Matrix.jpg'
where title = 'The Matrix';

update movie
set poster = 'https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg'
where title = 'Forrest Gump';

update movie
set poster = 'https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg'
where title = 'The Godfather';

update movie
set poster = 'https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg'
where title = 'Interstellar';