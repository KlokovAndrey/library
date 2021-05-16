create table if not exists users
(
    id     varchar(36)  not null
        primary key,
    name   varchar(255) null,
    email   varchar(255) null,
    password   varchar(255) null,
    role   varchar(255) null,
    city   varchar(255) null,
    street varchar(255) null,
    house varchar(255) null,
    flat varchar(255) null
);

create table if not exists book
(
    id        varchar(36) not null
        primary key,
    name   varchar(255) null,
    genre integer null,
    year_of_publishing integer null
);

create table if not exists author
(
    id        varchar(36) not null
        primary key,
    name   varchar(255) null
);

create table if not exists author
(
    id        varchar(36) not null
        primary key,
    name   varchar(255) null
);

create table if not exists book_author
(
    book_id varchar(36) not null,
    author_id    varchar(36) not null,
    primary key (book_id, author_id),
    constraint fk_book_author_book
    foreign key (book_id) references book (id),
    constraint fk_book_author_author
    foreign key (author_id) references author (id)
    );

create table if not exists taken_book
(
    user_id varchar(36) not null,
    book_id    varchar(36) not null,
    primary key (user_id, book_id),
    date_of_receiving date null,
    constraint fk_taken_book_user
    foreign key (user_id) references users (id),
    constraint fk_taken_book_book
    foreign key (book_id) references book (id)
    );

create table if not exists warehouse
(
    id        uuid not null
    primary key,
    number   integer null,
    row integer null,
    shelf integer null,
    book_id uuid not null,
    constraint fk_warehouse_book
    foreign key (book_id) references book (id)
    );
