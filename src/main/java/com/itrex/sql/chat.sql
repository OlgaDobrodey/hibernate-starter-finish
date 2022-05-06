CREATE TABLE chat
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE users_chat
(
    user_id BIGINT REFERENCES users4 (id),
    chat_id BIGINT REFERENCES chat (id),
    PRIMARY KEY (user_id, chat_id)
);

