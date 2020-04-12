BEGIN TRANSACTION;

DROP TABLE IF EXISTS category_game;
DROP TABLE IF EXISTS game_question;
DROP TABLE IF EXISTS game_player;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS player;

CREATE TABLE player
(
	player_id serial PRIMARY KEY,
	name varchar(64) not null,
	games_won int,
	games_played int
	
	--should games won be 0 if no wins or null if no wins?
	
);

CREATE TABLE game
(
	game_id serial PRIMARY KEY,
	game_code varchar(8) not null,
	active boolean not null,
	winner_id int,
	active_player_id int,
	active_player_roll int,
	active_player_answering_question boolean,
	active_player_category_selected_center boolean
	
	--foriegn key from player for active player(s) and for the winner, not sure how exactly this is determined however. do we even 
	--need a winner_id if player already has a "won" element?
);

CREATE TABLE game_player
(
        game_id int not null,        
        player_id int not null,
        player_color int not null,
        player_position int not null,
        player_score_cat_1 boolean not null,
        player_score_cat_2 boolean not null,
        player_score_cat_3 boolean not null,
        player_score_cat_4 boolean not null,
        player_score_cat_5 boolean not null,
        player_score_cat_6 boolean not null,

        constraint pk_game_player primary key (game_id, player_id),
        constraint fk_game_player_game foreign key (game_id) references game (game_id),
        constraint fk_game_player_player foreign key (player_id) references player (player_id)
        
        --in DAO, PSUEDO CODE, if(player Score 1 && player Score 2...){you win! game over, update games won in player and 
        --active in game to false};

);

CREATE TABLE category
(
        category_id serial PRIMARY KEY,
        name varchar(64) not null
        
        --template added below, can change once all categorys are agreed upon
);

CREATE TABLE category_game
(
        category_id int not null,
        game_id int not null,
        
        constraint pk_category_game primary key (category_id, game_id),
        constraint fk_category_game_category foreign key (category_id) references category (category_id),
        constraint fk_category_game_game foreign key (game_id) references game (game_id)
        
        --bridge table to put categories in game session
);

CREATE TABLE question
(
        question_id serial PRIMARY KEY,
        question varchar(120) not null,
        answer varchar(120) not null,
       
        category_id int not null,
        
        constraint fk_question_category foreign key (category_id) references category (category_id)
        
        --will be updated in final steps. should we add them here or make a DAO so more can be added at any time?
        --category_id will be 1-6, DAO something like INSERT INTO question WHERE category name == java OOP
);

CREATE TABLE game_question
(
        game_id int not null,
        question_id int not null,
        asked boolean not null,
        ordinal int,
        
        constraint pk_game_question primary key (game_id, question_id),
        constraint fk_game_question_question foreign key (question_id) references question (question_id),
        constraint fk_game_question_game foreign key (game_id) references game (game_id)
        
        --bridge table to put questions in game session, also shuffles deck with ordinal, also if(asked){take out of session};
);

COMMIT;
