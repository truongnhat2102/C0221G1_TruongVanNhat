-- create database score_management;
create table student(
idStudent int not null auto_increment primary key,
nameStudent varchar(250) null,
dateOfBirthStu date null,
class varchar(250) null,
GT varchar(250) null );

create table subjectt(
idSubject int not null auto_increment ,
nameSubject varchar(250) null,
idTeacher int not null ,
primary key (idSubject,idTeacher),
foreign key (idTeacher) references teacher(idTeacher));

create table transcript(
score int null,
dateOfTest date null,
idStudent int not null,
idSubject int not null,
primary key (idStudent,idSubject),
foreign key (idStudent) references student(idStudent),
foreign key (idSubject) references subjectt(idSubject));

create table teacher (
idTeacher int not null auto_increment primary key,
nameTeacher varchar(250) null,
phoneTeacher int null );