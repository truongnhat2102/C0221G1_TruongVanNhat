use order_management;
insert  into order_management.customer(name_customer,age_customer)
values ("Minh Quan", 10),
("Ngoc Oanh", 20),
("Hong Ha", 50);

insert into order_management.Orders(id_customer,date_of_order,total_price_of_orders)
values (1,"2006-03-21",null),
(2,"2006-03-23",null),
(1,"2006-03-16",null);

insert into order_management.product(name_product,price_product)
values("May Giat",3),
("Tu Lanh",5),
("Dieu Hoa",7),
("Quat",1),
("Bep Dien",2);

insert into order_management.order_detail(id_order,id_product,QTY_order)
values(1,1,"3"),
(1,3,"7"),
(1,4,"2"),
(2,1,"1"),
(3,1,"8"),
(2,5,"4"),
(2,3,"3");

select id_order, date_of_order, total_price_of_orders
from Orders