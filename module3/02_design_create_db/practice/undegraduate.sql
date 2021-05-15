create database if not exists undergraduate ;
CREATE TABLE if not exists Class
(
    id_class   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_class VARCHAR(60) NOT NULL,
    start_date DATETIME    NOT NULL,
    sta_tus    BIT
);
CREATE TABLE if not exists Student
(
    id_student   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_student VARCHAR(30) NOT NULL,
    address     VARCHAR(50),
    phone       VARCHAR(20),
    sta_tus      BIT,
    id_class     INT         NOT NULL,
    FOREIGN KEY (id_class) REFERENCES Class (id_class)
);
CREATE TABLE if not exists Subject
(
    id_subject   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_subject VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    sta_tus  BIT                  DEFAULT 1
);
CREATE TABLE if not exists Mark
(
    id_mark    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_subject     INT NOT NULL,
    id_student INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    exam_time TINYINT DEFAULT 1,
    UNIQUE (id_subject, id_student),
    FOREIGN KEY (id_subject) REFERENCES Subject (id_subject),
    FOREIGN KEY (id_student) REFERENCES Student (id_student)
);