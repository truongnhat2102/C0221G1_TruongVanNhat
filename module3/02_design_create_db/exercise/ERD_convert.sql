create database if not exists product_management;
create table phieu_xuat(
idPX int not null primary key,
dateOfPX date null);

create table phieu_nhap(
idPN int not null primary key,
dateOfPN date null);

create table supply(
idSupply int not null auto_increment primary key,
nameSupply varchar(250) null,
idPX int not null,
idPN int not null,
foreign key(idPX) references phieu_xuat(idPX),
foreign key(idPN) references phieu_nhap(idPN));

create table manufacture(
idManufacture int not null auto_increment primary key,
nameManufacture varchar(250) null,
addressmanufacture varchar(250) null,
phoneManufacture int null);

create table Orders(
idOrder int not null auto_increment primary key,
dateOfOrder date null,
idSupply int not null,
idManufacture int not null,
foreign key(idSupply) references supply(idSupply),
foreign key(idManufacture) references manufacture(idManufacture));
