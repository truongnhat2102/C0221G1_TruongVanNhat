create database if not exists product_management;
create table bill(
id_PX int not null primary key,
date_of_PX date null);

create table receipt(
id_PN int not null primary key,
date_of_PN date null);

create table supply(
id_supply int not null auto_increment primary key,
name_supply varchar(250) null,
id_PX int not null,
id_PN int not null,
foreign key(id_PX) references bill(id_PX),
foreign key(id_PN) references receipt(id_PN));

create table manufacture(
id_manufacture int not null auto_increment primary key,
name_manufacture varchar(250) null,
address_manufacture varchar(250) null,
phone_manufacture int null);

create table Orders(
id_order int not null auto_increment primary key,
date_of_order date null,
id_supply int not null,
id_manufacture int not null,
foreign key(id_supply) references supply(id_supply),
foreign key(id_manufacture) references manufacture(id_manufacture));
