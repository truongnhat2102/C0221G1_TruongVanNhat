create database if not exists furama_resort;
create table positionn(
idPosition int not null auto_increment primary key,
namePosition varchar(250) null);

create table education(
idEducation int not null auto_increment primary key,
nameEducation varchar(250) null);

create table part(
idPart int not null auto_increment primary key,
namePart varchar(250) null);

create table employee(
idEmployee int not null auto_increment primary key,
nameEmployee int null,
idPosition int not null,
foreign key (idPosition) references positionn(idPosition),
idEducation int not null,
foreign key (idEducation) references education(idEducation),
idPart int not null,
foreign key (idPart) references part(idPart),
dateOfBirth date null,
idPerson varchar(45) null,
salary varchar(45) null,
phone varchar(45) null,
email varchar(45) null,
address varchar(45) null);

create table service_go_with(
idServiceGoWith int not null auto_increment primary key,
nameServiceGoWith varchar(45) null,
priceServiceGoWith int null,
unitServiceGoWith int null,
amountServiceGoWith int null);

create table type_of_customer(
idTypeOfCustomer int not null auto_increment primary key,
nameTypeOfCustomer varchar(45) null);

create table customer(
idCustomer int not null auto_increment primary key,
idTypeOfCustomer int not null,
foreign key(idTypeOfCustomer) references type_of_customer(idTypeOfCustomer),
nameCustomer varchar(45) null,
dateOfBorth date null,
idPerson varchar(45),
phone varchar(45),
email varchar(45),
address varchar(45));

create table type_of_rent(
idTypeOfRent int not null auto_increment primary key,
nameTypeOfRent varchar(45),
price varchar(45));

create table type_of_service(
idTypeOfService int not null auto_increment primary key,
nameTypeOfService varchar(45));

create table service(
idService int not null auto_increment primary key,
nameService varchar(45),
areaService int,
floorService int,
maxPeopleService varchar(45),
priceService varchar(45),
idTypeOfRent int not null,
foreign key(idTypeOfRent) references type_of_rent(idTypeOfRent),
idTypeOfService int not null,
foreign key(idTypeOfService) references type_of_service(idTypeOfService),
statusService varchar(45));

create table contract(
idContract int not null auto_increment primary key,
idEmployee int not null,
foreign key (idEmployee) references employee(idEmployee),
idCustomer int not null,
foreign key (idCustomer) references customer(idCustomer),
idService int not null,
foreign key (idService) references service(idService),
dateOfContact date null,
dateOfEnd date null,
deposit int null,
total int null);

create table contract_detail(
idContractDetail int not null auto_increment primary key,
idContract int not null,
foreign key(idContract) references contract(idContract),
idServiceGoWith int not null,
foreign key(idServiceGoWith) references service_go_with(idServiceGoWith),
amountContractDetail int);