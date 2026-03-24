create table activity_logs (
    id bigserial primary key,
    type varchar(50) not null,
    title varchar(255) not null,
    created_at timestamp not null
);