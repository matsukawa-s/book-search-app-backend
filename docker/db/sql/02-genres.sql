create table genres
(
    id int unsigned auto_increment,
    name varchar(50) not null,
    is_deleted boolean default false not null,
    sort_number int not null,
    constraint genres_pk
        primary key (id)
);