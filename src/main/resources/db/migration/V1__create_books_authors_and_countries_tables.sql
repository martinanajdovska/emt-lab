create table countries (
    id bigserial primary key,
    name varchar(255) not null,
    continent varchar(255) not null
);

create table authors (
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    name varchar(255) not null,
    surname varchar(255) not null,
    country_id bigint not null,
    foreign key (country_id) references countries(id) on delete cascade
);

create table books (
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    title varchar(255) not null,
    author_id bigint not null,
    category varchar(255) not null,
    state varchar(255) not null,
    available_copies int not null,
    foreign key (author_id) references authors(id) on delete cascade
)