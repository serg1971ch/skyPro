-- liquibase formated sql

-- changeset author:1
CREATE TABLE faculties (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255),
                           color VARCHAR(255)
);

-- changeset author:2
CREATE INDEX faculty_color_index ON faculties (name, color);

-- changeset author:3
CREATE TABLE students (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          age INT,
                          faculty_id BIGINT,
                          FOREIGN KEY (faculty_id) REFERENCES faculties(id)
);

-- changeset author:4
CREATE INDEX student_name_index ON students (name);