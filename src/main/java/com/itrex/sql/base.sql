Create TABLE users
(
    username   varchar(128) PRIMARY KEY,
    firstname  varchar(128),
    lastname   varchar(128),
    birth_date date,
    role       varchar(32)
);

DROP TABLE users;