CREATE
DATABASE chat_db;

CREATE TABLE users
(
    id       BIGINT NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE messages
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    message  VARCHAR(225) NOT NULL,
    datetime  VARCHAR(225) NOT NULL,
    user_id BIGINT       NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT users_fk FOREIGN KEY (user_id) REFERENCES users (id)
);
