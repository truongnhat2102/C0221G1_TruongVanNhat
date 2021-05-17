use furama_resort;

-- task2
select *
from employee
where (employee.name_employee like "H%" or employee.name_employee like 'T%' or employee.name_employee like 'K%')  and length(employee.name_employee) <= 15;

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
select customer.name_customer
group by name_customer;


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
where (type_of_customer.name_type_customer like 'Diamond') and (customer.address like 'Dannang' or customer.address like 'Ha Noi');

-- task 12
select contract.id_contract, employee.name_employee, customer.name_customer, customer.phone, service.name_service, extra_service.amount_extra_service
from employee
join contract on employee.id_employee = contract.id_employee
join customer on customer.id_customer = contract.id_customer
join service on service.id_service = contract.id_service
join contract_detail on contract_detail.id_contract = contract.id_contract
join extra_service on extra_service.id_extra_service = contract_detail.id_extra_service
where (month(contract.date_contract) not in ('01', '02', '03'))
and (month(contract.date_contract) in ('12', '11', '10', '09', '08','07', '05'))
and year(contract.date_contract) like '2021'
group by customer.name_customer;

-- task13
select extra_service.*, count(contract_detail.id_extra_service) as count_extra_service
from extra_service
join contract_detail on contract_detail.id_extra_service = extra_service.id_extra_service
group by(id_extra_service)
having max(count_extra_service);

-- task14
select extra_service.*, count(contract_detail.id_extra_service) as count_extra_service
from extra_service
join contract_detail on contract_detail.id_extra_service = extra_service.id_extra_service
group by (id_extra_service)
having count_extra_service like '1';

-- task15
select employee.*, count(contract.id_contract) as amount_contract
from employee
right join contract on contract.id_employee = employee.id_employee
where year(date_contract) like '2021' or id_contract is null
group by employee.id_employee
having amount_contract < 3;

-- task16
delete employee.* 
from employee
right join contract on contract.id_employee = employee.id_contract
where (year(current_date())-year(date_contract)) = 5




