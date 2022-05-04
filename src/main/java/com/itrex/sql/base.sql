CREATE TABLE users
(
    id         BIGINT PRIMARY KEY,
    username   VARCHAR(128) UNIQUE,
    firstname  VARCHAR(128),
    lastname   VARCHAR(128),
    birth_date DATE,
    role       VARCHAR(32),
    info       JSONB,
    company_id INT REFERENCES company (id)
);

CREATE TABLE company
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(64) NOT NULL UNIQUE
);



create sequence users_id_seq
    owned by users.id;

drop sequence users_id_seq;

DROP TABLE users;

create table all_sequence
(
    table_name VARCHAR(32) PRIMARY KEY,
    pk_value   BIGINT NOT NULL
);

drop table all_sequence;