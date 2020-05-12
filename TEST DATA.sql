BEGIN TRANSACTION;

INSERT INTO user_account (username, id_token, email) VALUES ('Joseph', 'awkdhadwahdajkhd12jeh12jhdawkdakdhad', 'joseph@programmerspursuit.com');
INSERT INTO user_account (username, id_token, email) VALUES ('kawjdkadhad', 'kjeiuqgdkjwadhawdawd12e812312dwadawfaf12313', 'kawjdkadhad@programmerspursuit.com');
INSERT INTO user_account (username, id_token, email) VALUES ('lemonface', '23jh89123y218diuadkaydahwdkjahdawidu12312', 'lemonface@programmerspursuit.com');
INSERT INTO user_account (username, id_token, email) VALUES ('noodles', '12491823y12821dbakwjdwahdawkjdgh12j3k1bdwad', 'noodles@programmerspursuit.com');

INSERT INTO game (game_id, game_code, active, active_player_id, active_player_roll, active_player_answering_question, active_player_category_selected_center) VALUES (1, 'TEST1', true, 1, 2, false, false);
INSERT INTO game (game_id, game_code, active, active_player_id, active_player_roll, active_player_answering_question, active_player_category_selected_center) VALUES (2, 'TEST2', true, 2, 3, false, false);
INSERT INTO game (game_id, game_code, active, active_player_id, active_player_roll, active_player_answering_question, active_player_category_selected_center) VALUES (3, 'TEST3', true, 3, 4, false, false);
INSERT INTO game (game_id, game_code, active, active_player_id, active_player_roll, active_player_answering_question, active_player_category_selected_center) VALUES (4, 'TEST4', true, 4, 5, false, false);

INSERT INTO player (username) VALUES ('Joseph');
INSERT INTO player (username) VALUES ('kawjdkadhad');
INSERT INTO player (username) VALUES ('lemonface');
INSERT INTO player (username) VALUES ('noodles');

INSERT INTO game_player (game_id, player_id, player_color, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_turn, is_answering_question, has_selected_category_center, player_roll)
VALUES (1, 1, 2, false, false, false, false, false, false, true, false, false, 2);
INSERT INTO game_player (game_id, player_id, player_color, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (1, 2, 4, false, false, false, false, false, false, false, false, 3);
INSERT INTO game_player (game_id, player_id, player_color, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (1, 3, 6, false, false, false, false, false, false, false, false, 4);
INSERT INTO game_player (game_id, player_id, player_color, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (1, 4, 1, false, false, false, false, false, false, false, false, 5);

INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (2, 1, 1, 60, false, false, false, false, false, false, false, false, 2);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_turn, is_answering_question, has_selected_category_center, player_roll)
VALUES (2, 2, 3, 53, false, false, false, false, false, false, true, false, false, 3);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (2, 3, 5, 42, false, false, false, false, false, false, false, false, 4);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (2, 4, 2, 3, false, false, false, false, false, false, false, false, 5);

INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (3, 1, 2, 35, true, true, true, true, true, true, false, false, 2);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (3, 2, 4, 41, true, true, true, true, true, true, false, false, 3);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_turn, is_answering_question, has_selected_category_center, player_roll)
VALUES (3, 3, 6, 67, true, true, true, true, true, true, true, false, false, 4);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (3, 4, 3, 67, true, true, true, true, true, true, false, false, 5);

INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (4, 1, 1, 4, false, false, false, false, false, false, false, false, 2);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (4, 2, 3, 4, false, false, false, false, false, false, false, false, 3);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (4, 3, 5, 4, false, false, false, false, false, false, false, false, 4);
INSERT INTO game_player (game_id, player_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_turn, is_answering_question, has_selected_category_center, player_roll)
VALUES (4, 4, 1, 70, false, false, false, false, false, false, true, false, false, 5);

INSERT INTO category (name) VALUES ('Java & OOP Fundamentals');
INSERT INTO category (name) VALUES ('SQL & Databases');
INSERT INTO category (name) VALUES ('HTML & CSS');
INSERT INTO category (name) VALUES ('Spring MVC & Design Patterns');
INSERT INTO category (name) VALUES ('JavaScript');
INSERT INTO category (name) VALUES ('Vue.js');

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

INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (1, 'What are the three (3) principles of Object-Oriented Programming?', 'Encapsulation, Inheritance, Polymorphism', 'Polymorphism, Inheritance, Composition', 'Encapsulation, Aggregation, Composition', 'Encapsulation, Inheritance, Polymorphism', 'Inheritance, Aggregation, Encapsulation');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (1, 'Which keyword is used in class''s declaration to inherit from another class?', 'extends', 'extends', 'inherits', 'overrides', 'implements');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (1, 'Which data structure represents a Last-In-First-Out (LIFO) collection of objects?', 'Stack', 'Queue', 'HashMap', 'ArrayList', 'Stack');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (1, 'Which data structure works in a First-In-First-Out (FIFO) manner?', 'Queue', 'Queue', 'HashMap', 'ArrayList', 'Stack');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (1, 'Which class do all Java classes inherit from?', 'System.Object', 'System.Class', 'System.Object', 'System.Java', 'System.Parent');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (1, 'Which keyword is used to ensure that a value can''t be changed once set?', 'final', 'final', 'static', 'readonly', 'const');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (1, 'Which keyword is used to indicate that a member is associated with a class (and not an instance of the class)?', 'static', 'final', 'readonly', 'static', 'const');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b)
        VALUES (1, 'Is multiple inheritance allowed in Java?', 'No', 'Yes', 'No');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'What is the testing method in which components are tested individually?', 'Unit Testing', 'Regression Testing', 'Unit Testing', 'Integration Testing', 'Smoke Testing');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'Which annotation is used before each jUnit test method?', '@Test', '@TestMethod', '@Testing', '@Test', '@JUnit');

-- ^^ I don't see why we couldn't do true/false. In JSP, you'll loop thru the list of possible answers to display as radio buttons.
-- In controller, check for null form inputs & filter out the non-null

INSERT INTO question (category_id, question,  correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (2, 'Which keyword is used to extract only records that fufill a specific condition?', 'WHERE', 'FROM', 'WHERE', 'LIKE', 'IN');
INSERT INTO question (category_id, question,  correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (2, 'Which keyword is used to display query results in descending order?', 'DESC', 'DESCENDING', 'DESC', 'DESCEND', 'DES');
INSERT INTO question (category_id, question,  correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (2, 'Which statement could be used to select all columns and rows from a table?', 'SELECT * FROM table', 'SELECT * FROM table', 'SELECT all FROM table', 'SELECT FROM table', 'SELECT ^ FROM table');
INSERT INTO question (category_id, question,  correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (2, 'Which function is used to retrieve a maximum value?', 'MAX()', 'MOST()', 'UPPER()', 'MAX()', 'TOP()');
INSERT INTO question (category_id, question,  correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (2, 'Which function is used to count the number of rows in a query?', 'COUNT()', 'TOTAL()', 'SUM()', 'NUMBER()', 'COUNT()');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (2, 'Which of the following is not a DDL command?', 'INSERT', 'TRUNCATE', 'INSERT', 'ALTER', 'None of the options are DDL commands');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (2, 'Which of the following is not a category of SQL commands?', 'DBL', 'DDL', 'DBL', 'DCL', 'DQL');

INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (3, 'What is the default direction of contents in a Flex Box?', 'Row', 'Row', 'Stretch', 'Span', 'Column');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (3, 'What does HTML stand for?', 'Hypertext Markup Language', 'Hypertext Markup Language', 'Hometext Markup Language', 'Hyperlink Text Markup Language', 'Hypertext Manipulation Language');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (3, 'The HTML tag for the largest heading is:', '< h1 >', '< h4 >', '< h6 >', '< h >', '< h1 >');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (3, 'HTML pages begin with the following tag:', '< !DOCTYPE html >', '< !DOCTYPE html >', '< head >', '< html >', '< body >');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (3, 'HTML IDs are referenced in CSS with which selector:', '#', '#', '@', '.', ':');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (3, 'Which tag is used to insert a line break?', '< br >', '< b >', '< break >', '< br >', '< /n >');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (3, 'HTML classes are referenced in CSS with which selector:', '.', '#', '@', '.', ':');
       
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (4, 'Which Spring MVC annotation is used to tie an HTTP request path to a Controller handler method?', '@RequestMapping', '@RequestRouting', '@RequestParam', '@RequestBody', '@RequestMapping');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (4, 'What does MVC stand for? (Format: Word1-Word2-Word3)', 'Model-View-Controller', 'Model-View-Coordinator', 'Model-ViewModel-Controller', 'Model-View-Control', 'Model-View-Controller');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (4, 'What does JSP stand for?', 'Java Server Pages', 'JavaScript Server Pages', 'Java Server Pages', 'Java Servlet Page', 'Java Server Package');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (4, 'Which data type is returned from a Controller method to reference a particular JSP file?', 'String', 'String', 'Array', 'Integer', 'ArrayList');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (4, 'Which data structure is used to store data from the Model to reference in a JSP?', 'Map', 'Set', 'Stack', 'Map', 'Array');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (4, 'Which Spring MVC annotation is used for Dependency Injection?', '@Autowired', '@Dependency', '@Autowired', '@Component', '@CrossOrigin');

INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (5, 'Which function is used to display a message in console?', 'console.log()', 'console.print()', 'console.write()', 'console.log()', 'console.println()');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (5, 'Which array function is used to iterate over the elements of an array?', 'forEach()', 'forEach()', 'for()', 'iterate()', 'map()');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (5, 'Which HTML element is used to contain JavaScript code?', '< script >', '< javascript >', '< style >', '< script >', '< js >');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (5, 'Which of the following is an invalid keyword used to declare variables:', 'All are valid keywords', 'var', 'const', 'let', 'All are valid keywords');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (5, 'The _______ method of an Array object adds and/or removes elements from an array', 'splice()', 'remove()', 'splice()', 'shift()', 'split()');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (5, '_______ is an input event that is fired when a user releases a key while on a particular DOM element:', 'keyup', 'keydown', 'keyup', 'keypress', 'keyclick');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (5, '_______ is an input event that is fired when a user presses down on a key while on a particular DOM element:', 'keydown', 'keyclick', 'keyup', 'keypress', 'keydown');

-- There are multiples of the pair of TDD questions because I didn't feel like coming up with any more when I did this. Will update - Brooks
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'Which keyword is associated with two-way data binding?', 'v-model', 'v-bind', 'v-sync', 'v-doublebind', 'v-model');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'In Vue.js, HTML is written within the following tag:', '< template >', '< vue >', '< template >', '< html >', '< body >');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'Which keyword is associated with two-way data binding?', 'v-model', 'v-bind', 'v-sync', 'v-doublebind', 'v-model');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'In Vue.js, HTML is written within the following tag:', '< template >', '< vue >', '< template >', '< html >', '< body >');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'Which keyword is associated with two-way data binding?', 'v-model', 'v-bind', 'v-sync', 'v-doublebind', 'v-model');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'In Vue.js, HTML is written within the following tag:', '< template >', '< vue >', '< template >', '< html >', '< body >');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'Which keyword is associated with two-way data binding?', 'v-model', 'v-bind', 'v-sync', 'v-doublebind', 'v-model');
INSERT INTO question (category_id, question, correct_answer, answer_choice_a, answer_choice_b, answer_choice_c, answer_choice_d)
        VALUES (6, 'In Vue.js, HTML is written within the following tag:', '< template >', '< vue >', '< template >', '< html >', '< body >');




INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 1, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 2, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 3, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 4, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 5, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 6, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 7, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 8, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 9, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 10, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 11, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 12, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 13, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 14, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 15, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 16, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 17, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 18, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 19, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 20, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 21, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 22, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 23, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 24, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 25, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 26, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 27, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 28, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 29, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 30, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 31, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 32, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 33, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 34, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 35, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 36, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 37, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 38, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 39, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 40, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 41, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 42, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 43, false);

INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 9, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 10, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 11, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 12, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 13, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 14, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 15, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 23, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 24, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 25, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 26, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 27, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 28, false);

INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 1, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 2, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 3, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 4, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 5, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 6, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 7, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 8, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 16, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 17, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 18, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 19, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 20, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 21, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 22, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 29, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 30, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 31, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 32, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 33, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 34, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 35, false);

INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 1, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 2, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 3, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 4, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 5, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 6, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 7, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 8, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 9, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 10, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 11, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 12, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 13, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 14, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 15, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 16, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 17, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 18, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 19, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 20, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 21, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 22, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 23, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 24, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 25, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 26, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 27, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 28, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 29, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 30, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 31, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 32, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 33, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 34, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 35, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 36, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 37, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 38, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 39, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 40, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 41, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 42, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 43, false);

COMMIT;