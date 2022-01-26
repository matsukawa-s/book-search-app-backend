create table lendings
(
    id int unsigned auto_increment,
    book_id int unsigned not null,
    user_id int unsigned not null,
    lending_time datetime not null,
    return_time datetime null,
    constraint lendings_pk
        primary key (id),
    constraint lendings_books_id_fk
        foreign key (book_id) references books (id),
    constraint lendings_users_id_fk
        foreign key (user_id) references users (id)
);