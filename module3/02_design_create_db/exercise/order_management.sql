create database if not exists order_management;
create table customer(
id_customer int not null auto_increment primary key,
name_customer varchar(250) null,
age_customer int (250) null);

create table Orders(
id_order int not null auto_increment primary key,
id_customer int not null,
foreign key (id_customer) references customer(id_customer),
date_of_order date not null,
total_price_of_orders int null);

create table product(
id_product int not null auto_increment primary key,
name_product varchar(250) null,
price_product int null);

create table order_detail(
id_order int not null,
id_product int not null,
primary key(id_order,id_product),
foreign key (id_order) references Orders(id_order),
foreign key (id_product) references product(id_product),
QTY_order varchar(250) null);
