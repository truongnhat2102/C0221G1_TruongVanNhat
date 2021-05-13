create database if not exists order_management;
create table customer(
idCustomer int not null auto_increment primary key,
nameCustomer varchar(250) null,
ageCustomer int (250) null);

create table Orders(
idOrder int not null auto_increment primary key,
idCustomer int not null,
foreign key (idCustomer) references customer(idCustomer),
dateOfOrder date null,
totalPriceOfOrders int null);

create table product(
idProduct int not null auto_increment primary key,
nameProduct varchar(250) null,
priceProduct int null);

create table order_detail(
idOrder int not null,
idProduct int not null,
primary key(idOrder,idProduct),
foreign key (idOrder) references Orders(idOrder),
foreign key (idProduct) references product(idProduct),
QTYOrder varchar(250) null);
