create table tag_groups
(
    id int unsigned auto_increment,
    name varchar(200) not null,
    is_deleted boolean default false not null,
    constraint tag_groups_pk
        primary key (id)
);