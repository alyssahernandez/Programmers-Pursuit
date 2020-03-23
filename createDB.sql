BEGIN TRANSACTION;

DROP TABLE IF EXISTS category_game;
DROP TABLE IF EXISTS category_space;
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
	games_won int not null,
	games_played int not null
	
	--should games won be 0 if no wins or null if no wins?
	
);

CREATE TABLE game
(
	game_id serial PRIMARY KEY,
	game_code varchar(4) not null,
	active boolean not null,
	winner_id int not null,
	active_player_id int not null
	
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

CREATE TABLE category_space
(
        category_id int not null,
        space int not null,
        
        constraint fk_category_space_category foreign key (category_id) references category(category_id)
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

--add categories, need concrete list of what we are doing, everything that is not questions and category set in JSTL DAO

INSERT INTO category (name) VALUES ('Java OOP');
INSERT INTO category (name) VALUES ('SQL');
INSERT INTO category (name) VALUES ('HTML/CSS');
INSERT INTO category (name) VALUES ('MVC');
INSERT INTO category (name) VALUES ('JavaScript');
INSERT INTO category (name) VALUES ('TDD');

INSERT INTO category_space (category_id, space) VALUES(1, 1);
INSERT INTO category_space (category_id, space) VALUES(1, 7);
INSERT INTO category_space (category_id, space) VALUES(1, 13);
INSERT INTO category_space (category_id, space) VALUES(1, 19);
INSERT INTO category_space (category_id, space) VALUES(1, 25);
INSERT INTO category_space (category_id, space) VALUES(1, 31);
INSERT INTO category_space (category_id, space) VALUES(1, 37);
INSERT INTO category_space (category_id, space) VALUES(1, 43);
INSERT INTO category_space (category_id, space) VALUES(1, 49);
INSERT INTO category_space (category_id, space) VALUES(1, 55);
INSERT INTO category_space (category_id, space) VALUES(1, 61);
INSERT INTO category_space (category_id, space) VALUES(1, 67);

INSERT INTO category_space (category_id, space) VALUES(2, 2);
INSERT INTO category_space (category_id, space) VALUES(2, 8);
INSERT INTO category_space (category_id, space) VALUES(2, 14);
INSERT INTO category_space (category_id, space) VALUES(2, 20);
INSERT INTO category_space (category_id, space) VALUES(2, 26);
INSERT INTO category_space (category_id, space) VALUES(2, 32);
INSERT INTO category_space (category_id, space) VALUES(2, 38);
INSERT INTO category_space (category_id, space) VALUES(2, 44);
INSERT INTO category_space (category_id, space) VALUES(2, 50);
INSERT INTO category_space (category_id, space) VALUES(2, 56);
INSERT INTO category_space (category_id, space) VALUES(2, 62);
INSERT INTO category_space (category_id, space) VALUES(2, 68);

INSERT INTO category_space (category_id, space) VALUES(3, 3);
INSERT INTO category_space (category_id, space) VALUES(3, 9);
INSERT INTO category_space (category_id, space) VALUES(3, 15);
INSERT INTO category_space (category_id, space) VALUES(3, 21);
INSERT INTO category_space (category_id, space) VALUES(3, 27);
INSERT INTO category_space (category_id, space) VALUES(3, 33);
INSERT INTO category_space (category_id, space) VALUES(3, 39);
INSERT INTO category_space (category_id, space) VALUES(3, 45);
INSERT INTO category_space (category_id, space) VALUES(3, 51);
INSERT INTO category_space (category_id, space) VALUES(3, 57);
INSERT INTO category_space (category_id, space) VALUES(3, 63);
INSERT INTO category_space (category_id, space) VALUES(3, 69);

INSERT INTO category_space (category_id, space) VALUES(4, 4);
INSERT INTO category_space (category_id, space) VALUES(4, 10);
INSERT INTO category_space (category_id, space) VALUES(4, 16);
INSERT INTO category_space (category_id, space) VALUES(4, 22);
INSERT INTO category_space (category_id, space) VALUES(4, 28);
INSERT INTO category_space (category_id, space) VALUES(4, 34);
INSERT INTO category_space (category_id, space) VALUES(4, 40);
INSERT INTO category_space (category_id, space) VALUES(4, 46);
INSERT INTO category_space (category_id, space) VALUES(4, 52);
INSERT INTO category_space (category_id, space) VALUES(4, 58);
INSERT INTO category_space (category_id, space) VALUES(4, 64);
INSERT INTO category_space (category_id, space) VALUES(4, 70);

INSERT INTO category_space (category_id, space) VALUES(5, 5);
INSERT INTO category_space (category_id, space) VALUES(5, 11);
INSERT INTO category_space (category_id, space) VALUES(5, 17);
INSERT INTO category_space (category_id, space) VALUES(5, 23);
INSERT INTO category_space (category_id, space) VALUES(5, 29);
INSERT INTO category_space (category_id, space) VALUES(5, 35);
INSERT INTO category_space (category_id, space) VALUES(5, 41);
INSERT INTO category_space (category_id, space) VALUES(5, 47);
INSERT INTO category_space (category_id, space) VALUES(5, 53);
INSERT INTO category_space (category_id, space) VALUES(5, 59);
INSERT INTO category_space (category_id, space) VALUES(5, 65);
INSERT INTO category_space (category_id, space) VALUES(5, 71);

INSERT INTO category_space (category_id, space) VALUES(6, 6);
INSERT INTO category_space (category_id, space) VALUES(6, 12);
INSERT INTO category_space (category_id, space) VALUES(6, 18);
INSERT INTO category_space (category_id, space) VALUES(6, 24);
INSERT INTO category_space (category_id, space) VALUES(6, 30);
INSERT INTO category_space (category_id, space) VALUES(6, 36);
INSERT INTO category_space (category_id, space) VALUES(6, 42);
INSERT INTO category_space (category_id, space) VALUES(6, 48);
INSERT INTO category_space (category_id, space) VALUES(6, 54);
INSERT INTO category_space (category_id, space) VALUES(6, 60);
INSERT INTO category_space (category_id, space) VALUES(6, 66);
INSERT INTO category_space (category_id, space) VALUES(6, 72);

INSERT INTO question (question, answer, category_id) VALUES ('What are the three main concepts of OOP?', 
                                                             'Inheritance, Encapsulation, Polymorphism',
                                                             1);
INSERT INTO question (question, answer, category_id) VALUES ('Which SQL statement is used to extract only records that fufill a specific condition?',
                                                             'WHERE',
                                                             2);
INSERT INTO question (question, answer, category_id) VALUES ('What is the default direction of contents in a Flex Box?',
                                                             'Row',
                                                             3);
INSERT INTO question (question, answer, category_id) VALUES ('Which Spring MVC annotation is used to tie a server url extension to a .jsp view?',
                                                             '@RequestMapping',
                                                             4);
INSERT INTO question (question, answer, category_id) VALUES ('True or False, two or more JavaScript variables can have the same name.',
                                                             'False',
                                                             5);
INSERT INTO question (question, answer, category_id) VALUES ('What is the name of the popular testing framework used in Tech Elevator?',
                                                             'JUnit',
                                                             6);

INSERT INTO game (game_code, active, winner_id, active_player_id) VALUES ('test', true, 1, 1); 	

COMMIT;
