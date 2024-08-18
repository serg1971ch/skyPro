-- liquibase formated sql


-- changeset author:1
CREATE INDEX student_name_index on students (name);

-- changeset author:2
CREATE INDEX faculty_color_index on faculties (color, name);
