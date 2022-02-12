create table users
(
    id int unsigned auto_increment,
    email varchar(200) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    password varchar(300) null,
    authority int not null,
    is_deleted boolean default false not null,
    constraint users_pk
        primary key (id)
);
