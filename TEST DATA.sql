
BEGIN TRANSACTION;

INSERT INTO user_account (username, id_token, email) VALUES ('Joseph', 'awkdhadwahdajkhd12jeh12jhdawkdakdhad', 'joseph@programmerspursuit.com');
INSERT INTO user_account (username, id_token, email) VALUES ('kawjdkadhad', 'kjeiuqgdkjwadhawdawd12e812312dwadawfaf12313', 'kawjdkadhad@programmerspursuit.com');
INSERT INTO user_account (username, id_token, email) VALUES ('lemonface', '23jh89123y218diuadkaydahwdkjahdawidu12312', 'lemonface@programmerspursuit.com');
INSERT INTO user_account (username, id_token, email) VALUES ('noodles', '12491823y12821dbakwjdwahdawkjdgh12j3k1bdwad', 'noodles@programmerspursuit.com');

INSERT INTO game (game_code, active, active_player_id, active_player_roll, active_player_answering_question, active_player_category_selected_center) VALUES ('TEST1', true, 1, 2, false, false);
INSERT INTO game (game_code, active, active_player_id, active_player_roll, active_player_answering_question, active_player_category_selected_center) VALUES ('TEST2', true, 2, 3, false, false);
INSERT INTO game (game_code, active, active_player_id, active_player_roll, active_player_answering_question, active_player_category_selected_center) VALUES ('TEST3', true, 3, 4, false, false);
INSERT INTO game (game_code, active, active_player_id, active_player_roll, active_player_answering_question, active_player_category_selected_center) VALUES ('TEST4', true, 4, 5, false, false);


INSERT INTO game_player (game_id, user_id, player_color, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_turn, is_answering_question, has_selected_category_center, player_roll)
VALUES (1, 1, 2, false, false, false, false, false, false, true, false, false, 2);
INSERT INTO game_player (game_id, user_id, player_color, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (1, 2, 4, false, false, false, false, false, false, false, false, 3);
INSERT INTO game_player (game_id, user_id, player_color, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (1, 3, 6, false, false, false, false, false, false, false, false, 4);
INSERT INTO game_player (game_id, user_id, player_color, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (1, 4, 1, false, false, false, false, false, false, false, false, 5);

INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (2, 1, 1, 60, false, false, false, false, false, false, false, false, 2);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_turn, is_answering_question, has_selected_category_center, player_roll)
VALUES (2, 2, 3, 53, false, false, false, false, false, false, true, false, false, 3);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (2, 3, 5, 42, true, true, true, true, true, true, false, false, 4);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (2, 4, 2, 3, true, true, true, true, true, true, false, false, 5);

INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (3, 1, 2, 35, true, true, true, true, true, true, false, false, 2);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (3, 2, 4, 41, true, true, true, true, true, true, false, false, 3);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_turn, is_answering_question, has_selected_category_center, player_roll)
VALUES (3, 3, 6, 67, true, true, true, true, true, true, true, false, false, 4);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (3, 4, 3, 67, true, true, true, true, true, true, false, false, 5);

INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (4, 1, 1, 4, true, true, true, true, true, true, false, false, 2);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (4, 2, 3, 4, true, true, true, true, true, true, false, false, 3);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_answering_question, has_selected_category_center, player_roll)
VALUES (4, 3, 5, 4, true, true, true, true, true, true, false, false, 4);
INSERT INTO game_player (game_id, user_id, player_color, player_position, player_score_cat_1, player_score_cat_2, player_score_cat_3, player_score_cat_4, player_score_cat_5, player_score_cat_6, is_turn, is_answering_question, has_selected_category_center, player_roll)
VALUES (4, 4, 1, 70, true, true, true, true, true, true, true, false, false, 5);


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

INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'What are the three (3) principles of Object-Oriented Programming?','Encapsulation, Inheritance, Polymorphism','Polymorphism, Inheritance, Composition','Encapsulation, Aggregation, Composition','Encapsulation, Inheritance, Polymorphism','Inheritance, Aggregation, Encapsulation');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which keyword is used in class''s declaration to inherit from another class?','extends','extends','inherits','overrides','implements');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which data structure represents a Last-In-First-Out (LIFO) collection of objects?','Stack','Queue','HashMap','ArrayList','Stack');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which data structure works in a First-In-First-Out (FIFO) manner?','Queue','Queue','HashMap','ArrayList','Stack');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which class do all Java classes inherit from?','System.Object','System.Class','System.Object','System.Java','System.Parent');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which keyword is used to ensure that a value can''t be changed once set?','final','final','static','readonly','const');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which keyword is used to indicate that a member is associated with a class (and not an instance of the class)?','static','final','readonly','static','const');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (1,'Is multiple inheritance allowed in Java?','No','Yes','No');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'ClassA inherets from Class B. Class B is a _______.','subclass','subclass','child-class','second-class','superclass');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'What is a method of a class that initializes an object of that type?','constructor','constructor','initializer','build','final');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'What are the two most common access modifiers?','public and private','public and private','get and set','int and String','if and for');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (1,'True or false: Overloaded methods must have the same name.','TRUE','TRUE','FALSE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (1,'True or false: Overloaded methods must have the same return type.','TRUE','TRUE','FALSE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (1,'True or false: Overloaded methods must differ in the number of parameters and/or parameter types.','TRUE','TRUE','FALSE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'What is the time it takes to access something in an array if you know its position?','O(1)','O(1)','O(N)','O(N^2)','O(M)');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'what is the time it takes to loop through an array?','O(N)','O(N)','O(1)','O(N^2)','O(M)');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'What is the time it takes to run a nested loop?','O(N^2)','O(N^2)','O(1)','O(N)','O(M)');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'When an application runs, what is the memory space set up for it called','The Stack','The Stack','The Heap','The RAM','the data array');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'The ___ is the memory space where arrays and objects go','the heap','the heap','the stack','The RAM','the data array');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which symbol asserts equality in conditional statements','==','==','=','>=','+=');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which symbol is the assignment operator','=','=','==','>=','+=');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which data type is whole numbers only?','Integer','Integer','Long','Double','Var');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Which data type can support decimals?','Double','Double','Integer','Long','Chr');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'What keyword is used to import a package, class or interface','Import','Import','Get','Retrieve','Unpack');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'What is the last step in the completion of a method?','Return','Return','Finish','Finally','Go');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (1,'Return must return a data in a data type','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'What is a non-access modifier used for classes, attributes and methods, which makes them non-changeable','Final','Final','Private','Const','Public');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'Information can be passed to methods as a ___','parameter','parameter','member','value','constructor');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'With ___, methods can have the same name with different parameters','Overloading','Overloading','Overthrowing','Overwriting','Overriding');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (1,'A ___ class cannot be used to create objects','Abstract','Abstract','Private','Public','Overridden');


INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Which keyword is used to extract only records that fufill a specific condition?','WHERE','FROM','WHERE','LIKE','IN');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Which keyword is used to display query results in descending order?','DESC','DESCENDING','DESC','DESCEND','DES');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Which statement could be used to select all columns and rows from a table?','SELECT * FROM table','SELECT * FROM table','SELECT all FROM table','SELECT FROM table','SELECT ^ FROM table');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Which function is used to retrieve a maximum value?','MAX()','MOST()','UPPER()','MAX()','TOP()');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Which function is used to count the number of rows in a query?','COUNT()','TOTAL()','SUM()','NUMBER()','COUNT()');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Which of the following is not a DDL command?','INSERT','TRUNCATE','INSERT','ALTER','None of the options are DDL commands');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Which of the following is not a category of SQL commands?','DBL','DDL','DBL','DCL','DQL');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Insert the missing statement to get all the columns from the Animals table: ____ * FROM Customers;','SELECT','SELECT','GRAB','GET','PULL');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'A ___ database is made up of tables that contain columns where each column has a name and a data type','relational','relational','structural','distributed','joined');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'What does SQL stand for?','Structured Query Language','Structured Query Language','Single Query Lithograph','Structured Question Link','Sample Query Language');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'What is the PostgreSQL propritary data type that is an auto-incrementing integer used for unique values','SERIAL','SERIAL','SPECIFIC','COUNT','UNIQUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'One of the main ways that data gets stolen or destroyed in web applications is via an attack called a(n)...','SQL injection','SQL injection','data leak','Code injection','Cross site attack');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'This type of SQL statement can protect against attacks.','Paramaterized statement','Paramaterized statement','Fixed statement','Protected statement','Inside statement');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'What is used to hide original data by scrambling it into something new and not repeatable?','Hashing','Hashing','Encryption','Hiding','Protecting');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'What  is used to scramble data in a way that can be reversed?','Encryption','Encryption','Hashing','Hiding','Protecting');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'What is a fixed-length, cryptographically-strong random value usually added to the end of a hash','salt','salt','hash brown','hash suffix','randomizer');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'A ___ is a vertical entity in a table that contains all information associated with a specific field in a table.','column','column','row','box','pillar');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'A(n) ___ value in a table is a value in a field that appears to be blank','null','null','empty','constrained','constant');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Q 8 - Which of the following code will remove all the rows from the table LOCATIONS?','TRUNCATE TABLE locations;','TRUNCATE TABLE locations;','DROP TABLE locations;','DELETE TABLE locations;','None of the above.');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'Transactions have the following four standard properties, usually referred to by the acronym _. _. _. _.','ACID','ACID','BEAR','CORN','CRSS');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'This property of transactions ensures that the database properly changes states upon a successfully committed transaction','Consistancy','Consistancy','Isolation','Atomicity','Stateless');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'The transaction control ___ is used to save the changes.','COMMIT','COMMIT','ROLLBACK','BEGIN TRANSATION','SET TRANSACTION');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'The transaction control ___ is used to roll back the changes.','ROLLBACK','ROLLBACK','COMMIT','BEGIN TRANSATION','SET TRANSACTION');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'The transaction control ___ is used to set the follwing SQL in a transactoin.','BEGIN TRANSATION','BEGIN TRANSATION','ROLLBACK','COMMIT','SET TRANSACTION');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'A ___ JOIN returns rows when there is a match in both tables.','INNER','INNER','CENTER','FULL','SELF');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'A ___ JOIN returns all rows from the left table, even if there are no matches in the right table','LEFT','LEFT','INNER','CENTER','FULL');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'A ___ JOIN returns rows when there is a match in one of the tables.','FULL','FULL','LEFT','INNER','CENTER');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'The ___ uniquely identifies a row/record in any of the given database tables.','FOREIGN Key','FOREIGN Key','PRIMARY Key','DEFAULT Constraint','INDEX');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (2,'True or False. Any constraint that you have defined can be dropped using the ALTER CONSTRAINT command','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (2,'A ___ is a query within another SQL query and embedded within the WHERE clause.','All of the above','All of the above','Inner query','Nested query','Subquery');



INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'What is the default direction of contents in a Flex Box?','Row','Row','Stretch','Span','Column');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'What does HTML stand for?','Hypertext Markup Language','Hypertext Markup Language','Hometext Markup Language','Hyperlink Text Markup Language','Hypertext Manipulation Language');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'The HTML tag for the largest heading is:','< h1 >','< h4 >','< h6 >','< h >','< h1 >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'HTML pages begin with the following tag:','< !DOCTYPE html >','< !DOCTYPE html >','< head >','< html >','< body >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'HTML IDs are referenced in CSS with which selector:','#','#','@','.',':');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Which tag is used to insert a line break?','< br >','< b >','< break >','< br >','< /n >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'HTML classes are referenced in CSS with which selector:','.','#','@','.',':');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (3,'Which is the correct way to print out the world *Hello* in an HTML document?','< p >Hello< /p >','< p >"Hello"< /p >','< p >Hello< /p >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Which is not a possible way to allow use of CSS in an HTML file?','Importing the CSS file in the HTML < header > tag','Importing the CSS file in the HTML < head > tag','Using in-line style tags','Adding CSS in a < style > block','Importing the CSS file in the HTML < head > tag');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'How many different heading tags are there?','Six','Three','Four','Five','Six');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (3,'Which of these is the correct way to add a left margin to an element in the style block?','margin-left: 10px;','margin-left: 10px;','margin-left: 10 px;');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (3,'What is margin?','The outer space of an element','The outer space of an element','The inner space of an element');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (3,'What is padding?','The inner space of an element','The inner space of an element','The outer space of an element');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Can you use the *auto* value on margin, padding, both or neither?','Margin','Padding','Both','Margin','Neither');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Which CSS property do you use to specify animation styles?','@keyframes','@keyframes','@animation','@animate','@transition');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Who is making the Web standards?','World Wide Web Consortium','Oracle','Mozilla','World Wide Web Consortium','Microsoft');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Which is the correct HTML for adding a green font color?','< h1 style="color:green;" >This is a green heading< /h1 >','< h1 color=green>This is a green heading< /h1 >','< h1 font-color:green >This is a green heading< /h1 >','< h1 style="color:green;" >This is a green heading< /h1 >','< h1 font-color: "green" >This is a green heading< /h1 >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Choose the correct HTML tag to only change the appearance of text to bold:','< b >','< strong >','< b >','< bold >','< important >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Choose the correct HTML for creating a hyperlink:','< a href="programmerspursuit.com" Programmers'' Pursuit< /a >','< a url="programmerspursuit.com" Programmers'' Pursuit< /a >','< a link="programmerspursuit.com" Programmers'' Pursuit< /a >','< a website="programmerspursuit.com" Programmers'' Pursuit< /a >','< a href="programmerspursuit.com" Programmers'' Pursuit< /a >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'What type of display is a div element?','block','inline','inline-block','block','block-inline');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Which of the following is the default value for the justify-content property?','flex-start','flex-start','flex-end','center','inherit');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Which of the following is an invalid HTML input type?','symbol','symbol','color','file','week');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'What is the only type of element you can put inside of < ul > or < ol > ?','< li >','< li >','< p >','< i >','< a >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'How do you write a comment in HTML?','< !-- comment here -- >','< !-- comment here -- >','< %-- comment here --% >','/* comment here */','/** comment here */');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'How do write a comment in CSS?','/* comment here */','/* comment here */','< !-- comment here -- >','// comment here','/** comment here */');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Which of the follow is in invalid declaration of the background color property?','background-color:white, 50%;','background-color:white, 50%;','background-color:hsla(9, 100%, 64%, 0.5);','background-color:#ff6347;','background-color:MediumSeaGreen;');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (3,'Where is the < head > element placed?','Within the < html > block and above the < body > block','Within the < html > block and above the < body > block','Within the < body > block','Below the < html > block and above the < body > block','Above the < html > block');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (3,'TRUE or FALSE: An image is a block element.','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c) 
        VALUES (3,'Will HTML elements display correctly if you don''t provide the closing tag?','It''s valid syntax, but it can cause problems so it is discouraged.','It''s valid syntax, but it can cause problems sometimes so it is discouraged.','No, it is invalid syntax so the elements will not display properly.','Yes, the browsers are able to infer where closing tags should be so the HTML displays correctly.');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (3,'TRUE or FALSE: You need to specify the < !DOCTYPE > of an HTML file.','TRUE','TRUE','FALSE');

       
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Which Spring MVC annotation is used to tie an HTTP request path to a Controller handler method?','@RequestMapping','@RequestRouting','@RequestParam','@RequestBody','@RequestMapping');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'What does MVC stand for? (Format: Word1-Word2-Word3)','Model-View-Controller','Model-View-Coordinator','Model-ViewModel-Controller','Model-View-Control','Model-View-Controller');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'What does JSP stand for?','Java Server Pages','JavaScript Server Pages','Java Server Pages','Java Servlet Page','Java Server Package');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Which data type is returned from a Controller method to reference a particular JSP file?','String','String','Array','Integer','ArrayList');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Which data structure is used to store data from the Model to reference in a JSP?','Map','Set','Stack','Map','Array');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Which Spring MVC annotation is used for Dependency Injection?','@Autowired','@Dependency','@Autowired','@Component','@CrossOrigin');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'In Java, what is a simple Java class that represents the data of the app.','model','model','controller','view','object');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Models are instantiated and populated from within a ___.','controller','controller','Model','View','Browser');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'The ___ method is used to send data to a server so that it can be created on the server.','POST','POST','GET','PUT','DELETE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'In MVC, which one plays the mediator role for between other two?','Controller','Controller','Model','View','HTML');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'What in MVC makes up the pieces of an application that are used to display the user interface.','View','View','Model','Controller','JavaScript');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'It is important to understand that MVC alone is a ___.','design pattern','design pattern','framework','company','product');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'The first T in HTTP stands for ___.','Transfer','Transfer','Text','Task','Time');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'_ _ _ _ is a lightweight data-interchange format','JSON','JSON','HTML','JDBC','HTTP');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'REST uses which of the standard web technologies?','HTTP','HTTP','URLs','JSON','APIs');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Most applications you create consist of ___, which are the objects defined in the application.','resources','resources','JSON','private data','public methods');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'The C operation in CRUD is imlpemented by this HTTP method','GET','GET','PUT','POST','DELETE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'An operation is ___ if it produces the same result regardless of the number of times it is performed.','idempotent','idempotent','independant','atomicitus','inherited');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Which HTTP status code is for Client Errors?','4xx','4xx','1xx','5xx','4xx');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Which of the following is an often used bean validation annotation?','@NotNull','@NotNull','@RequestMapping','@Assert','@CrossOrigin');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'URL stands for ___.','Uniform Resource Locator','Uniform Resource Locator','Uniform Request Lock','Unique Request List','Unique Request Locator');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Domains cannot be registered under which TLD.','.arpa','.arpa','.co','.edu','.gov');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Which number in URLs is always needed but rarely seen?','Port','Port','Protocol','Creation','HTTP');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'HTTP communication consists of 2 things, a ___ and a ___. (Format: Word1-Word2)','Request-Respose','Request-Respose','Pull-Push','Get-Post','Object-Class');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (4,'True or false, the client sends a request again if they recieve a 404 status code.','TRUE','TRUE','FALSE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'This part of the URL is an internal page reference, sometimes called a named anchor.','Fragment','Fragment','Subdomain','Domain Name','Protocol');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'MVC is a design pattern for a ___-Side API.','Server','Server','Client','Front','Model');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'You can use the ___ annotation to have method arguments deserialized into an Object','@RequestBody','@RequestBody','@RequestMapping','@RequestRouting','@RequestParam');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'A Web API ___ is the URL that you use to access an API.','endpoint','endpoint','request','object','layer');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (4,'Which of the following means to convert an object into a string','serialize','serialize','deserialize','stringify','cast');



INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'Which function is used to display a message in console?','console.log()','console.print()','console.write()','console.log()','console.println()');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'Which array function is used to iterate over the elements of an array?','forEach()','forEach()','for()','iterate()','map()');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'Which HTML element is used to contain JavaScript code?','< script >','< javascript >','< style >','< script >','< js >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'Which of the following is an invalid keyword used to declare variables:','All are valid keywords','var','const','let','All are valid keywords');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'The _______ method of an Array object adds and/or removes elements from an array','splice()','remove()','splice()','shift()','split()');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'_______ is an input event that is fired when a user releases a key while on a particular DOM element:','keyup','keydown','keyup','keypress','keyclick');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'_______ is an input event that is fired when a user presses down on a key while on a particular DOM element:','keydown','keyclick','keyup','keypress','keydown');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'TRUE or FALSE: JavaScript is a dynamic language.','TRUE','TRUE','FALSE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'TRUE or FALSE: JavaScript is based off of Java.','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'Can you have two variables with the same name but different cases? (Ex: variable and Variable)','Yes','No','No');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'Do you need to declare a data type in JavaScript? (Ex: string numberOfPiePieces)','No','No','Yes');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'Which of the following means a variable has been declared but has not been assigned a value?','undefined','undefined','null');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'What will happen if you assign a new value to a const variable?','You will get an error','You will get an error','The variable''s value will be updated','A second variable of the same name is created with the new value','The program will crash');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'Do you have to declare a const variable''s value when you initialize it?','Yes','Yes','No');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'Do you have to declare a let variable''s value when you initialize it?','No','No','Yes');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'TRUE or FALSE: This is valid syntax: const a = 1, b = 2','TRUE','TRUE','FALSE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'What is the following called in JavaScript?: ${...}','template literal','template literal','JSTL','HTML expression','JavaScript expression');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'How do you declare an object in JavaScript?','const obj = { var a , var b }','const obj = [ var a, var b ]','const obj = { var a , var b }','const obj = var a, var b','const obj = ( var a, var b )');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'What happens if you have an array with three elements and you run the following code?: array.length = 2','The third element is cut off and the array becomes two elements','The third element is cut off and the array becomes two elements','You get an error','Nothing happens because length is zero-based, so length 2 is still three elements','The line of code is ignored because it is invalid');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'How do you remove an element from the beginning of an array in JavaScript?','shift()','shift()','unshift()','push()','pop()');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'How do you add an element to the beginning of an array in JavaScript?','unshift()','unshift()','shift()','push()','pop()');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'How do you join two arrays named "a" and "b"?','a.concat(b)','a.concat(b)','a + b','a.add(b)','a.join(b)');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'How do you check if an element is within an array?','includes()','includes()','find()','contains()','has()');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'Is there an error in this isolated code?: for (i = 0; i < 5; i++) { console.log("Programmers Pursuit"); }','Yes','Yes','No');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'Are parentheses required around parameters in arrow functions to the left of the arrow if there is only one variable?','No','No','Yes');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'If the variable "age" is equal to null, will the following return true or false?: if(age) {...}','TRUE','TRUE','FALSE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'If the variable "age" is equal to undefined, will the following return true or false?: if(age) {...}','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'How do you set default values for parameters in JavaScript functions?','function repeatWord(word = "hello") {...}','function repeatWord(word = "hello") {...}','function repeatWord(word (default = "hello")) {..}','function repeatWord(word default = "hello") {...}','function repeatWord(word, default = "hello") {...}');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (5,'What makes a function anonymous?','It doesn''t have a name','It doesn''t have a name','There isn''t a specified return value','The function is nested within another function so it''s not directly accessible','The function is called behind the scenes so programmers don''t see it');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (5,'How do you access nested values in JavaScript objects?','obj.a.b.c','obj.a.b.c','obj[a][b][c]');


INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'Is Vue a JavaScript library or framework?','Framework','Framework','Library');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'Which is the correct syntax for using a JavaScript variable value in the template section?','< p > {{ someVariable }} < /p >','< p > {{ someVariable }} < /p >','< p > ${ someVariable } < /p >','< p > ${{ someVariable }} < /p >','< p ${ someVariable } > < /p >');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'How do you create a Vue app using the Vue CLI?','vue create app-name-here','vue create app-name-here','vue -c app-name-here','vue create app app-name-here','vue -c app app-name-here');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'By default, in which Vue component file do the other components live?','App.vue','App.vue','Main.vue','Components.vue','Vue.vue');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'What does the keyword "scoped" mean when placed within the style tag?','The CSS within the style block will only apply to the current component','The CSS within the style block will only apply to the current component','The CSS within the style block will apply to the entire app');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'TRUE or FALSE: You need to use the Vue CLI to create new Vue projects.','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'How would you add an event listener that called the "repeatWord" method on click in Vue?','v-on:click="repeatWord"','v-on:click="repeatWord"','v-on-click:repeatWord','v-onClick="repeatWord"','v-click="repeatWord"');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'Which directive is used for two-way data binding?','v-model','v-model','v-on','v-for','v-bind');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'How do you write a for loop in the template section of a component?','v-for="item in items"','v-for="item in items"','v-for-each="item in items"','v:forEach="item in items"','v:for="item in items"');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'TRUE or FALSE: the created hook runs code after the DOM has rendered','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'TRUE or FALSE: Event listeners are automatically removed when a DOM element is destroyed.','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'When is the mounted hook called?','After the DOM has been rendered','After the DOM has been rendered','Before the DOM has been rendered');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'What does the computed hook contain?','Properties that rely on outside data values','Properties that rely on outside data values','Methods that involve math','Methods that store/retrieve data in the computer''s hardware','Properties that are retrieved from outside files');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'How do you install Vue globally on your machine using the CLI?','npm install -g @vue/cli','npm install -g @vue/cli','npm install vue-cli','npm -g install vue-cli','npm install vue/cli -g');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'What is the shorthand version of adding a click event listener to an element in the template?','@click="someMethodName"','@click="someMethodName"',':click="someMethodName"',':onClick="someMethodName"','@onClick="someMethodName"');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'Which of the following modifiers would disable the default behavior of an element?','.prevent','.prevent','.stop','.disable','.default');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'How do you prevent an event from bubbling up the DOM tree?','.stop','.stop','.prevent','.disable','.default');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'What is the difference between props and data?','props pass data from parent to children, while data is private','props passes data from parent to children, while data is private','data passes data from parent to children, while props is private');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'What does the following line of code do? < MyComponent name="playerOne" />','Passes the prop "name" with the value of "playerOne" to the MyComponent component','Passes the prop "name" with the value of "playerOne" to the MyComponent component','Gives a name to the MyComponent component so that it''s reusable in the code','Sets the "name" CSS property with a value of "playerOne" in MyComponent','Nothing, it''s invalid syntax');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'TRUE or FALSE: v-if and v-else should be in the same template attribute','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'Which directive is used for one-way data binding?','v-bind','v-model','v-on','v-for','v-bind');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'Which directive still renders the template element when the condition is false?','v-show','v-show','v-if');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'Should you use v-model or v-bind on form elements?','v-model','v-model','v-bind');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'Which of the following is not a Vue lifecycle hook?','removed','removed','created','updated','destroyed');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'What type of data structure is the virtual DOM?','Tree','Tree','Linear','Hash','Graph');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'TRUE or FALSE: you can put HTML directly in the < script > section of a component.','FALSE','FALSE','TRUE');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'Which data-binding interpolation is known as "mustache" syntax?','{{ }}','{{ }}','[ ]','v-on','v-model');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b) 
        VALUES (6,'Does the following code contain an error? : < a v-click="performtask" > click < /a >','Yes','Yes','No');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'What does MVVM stand for?','Model-view-viewmodel','Model-view-viewmodel','Model-vue-viewmodel','Model-view-valuemodel','Model-value-vuemodel');
INSERT INTO question(category_id,question,correct_answer,answer_choice_a,answer_choice_b,answer_choice_c,answer_choice_d) 
        VALUES (6,'Which directive is used to attach event listeners that invoke methods?','v-on','v-on','v-model','v-for','v-bind');

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
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 44, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 45, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 46, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 47, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 48, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 49, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 50, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 51, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 52, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 53, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 54, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 55, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 56, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 57, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 58, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 59, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 60, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 61, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 62, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 63, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 64, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 65, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 66, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 67, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 68, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 69, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 70, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 71, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 72, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 73, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 74, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 75, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 76, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 77, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 78, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 79, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 80, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 81, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 82, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 83, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 84, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 85, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 86, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 87, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 88, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 89, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 90, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 91, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 92, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 93, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 94, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 95, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 96, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 97, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 98, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 99, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 100, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 101, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 102, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 103, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 104, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 105, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 106, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 107, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 108, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 109, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 110, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 111, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 112, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 113, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 114, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 115, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 116, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 117, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 118, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 119, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 120, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 121, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 122, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 123, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 124, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 125, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 126, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 127, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 128, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 129, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 130, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 131, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 132, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 133, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 134, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 135, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 136, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 137, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 138, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 139, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 140, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 141, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 142, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 143, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 144, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 145, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 146, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 147, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 148, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 149, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 150, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 151, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 152, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 153, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 154, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 155, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 156, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 157, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 158, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 159, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 160, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 161, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 162, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 163, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 164, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 165, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 166, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 167, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 168, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 169, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 170, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 171, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 172, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 173, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 174, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 175, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 176, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 177, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 178, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 179, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (1, 180, false);


INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 31, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 32, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 33, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 34, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 35, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 36, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 37, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 38, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 39, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 40, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 41, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 42, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 43, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 44, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 45, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 46, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 47, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 48, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 49, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 50, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 51, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 52, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 53, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 54, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 55, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 56, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 57, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 58, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 59, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 60, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 91, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 92, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 93, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 94, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 95, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 96, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 97, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 98, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 99, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 100, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 101, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 102, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 103, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 104, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 105, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 106, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 107, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 108, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 109, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 110, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 111, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 112, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 113, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 114, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 115, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 116, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 117, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 118, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 119, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (2, 120, false);


INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 1, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 2, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 3, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 4, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 5, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 6, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 7, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 8, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 9, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 10, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 11, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 12, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 13, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 14, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 15, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 16, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 17, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 18, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 19, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 20, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 21, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 22, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 23, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 24, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 25, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 26, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 27, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 28, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 29, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 30, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 61, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 62, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 63, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 64, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 65, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 66, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 67, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 68, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 69, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 70, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 71, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 72, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 73, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 74, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 75, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 76, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 77, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 78, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 79, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 80, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 81, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 82, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 83, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 84, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 85, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 86, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 87, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 88, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 89, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 90, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 121, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 122, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 123, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 124, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 125, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 126, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 127, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 128, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 129, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 130, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 131, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 132, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 133, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 134, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 135, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 136, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 137, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 138, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 139, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 140, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 141, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 142, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 143, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 144, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 145, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 146, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 147, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 148, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 149, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (3, 150, false);



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
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 44, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 45, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 46, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 47, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 48, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 49, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 50, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 51, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 52, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 53, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 54, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 55, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 56, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 57, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 58, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 59, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 60, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 61, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 62, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 63, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 64, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 65, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 66, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 67, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 68, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 69, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 70, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 71, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 72, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 73, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 74, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 75, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 76, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 77, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 78, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 79, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 80, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 81, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 82, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 83, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 84, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 85, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 86, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 87, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 88, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 89, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 90, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 91, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 92, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 93, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 94, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 95, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 96, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 97, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 98, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 99, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 100, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 101, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 102, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 103, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 104, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 105, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 106, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 107, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 108, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 109, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 110, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 111, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 112, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 113, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 114, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 115, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 116, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 117, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 118, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 119, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 120, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 121, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 122, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 123, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 124, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 125, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 126, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 127, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 128, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 129, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 130, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 131, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 132, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 133, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 134, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 135, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 136, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 137, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 138, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 139, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 140, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 141, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 142, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 143, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 144, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 145, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 146, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 147, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 148, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 149, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 150, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 151, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 152, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 153, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 154, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 155, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 156, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 157, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 158, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 159, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 160, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 161, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 162, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 163, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 164, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 165, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 166, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 167, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 168, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 169, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 170, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 171, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 172, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 173, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 174, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 175, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 176, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 177, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 178, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 179, false);
INSERT INTO game_question (game_id, question_id, asked) VALUES (4, 180, false);


COMMIT;