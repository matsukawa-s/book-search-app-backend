create table book_tags
(
    id int unsigned auto_increment,
    book_id int unsigned not null,
    tag_id int unsigned not null,
    constraint book_tags_pk
        primary key (id),
    constraint book_tags_books_id_fk
        foreign key (book_id) references books (id)
            on delete cascade,
    constraint book_tags_tags_id_fk
        foreign key (tag_id) references tags (id)
            on delete cascade
);