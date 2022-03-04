create table tags
(
    id int unsigned auto_increment,
    name varchar(100) not null,
    sort_number int not null,
    tag_group_id int unsigned not null,
    is_deleted boolean default false not null,
    constraint tag_pks
        primary key (id),
    constraint tags_tag_group_id_fk
        foreign key (tag_group_id) references tag_groups (id)
            on delete cascade
);