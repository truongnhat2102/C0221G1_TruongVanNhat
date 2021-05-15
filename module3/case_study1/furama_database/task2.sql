use furama_resort;

-- task2
select *
from employee
where employee.name_employee like ("H%" or 'T%' or 'K%')  and length(employee.name_employee) <= 15;

-- task3
select *
from customer
where (year(curdate())-year(customer.date_of_birth)) >=18 and (year(curdate())-year(customer.date_of_birth)) <=50 and customer.address = ("danang" or "quangtri");

-- task 4
select *, count(id_customer) as times_booking
from customer
join type_of_customer on customer.id_type_customer = type_of_customer.id_type_customer
where type_of_customer.name_type_customer = "diamond"
group by id_customer
order by times_booking;

-- task5
select customer.id_customer, customer.name_customer, name_type_customer, contract.id_contract, name_service, date_contract, sum(service.price_service+extra_service.amount_extra_service*extra_service.price_extra_service) as total_price
from customer
left join type_of_customer on customer.id_type_customer = type_of_customer.id_type_customer
left join contract on customer.id_customer = contract.id_customer
left join service on service.id_service = contract.id_service
left join contract_detail on contract_detail.id_contract = contract.id_contract
left join extra_service on extra_service.id_extra_service = contract_detail.id_extra_service;

-- task6 (vi du lieu truyen vao cua e khong co Dịch vụ chưa từng được Khách hàng thực hiện đặt nen em lam nguoc lai nha)
select service.name_service, area_service, price_service, name_type_service
from service
left join type_of_service on service.id_type_service = type_of_service.id_type_service
join contract on service.id_service = contract.id_service
where month(date_contract) = ('01' or '02' or '03') and contract.id_contract is not null;

-- task7
select service.id_service, name_service, area_service, max_people_service, price_service, name_type_service
from service
join type_of_service on service.id_type_service = type_of_service.id_type_service
join contract on contract.id_service = service.id_service
where year(contract.date_contract) <> '2021' and year(contract.date_contract) like '2020';

-- task8
-- select customer.name_customer
-- group by 

-- task 9
select month(contract.date_contract) as month, count(customer.id_customer) as amount_customers
from contract
join customer on contract.id_customer = customer.id_customer
group by month(contract.date_contract);

-- task 10
select contract.id_contract, date_contract, date_end, deposit, count(contract_detail.id_contract_detail) as amount_extra_service
from contract
join contract_detail on contract.id_contract = contract_detail.id_contract
join extra_service on contract_detail.id_extra_service = extra_service.id_extra_service
group by contract.id_contract
order by contract.id_contract;

-- task 11
-- select extra_service.id_extra_service, name_extra_service, price_extra_service, unit_extra_service, amount_extra_service
select customer.name_customer
from extra_service 
left join contract_detail on extra_service.id_extra_service
left join contract on contract_detail.id_contract = contract.id_contract
left join customer on contract.id_customer = customer.id_customer
left join type_of_customer on customer.id_type_customer = type_of_customer.id_type_customer
where customer.address like ('Ha Noi' or 'Quang Ngai') and type_of_customer.name_type_customer like 'Diamond';

select *
from customer
join type_of_customer on customer.id_type_customer = type_of_customer.id_type_customer;






