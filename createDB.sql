BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_invite;
DROP TABLE IF EXISTS category_game;
DROP TABLE IF EXISTS game_question;
DROP TABLE IF EXISTS game_player;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS user_account;
DROP TABLE IF EXISTS player;

CREATE TABLE user_account
(
        user_id serial PRIMARY KEY,
        username varchar(100) not null UNIQUE,
        id_token varchar(255) not null,
        email varchar(255) not null,
        picture varchar(255),
        games_played int not null default(0),
        games_won int not null default(0)
);

CREATE TABLE game
(
        game_id serial PRIMARY KEY,
        game_code varchar(32) not null unique,
        active boolean not null,
        winner_id int,
        active_player_id int, -- remove once finished w/ jdbcs (this is now in game_player)
        active_player_roll int, -- remove once finished w/ jdbcs (this is now in game_player)
        active_player_answering_question boolean default(false), -- remove once finished w/ jdbcs (this is now in game_player)
        active_player_category_selected_center boolean default(false)-- remove once finished w/ jdbcs (this is now in game_player) -- Brooks
);

CREATE TABLE game_player
(
        game_id int not null,        
        user_id int not null,
        player_color int,
        player_roll int, -- update jdbc - Brooks
        player_position int not null default(0),
        player_score_cat_1 boolean not null default(false),
        player_score_cat_2 boolean not null default(false),
        player_score_cat_3 boolean not null default(false),
        player_score_cat_4 boolean not null default(false),
        player_score_cat_5 boolean not null default(false),
        player_score_cat_6 boolean not null default(false),
        is_turn boolean, -- update jdbc - Brooks
        is_answering_question boolean default(false), -- update jdbc + Player.java
        has_selected_category_center boolean default(false), -- update jdbc + Player.java - Brooks
        is_active boolean default(true),

        constraint pk_game_player primary key (game_id, user_id),
        constraint fk_game_player_game foreign key (game_id) references game (game_id),
        constraint fk_game_player_user_account foreign key (user_id) references user_account (user_id)
);

CREATE TABLE category
(
        category_id serial PRIMARY KEY,
        name varchar(64) not null        
);

CREATE TABLE category_game
(
        category_id int not null,
        game_id int not null,
       
        constraint pk_category_game primary key (category_id, game_id),
        constraint fk_category_game_category foreign key (category_id) references category (category_id),
        constraint fk_category_game_game foreign key (game_id) references game (game_id)        
);

CREATE TABLE question
(
        question_id serial PRIMARY KEY,
        category_id int not null,
        question varchar(255) not null,
        correct_answer varchar(255) not null,
        answer_choice_a varchar(255),
        answer_choice_b varchar(255),
        answer_choice_c varchar(255),
        answer_choice_d varchar(255),
       
        constraint fk_question_category foreign key (category_id) references category (category_id)        
);

CREATE TABLE game_question
(
        game_id int not null,
        question_id int not null,
        asked boolean not null,
        is_current_question boolean,
       
        constraint pk_game_question primary key (game_id, question_id),
        constraint fk_game_question_question foreign key (question_id) references question (question_id),
        constraint fk_game_question_game foreign key (game_id) references game (game_id)        
);

CREATE TABLE user_invite
(
        invite_id serial PRIMARY KEY,
        game_code varchar(32) not null,
        invitee varchar(100) not null,
        invited_by varchar(100) not null,
        
        constraint fk_user_invite_game foreign key (game_code) references game (game_code),
        constraint fk_user_invite_user_account foreign key (invitee) references user_account (username)
);

COMMIT;