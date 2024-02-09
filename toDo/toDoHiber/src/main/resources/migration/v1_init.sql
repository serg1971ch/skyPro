CREATE TABLE USERS (
                      user_id INT PRIMARY KEY,
                      name_user VARCHAR(100),
                      execute_role BOOLEAN
);

CREATE TABLE MESSAGES (
                       message_id INT PRIMARY KEY,
                       name_user VARCHAR(100),
                       user_id int,
                       foreign key (user_id) references users (user_id)
);

CREATE TABLE tasks (
                       id INT PRIMARY KEY ,
                       message_id int,
                       name_task VARCHAR(100),
                       name_description VARCHAR(100),
                       state varchar(100),
                       importance varchar(100),
                       foreign key (message_id) references messages (message_id)
);

INSERT INTO USERS VALUES(1, 'Vovan', false);
INSERT INTO USERS VALUES(2, 'Kolyan', true);

INSERT INTO MESSAGES VALUES(1, 'Refine first task', 1);
INSERT INTO TASKS VALUES(1,1,'Refine', 'Refine first task, Vovan', 'PREPROCESS','HIGH');