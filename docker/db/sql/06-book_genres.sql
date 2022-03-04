create table book_genres
(
    id int unsigned auto_increment,
    book_id int unsigned not null,
    genre_id int unsigned not null,
    constraint book_genres_pk
        primary key (id),
    constraint book_genres_books_id_fk
        foreign key (book_id) references books (id)
            on delete cascade,
    constraint book_genres_genres_id_fk
        foreign key (genre_id) references genres (id)
            on delete cascade
);