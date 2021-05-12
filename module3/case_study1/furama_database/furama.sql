create database Furama;
create table Furama.Villa (
`idService` varchar(250) not null,
`useArea` int null,
`maxPeople` int null,
`typeOf` varchar(250) null,
`standardRoom` varchar(250) null,
`poolArea` int null,
`floors` int null,
`serviceGoWith` varchar(250) null,
primary key (`idService`));


create table Furama.House (
`idService` varchar(250) not null,
`useArea` int null,
`maxPeople` int null,
`typeOf` varchar(250) null,
`standardRoom` varchar(250) null,
`floors` int null,
`serviceGoWith` varchar(250) null,
primary key (`idService`));

create table Furama.Room (
`idService` varchar(250) not null,
`useArea` int null,
`maxPeople` int null,
`typeOf` varchar(250) null,
`standardRoom` varchar(250) null,
`freeService` varchar(250) null,
`serviceGoWith` varchar(250) null,
primary key (`idService`));

create table Furama.Customer (
id int auto_increment,
`name` varchar(250) null,
`dateOfBirth` varchar(250) null,
`gender` varchar(250) null,
`idPerson` int null,
`phone` int null,
`email` varchar(50) null,
`typeOf` varchar(50) null,
primary key (id));

create table Furama.Employee (
id int auto_increment,
`name` varchar(250) null,
`dateOfBirth` varchar(250) null,
`gender` varchar(250) null,
`idPerson` int null,
`phone` int null,
`email` varchar(50) null,
`education` varchar(50) null,
`position` varchar(50) null,
`salary` varchar(50) null,
primary key (id));

select * from Furama.Employee;
select * from Furama.Customer;
select * from Furama.Villa;
select * from Furama.House;
select * from Furama.Room;
