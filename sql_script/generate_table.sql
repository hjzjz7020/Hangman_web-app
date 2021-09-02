create table game
(
    ID               varchar(256)                   not null
        primary key,
    word             varchar(50)                    not null,
    state            enum ('WON', 'LOST', 'ACTIVE') not null,
    remainingGuesses int default 10                 not null,
    currentGuess     varchar(50)                    null
);

create table word
(
    ID   int auto_increment
        primary key,
    word varchar(50) not null,
    constraint word_word_uindex
        unique (word)
);

