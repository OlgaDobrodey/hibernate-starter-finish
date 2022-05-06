CREATE TABLE users4
(
    id         BIGSERIAL PRIMARY KEY,
    firstname  VARCHAR(128),
    lastname   VARCHAR(128),
    birth_date DATE,
    username   VARCHAR(128) UNIQUE,
    role       VARCHAR(32),
    info       JSONB,
    company_id INT REFERENCES company1 (id)
);

CREATE TABLE company1
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE profile
(
    user_id  BIGINT PRIMARY KEY REFERENCES users4 (id),
    street   VARCHAR(128),
    language CHAR(2)
);

CREATE TABLE profilefk
(
    id BIGSERIAL PRIMARY KEY,
    user_id  BIGINT NOT NULL UNIQUE REFERENCES users4 (id),
    street   VARCHAR(128),
    language CHAR(2)
);

DROP TABLE users4;