CREATE TABLE USERS (
                       user_id INT PRIMARY KEY AUTO_INCREMENT,
                       name_user VARCHAR(100),
                       execute_role BOOLEAN
);

CREATE TABLE MESSAGES (
                          message_id INT PRIMARY KEY AUTO_INCREMENT,
                          name_user VARCHAR(100),
                          message_user_id int,
                          foreign key (message_user_id) references users (user_id)
);

CREATE TABLE tasks (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       id_message int,
                       name_task VARCHAR(100),
                       name_description VARCHAR(100),
                       state ENUM('PREPROCESS', 'PROCESS','POSTPROCESS'),
                       importance ENUM('LOW','HIGH','MIDDLE'),
                       foreign key (id_message) references messages (message_id)
);

INSERT INTO USERS VALUES(1, 'Vovan', false);
INSERT INTO USERS VALUES(2, 'Kolyan', true);

INSERT INTO MESSAGES VALUES(1, 'Refine first task', 1);
INSERT INTO TASKS VALUES(1,1,'Refine', 'Refine first task, Vovan', 'PREPROCESS','HIGH');