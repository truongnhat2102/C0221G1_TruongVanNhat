select if (students is exists, "yes", create database students) ;
drop database students;
create schema students_management;
drop table students_management.`students`;
create table students_management.`students`(
`id` int not null auto_increment,
`name` varchar(255) not null,
`date_of_birth` date null,
primary key (id));

select * from students_management.`students`;

insert into students_management.`students` (`name`, `dateOfBirth`)
values ("nhat", "2000-02-21"),
("minh", "1998-1-1");

alter table students_management.`students`
add `country` varchar(255);

SET SQL_SAFE_UPDATES = 0;
update students_management.`students`
set `country` = "vietnam";
