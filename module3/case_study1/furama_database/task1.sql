create database if not exists furama_resort;
use furama_resort;
create table positionn(
id_position int not null auto_increment primary key,
name_position varchar(250) null);

INSERT INTO furama_resort.positionn (id_position, name_position) VALUES ('1', 'Receptionist'),
('2', 'Server'),
('3', 'Expert'),
('4', 'Supervisor'),
('5', 'Manager'),
('6', 'General Manager');

create table education(
id_education int not null auto_increment primary key,
name_education varchar(250) null);

INSERT INTO furama_resort.education (id_education, name_education) VALUES ('1', 'Intermediate'),
('2', 'College'),
('3', 'University'),
('4', 'Higher Education');


create table part(
id_part int not null auto_increment primary key,
name_part varchar(250) null);

INSERT INTO furama_resort.part (id_part, name_part) VALUES ('1', 'Sale - Marketing'),
('2', 'Administration'),
('3', 'Service'),
('4', 'Management');

create table employee(
id_employee int not null auto_increment primary key,
name_employee varchar(250) null,
id_position int not null,
foreign key (id_position) references positionn(id_position),
id_education int not null,
foreign key (id_education) references education(id_education),
id_part int not null,
foreign key (id_part) references part(id_part),
date_of_birth date null,
id_person varchar(45) null,
salary varchar(45) null,
phone varchar(45) null,
email varchar(45) null,
address varchar(45) null);

INSERT INTO furama_resort.employee (id_employee, name_employee, id_position, id_education, id_part, date_of_birth, id_person, salary, phone, email, address) VALUES ('1', 'Tam', '6', '4', '4', '1980-02-11', '201032123', '3000', '0123 232 111', 'tam@furama.com', 'Danang'),
('2', 'Dung', '5', '4', '4', '1984-04-23', '200995821', '2500', '0934 122 333', 'dung@furama.com', 'Quang Nam'),
('3', 'Khoa', '3', '3', '2', '1990-11-03', '201184921', '1000', '0122 231 212', 'khoa@furama.com', 'Quang Tri'),
('4', 'Tuan', '4', '3', '4', '1985-08-21', '200387987', '1000', '0932 298 845', 'tuan@furama.com', 'Ho Chi Minh City'),
('5', 'Van', '1', '3', '3', '1990-05-16', '201021399', '500', '0912 894 129', 'van@furama.com', 'Danang'),
('6', 'Chuong', '1', '3', '3', '1988-12-23', '201123334', '500', '0882 832 932', 'chuong@furama.com', 'Hanoi'),
('7', 'Vinh', '2', '1', '3', '1989-11-22', '203194190', '300', '0912 182 342', 'vinh@furama.com', 'Danang'),
('8', 'Van', '2', '1', '3', '1984-04-14', '200410939', '300', '0325 892 128', 'van@furama.com', 'Quang Nam');


create table extra_service(
id_extra_service int not null auto_increment primary key,
name_extra_service varchar(45) null,
price_extra_service int null,
unit_extra_service int null,
amount_extra_service int null);

INSERT INTO furama_resort.extra_service (id_extra_service, name_extra_service, price_extra_service, unit_extra_service, amount_extra_service) VALUES ('1', 'Drink', '20', '5', '10'),
('2', 'Massage', '100', '2', '11'),
('3', 'Car', '100', '2','12');

create table type_of_customer(
id_type_customer int not null auto_increment primary key,
name_type_customer varchar(45) null);

INSERT INTO furama_resort.type_of_customer (id_type_customer, name_type_customer) VALUES ('1', 'Diamond'),
('2', 'Platinum'),
('3', 'Gold'),
('4', 'Silver'),
('5', 'Member');


create table customer(
id_customer int not null auto_increment primary key,
id_type_customer int not null,
foreign key(id_type_customer) references type_of_customer(id_type_customer),
name_customer varchar(45) null,
date_of_birth date null,
id_person varchar(45),
phone varchar(45),
email varchar(45),
address varchar(45));

INSERT INTO furama_resort.customer (id_customer, id_type_customer, name_customer, date_of_birth, id_person, phone, email, address) 
VALUES ('1', '2', 'Nguyen Trung Quan', '1978-12-13', '201381738', '0934 123 523', 'quan@gmail.com', 'Danang'),
('2', '2', 'Pham Phuong Dong', '1990-03-24', '493291923', '0123 832 832', 'dong@gmail.com', 'Quang Tri'),
('3', '3', 'Tran Thi Thuy', '1998-08-08', '121030300', '0138 747 429', 'thuy@gmail.com', 'Ha Noi'),
('4', '4', 'Phan Nhat Tan', '1994-04-30', '893477121', '0248 234 048', 'tan@gmail.com', 'Quang Ngai'),
('5', '5', 'Dang Le Thu', '1965-09-11', '716248172', '9320 382 719', 'thu@gmail.com', 'Quang Tri'),
('6', '1', 'Nguyen Thanh Dat', '1980-02-13', '716222172', '0248 234 009', 'dat@gmail.com', 'Ha Noi'),
('7', '2', 'Pham Thu Hien', '1996-04-27', '213872138', '2039 812 182', 'hien@gmail.com','Ha Noi');


create table type_of_rent(
id_type_rent int not null auto_increment primary key,
name_type_rent varchar(45),
price varchar(45));

insert into furama_resort.type_of_rent(id_type_rent,name_type_rent,price)
values ('1', 'Day', '200'),
('2', 'Week', '1200'),
('3', 'Month', '5800');

create table type_of_service(
id_type_service int not null auto_increment primary key,
name_type_service varchar(45));

insert into furama_resort.type_of_service(id_type_service,name_type_service)
values ('1', 'Standard'),
('2', 'Superior'),
('3', 'Deluxe');

create table service(
id_service int not null auto_increment primary key,
name_service varchar(45),
area_service int,
floor_service int,
max_people_service varchar(45),
price_service varchar(45),
id_type_rent int not null,
foreign key(id_type_rent) references type_of_rent(id_type_rent),
id_type_service int not null,
foreign key(id_type_service) references type_of_service(id_type_service),
status_service varchar(45));

insert into furama_resort.service(id_service,name_service,area_service,floor_service,max_people_service,price_service,id_type_rent,id_type_service,status_service)
values ('1', 'Villa', '300', '3', '8', '500', '1', '1', 'Available'),
('2', 'Room', '50', '1', '2', '150', '2', '2', 'Available'),
('3', 'House', '150', '2', '4', '300', '3', '3', 'Available');

create table contract(
id_contract int not null auto_increment primary key,
id_employee int not null,
foreign key (id_employee) references employee(id_employee),
id_customer int not null,
foreign key (id_customer) references customer(id_customer),
id_service int not null,
foreign key (id_service) references service(id_service),
date_contract date null,
date_end date null,
deposit int null,
total int null);

insert into furama_resort.contract(id_contract, id_employee, id_customer, id_service, date_contract, date_end, deposit, total)
values ('1', '5', '1', '1', '2021-05-14', '2021-05-24', '1000', '1200'),
('2', '6', '2', '2', '2021-05-14', '2021-05-23', '800', '500'),
('3', '5', '3', '3', '2021-04-14', '2021-05-22', '600', '800'),
('4', '6', '4', '2', '2021-05-14', '2021-05-21', '400', '500'),
('5', '5', '2', '1', '2021-03-14', '2021-05-20', '200', '1200'),
('6', '6', '1', '1', '2020-01-12', '2020-01-15', '200', '600');

create table contract_detail(
id_contract_detail int not null auto_increment primary key,
id_contract int not null,
foreign key(id_contract) references contract(id_contract),
id_extra_service int not null,
foreign key(id_extra_service) references extra_service(id_extra_service),
amount_contract_detail int);

insert into furama_resort.contract_detail (id_contract_detail, id_contract, id_extra_service, amount_contract_detail)
values ('1', '1', '1', '5'),
('2', '2', '2', '4'),
('3', '3', '3', '3'),
('4', '4', '2', '2'),
('5', '5', '1', '1'),
('6', '6', '2', '0');
