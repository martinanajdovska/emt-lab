insert into countries (name, continent)
values ('United States', 'North America'),
       ('United Kingdom', 'Europe'),
       ('France', 'Europe'),
       ('Russia', 'Europe'),
       ('Colombia', 'South America');

insert into authors (created_at, updated_at, name, surname, country_id)
values (now(), now(), 'Stephen', 'King', 1),
       (now(), now(), 'George', 'Orwell', 2),
       (now(), now(), 'Albert', 'Camus', 3),
       (now(), now(), 'Fyodor', 'Dostoevsky', 4),
       (now(), now(), 'Gabriel', 'Garcia Marquez', 5);

insert into books (created_at, updated_at, name, author_id, category, state, available_copies)
values (now(), now(), 'The Shining', 1, 'THRILLER', 'GOOD', 5),
       (now(), now(), 'It', 1, 'THRILLER', 'GOOD', 3),
       (now(), now(), '1984', 2, 'CLASSICS', 'GOOD', 8),
       (now(), now(), 'Animal Farm', 2, 'CLASSICS', 'GOOD', 6),
       (now(), now(), 'The Stranger', 3, 'CLASSICS', 'GOOD', 4),
       (now(), now(), 'The Plague', 3, 'CLASSICS', 'GOOD', 2),
       (now(), now(), 'Crime and Punishment', 4, 'CLASSICS', 'GOOD', 7),
       (now(), now(), 'The Idiot', 4, 'CLASSICS', 'GOOD', 3),
       (now(), now(), 'One Hundred Years of Solitude', 5, 'NOVEL', 'BAD', 5),
       (now(), now(), 'Love in the Time of Cholera', 5, 'NOVEL', 'BAD', 4);