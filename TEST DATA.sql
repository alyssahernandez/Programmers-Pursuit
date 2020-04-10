--TEST DATA
BEGIN TRANSACTION;

INSERT INTO game (game_id, game_code, active, active_player_roll) VALUES (1, 'TEST1', true, 2);
INSERT INTO game (game_id, game_code, active, active_player_roll) VALUES (2, 'TEST2', false, 3);
INSERT INTO game (game_id, game_code, active, active_player_roll) VALUES (3, 'TEST3', false, 4);
INSERT INTO game (game_id, game_code, active, active_player_roll) VALUES (4, 'TEST4', false, 5);

INSERT INTO player (player_id, name) VALUES (1,'Joeseph'); 
INSERT INTO player (player_id, name) VALUES (2,'kawjdkadhad');
INSERT INTO player (player_id, name) VALUES (3, 'lemonface');
INSERT INTO player (player_id, name) VALUES (4, 'noodles');

INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (1, 1, 2, 0, true, false, true, false, false, false);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (1, 2, 4, 12, false, true, false, true, false, false);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (1, 3, 6, 53, false, false, true, false, true, false);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (1, 4, 1, 53, false, false, false, true, false, true);

INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (2, 1, 1, 60, true, true, true, false, false, false);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (2, 2, 3, 53, false, false, false, true, true, true);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (2, 3, 5, 42, true, false, true, false, true, false);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (2, 4, 2, 3, false, true, false, true, false, true);

INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (3, 1, 2, 35, true, true, true, true, true, true);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (3, 2, 4, 41, true, true, true, true, true, true);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (3, 3, 6, 67, true, true, true, true, true, true);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (3, 4, 3, 67, true, true, true, true, true, true);

INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (4, 1, 1, 4, false, false, false, false, false, true);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (4, 2, 3, 4, false, false, false, false, true, false);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (4, 3, 5, 4, false, true, false, false, false, false);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6) 
VALUES (4, 4, 1, 70, true, false, false, false, false, false);

INSERT INTO category (name) VALUES ('Java OOP');
INSERT INTO category (name) VALUES ('SQL');
INSERT INTO category (name) VALUES ('HTML/CSS');
INSERT INTO category (name) VALUES ('MVC');
INSERT INTO category (name) VALUES ('JavaScript');
INSERT INTO category (name) VALUES ('TDD');

INSERT INTO category_game (category_id, game_id) VALUES (1, 1);
INSERT INTO category_game (category_id, game_id) VALUES (2, 1);
INSERT INTO category_game (category_id, game_id) VALUES (3, 1);
INSERT INTO category_game (category_id, game_id) VALUES (4, 1);
INSERT INTO category_game (category_id, game_id) VALUES (5, 1);
INSERT INTO category_game (category_id, game_id) VALUES (6, 1);

INSERT INTO category_game (category_id, game_id) VALUES (2, 2);
INSERT INTO category_game (category_id, game_id) VALUES (4, 2);

INSERT INTO category_game (category_id, game_id) VALUES (1, 3);
INSERT INTO category_game (category_id, game_id) VALUES (3, 3);
INSERT INTO category_game (category_id, game_id) VALUES (5, 3);

INSERT INTO category_game (category_id, game_id) VALUES (1, 4);
INSERT INTO category_game (category_id, game_id) VALUES (2, 4);
INSERT INTO category_game (category_id, game_id) VALUES (3, 4);
INSERT INTO category_game (category_id, game_id) VALUES (4, 4);
INSERT INTO category_game (category_id, game_id) VALUES (5, 4);
INSERT INTO category_game (category_id, game_id) VALUES (6, 4);

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

--all 6 questions above put into games 1 and 2
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 1, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 2, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 3, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 4, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 5, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 6, false);

INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 1, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 2, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 3, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 4, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 5, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 6, false);

UPDATE game
SET active_player_id = 1
WHERE game_code = 'TEST1';

UPDATE game
SET active_player_id = 2
WHERE game_code = 'TEST2';

UPDATE game
SET active_player_id = 3
WHERE game_code = 'TEST3';

UPDATE game
SET active_player_id = 4
WHERE game_code = 'TEST4';

COMMIT;