use furama_resort;

-- task2
select *
from employee
where (employee.name_employee like "H%" or employee.name_employee like 'T%' or employee.name_employee like 'K%')  and length(employee.name_employee) <= 15;

-- task3
select *
from customer
where (year(curdate())-year(customer.date_of_birth)) >=18 and (year(curdate())-year(customer.date_of_birth)) <=50 and customer.address = "danang" or customer.address = "quangtri";

-- task 4
select *, count(id_customer) as times_booking
from customer
join type_of_customer on customer.id_type_customer = type_of_customer.id_type_customer
where type_of_customer.name_type_customer = "diamond"
group by id_customer
order by times_booking;

-- task5
select customer.id_customer, customer.name_customer, name_type_customer, contract.id_contract, name_service, date_contract, sum(service.price_service + extra_service.amount_extra_service * extra_service.price_extra_service) as total_price
from contract
left join customer on customer.id_customer = contract.id_customer
left join type_of_customer on customer.id_type_customer = type_of_customer.id_type_customer
left join service on service.id_service = contract.id_service
left join contract_detail on contract_detail.id_contract = contract.id_contract
left join extra_service on extra_service.id_extra_service = contract_detail.id_extra_service
group by contract.id_cusotmer,id_contract;

-- task6 
select service.name_service, area_service, price_service, name_type_service
from service
left join type_of_service on service.id_type_service = type_of_service.id_type_service
join contract on service.id_service = contract.id_service
where year(contract.date_contract) = 2019 and contract.id_service not in (
select contract.id_service
from contract
where month(date_contract) in ('1', '2', '3'));

-- task7
select service.id_service, name_service, area_service, max_people_service, price_service, name_type_service
from service
join type_of_service on type_of_service.id_type_service = service.id_type_service
join contract on service.id_service = contract.id_service
where year(contract.date_contract) like '2021' and service.id_service not in (
select contract.id_service
from contract
where year(contract.date_contract) like '2020')
group by name_service,name_type_service;


-- task8
select name_customer
from customer
group by name_customer;

select name_customer
from customer
union
select name_customer
from customer;

select distinctrow name_customer
from customer;

-- task 9
select month(contract.date_contract) as month, count(customer.id_customer) as amount_customers
from contract
join customer on contract.id_customer = customer.id_customer
group by month(contract.date_contract)
order by month;

-- task 10
select contract.id_contract, date_contract, date_end, deposit, count(contract_detail.id_extra_service) as amount_extra_service
from contract
join contract_detail on contract.id_contract = contract_detail.id_contract
join extra_service on contract_detail.id_extra_service = extra_service.id_extra_service
group by contract.id_contract
order by contract.id_contract;

-- task 11
select extra_service.id_extra_service, name_extra_service, price_extra_service, unit_extra_service, amount_extra_service
from extra_service
right join contract_detail on contract_detail.id_extra_service = extra_service.id_extra_service
right join contract on contract.id_contract = contract_detail.id_contract
right join customer on customer.id_customer = contract.id_customer
right join type_of_customer on type_of_customer.id_type_customer = customer.id_type_customer
where (type_of_customer.name_type_customer like 'Diamond') and (customer.address like 'Vinh' or customer.address like 'Quang Ngai');

-- task 12
select contract.id_contract, employee.name_employee, customer.name_customer, customer.phone, service.name_service, extra_service.amount_extra_service
from contract
join employee on employee.id_employee = contract.id_employee
join customer on customer.id_customer = contract.id_customer
join service on service.id_service = contract.id_service
join contract_detail on contract_detail.id_contract = contract.id_contract
join extra_service on extra_service.id_extra_service = contract_detail.id_extra_service
where month(contract.date_contract) in ('10','11','12') 
and year(contract.date_contract) ='2019'
and contract.id_customer not in (
select contract.id_customer
from contract
where month(date_contract) in ('1', '2', '3', '4', '5', '6'));

-- task13
select *, max(count_extra_service) as max_count_extra_service
from (select extra_service.*, count(contract_detail.id_extra_service) as count_extra_service
	from contract_detail
    join extra_service on extra_service.id_extra_service = contract_detail.id_extra_service
    group by contract_detail.id_extra_service) abcd
group by count_extra_service
having count_extra_service = max_count_extra_service;

-- task14
select extra_service.*, count(contract_detail.id_extra_service) as count_extra_service
from extra_service
join contract_detail on contract_detail.id_extra_service = extra_service.id_extra_service
group by (id_extra_service)
having count_extra_service = '1';

-- task15
select employee.*, count(contract.id_contract) as amount_contract
from employee
right join contract on contract.id_employee = employee.id_employee
where year(date_contract) = '2018' or year(date_contract) = '2019' or id_contract is null
group by employee.id_employee
having amount_contract <= 3;

-- task16
SET SQL_SAFE_UPDATES = 0;
delete from employee
where employee.id_employee not in (
select contract.id_employee
from contract 
where year(date_contract) between 2017 and 2019 );
select employee.*
from employee;

-- task17
SET SQL_SAFE_UPDATES = 0;
update customer
set customer.id_type_customer = 1
where customer.id_type_customer = 2 and customer.id_customer in (
select contract.id_customer
from contract
inner join contract_detail on contract.id_contract = contract_detail.id_contract
inner join service on contract.id_service = service.id_service
inner join extra_service on extra_service.id_extra_service = contract_detail.id_extra_service
where year(contract.date_contract) like '2019'
group by contract.id_customer
having sum(service.price_service + extra_service.amount_extra_service * extra_service.price_extra_service) >= 12000000);
select *
from customer
join type_of_customer on type_of_customer.id_type_customer = customer.id_type_customer;

-- task18
SET foreign_key_checks = 0; 
delete from customer
where id_customer in (
select contract.id_customer
from contract
where year(date_contract) < '2016');
SET foreign_key_checks = 1; 

-- task19
update extra_service
set extra_service.price_extra_service = (extra_service.price_extra_service * 2)
where id_extra_service in (
select contract_detail.id_extra_service
from contract_detail
join contract on contract.id_contract = contract_detail.id_contract
where year(contract.date_contract) = '2019'
group by (id_extra_service)
having sum(extra_service.amount_extra_service) > 10);
select extra_service.*
from extra_service;

-- task20
select id_customer as id, name_customer as name, email, phone, date_of_birth, address
from customer
union
select id_employee, name_employee, email, phone, date_of_birth, address
from employee;

-- task21
create view v_employee as
select employee.* 
from employee
where address = 'hai chau' and id_employee in (
select contract.id_employee
from contract
where date_contract = '2019/12/12');

-- task22
update v_employee
set address = 'lien chieu';

-- task23
delimiter //
create procedure sp_1(in customer_id int)
begin
SET foreign_key_checks = 0; 
delete customer.*
from customer
where id_customer = customer_id;
SET foreign_key_checks = 1;
end//
call sp_1(1);

-- task24
delimiter //
create procedure sp_2(in employee_id int, 
in customer_id int, 
in service_id int, 
in contract_date date, 
in end_contract date, 
in deposit int, 
in total int)
begin
insert into contract(id_employee, 
id_customer, 
id_service, 
date_contract, 
date_end, 
deposit, 
total)
values(employee_id, 
customer_id, 
service_id, 
contract_date, 
end_contract, 
deposit, 
total);
end//
call sp_2('5', '1', '1', '2021-05-14', '2021-05-24', '1000', '1200');

-- task25
create trigger tr_1 
after delete
on contract for each row
begin
 select concat("amount record in contract: ", new.count(id_contract)) 
	as log into outfile "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log.txt";
end;
-- drop trigger tr_1;

SET foreign_key_checks = 0; 
delete from contract
where id_contract = 1;
SET foreign_key_checks = 1;

-- task26
create trigger tr_2
before update
on contract
for each row
if datediff(date_end, date_contract) <2 
	then select 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày' 
		as log into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log.txt';
    end if



















