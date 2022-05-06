DROP TABLE users_chat;

CREATE TABLE users_chat
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT REFERENCES users4 (id),
    chat_id    BIGINT REFERENCES chat (id),
    created_at TIMESTAMP    NOT NULL,
    created_by VARCHAR(128) NOT NULL,
    UNIQUE (user_id, chat_id)
);