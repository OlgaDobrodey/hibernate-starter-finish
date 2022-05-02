CREATE TABLE users2
(
    firstname VARCHAR(128) NOT NULL ,
    lastname VARCHAR(128) NOT NULL ,
    birth_date DATE NOT NULL ,
    username VARCHAR(128) UNIQUE ,
    role VARCHAR(32),
    info JSONB,
    PRIMARY KEY (firstname, lastname, birth_date)
);

create sequence users2_id_seq
    owned by users2.id;

drop sequence users2_id_seq;

DROP TABLE users2;

create table all_sequence
(
    table_name VARCHAR(32) PRIMARY KEY ,
    pk_value BIGINT NOT NULL
);