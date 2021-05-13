create database if not exists furama_resort;
create table positionn(
id_position int not null auto_increment primary key,
name_position varchar(250) null);

create table education(
id_education int not null auto_increment primary key,
name_education varchar(250) null);

create table part(
id_part int not null auto_increment primary key,
name_part varchar(250) null);

create table employee(
id_employee int not null auto_increment primary key,
name_employee int null,
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

create table extra_service(
id_extra_service int not null auto_increment primary key,
name_extra_service varchar(45) null,
price_extra_service int null,
unit_extra_service int null,
amount_extra_service int null);

create table type_of_customer(
id_type_customer int not null auto_increment primary key,
name_type_customer varchar(45) null);

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

create table type_of_rent(
id_type_rent int not null auto_increment primary key,
name_type_rent varchar(45),
price varchar(45));

create table type_of_service(
id_type_service int not null auto_increment primary key,
name_type_service varchar(45));

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

create table contract(
id_contract int not null auto_increment primary key,
id_employee int not null,
foreign key (id_employee) references employee(id_employee),
id_customer int not null,
foreign key (id_customer) references customer(id_customer),
id_service int not null,
foreign key (id_service) references service(id_service),
date_contact date null,
date_end date null,
deposit int null,
total int null);

create table contract_detail(
id_contract_detail int not null auto_increment primary key,
id_contract int not null,
foreign key(id_contract) references contract(id_contract),
id_extra_service int not null,
foreign key(id_extra_service) references service_go_with(id_extra_service),
amount_contract_detail int);