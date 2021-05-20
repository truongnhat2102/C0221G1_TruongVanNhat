create database manage_internship;
use manage_internship;

create table faculty(
faculty_id char(10) not null primary key,
faculty_name char(30) null,
phone char(10) null);

create table instructor(
instructor_id int auto_increment primary key,
instructor_name char(30) null,
salary decimal(5,2) null,
faculty_id char(10) not null,
foreign key (faculty_id) references faculty(faculty_id));

create table student(
student_id int not null primary key,
student_name char(40) null,
faculty_id char(10) not null,
foreign key (faculty_id) references faculty(faculty_id),
date_of_birth date null,
place_of_birth char(30) null);

create table project(
project_id char(30) not null primary key,
project_name char(30) null,
expense int null,
place_of_intern char(30));


create table instructor_student(
student_id int not null,
foreign key (student_id) references student(student_id),
project_id char(10) ,
foreign key (project_id) references project(project_id),
instructor_id int ,
foreign key (instructor_id) references instructor(instructor_id),
grade decimal(5,2) null);
