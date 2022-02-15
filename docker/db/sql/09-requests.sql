create table requests
(
    id int unsigned auto_increment,
    user_id int unsigned not null,
    book_name varchar(300) not null,
    link varchar(300) null,
    reason varchar(300) not null,
    request_date datetime not null,
    status int not null,
    constraint requests_pk
        primary key (id),
    constraint requests_user_id_fk
        foreign key (user_id) references users (id)
            on delete cascade
);