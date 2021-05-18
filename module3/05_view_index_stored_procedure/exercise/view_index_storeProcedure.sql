create database execise_product;

-- Tạo bảng Products với các trường dữ liệu sau:
create table products(
id_product int not null auto_increment primary key,
code_product varchar(50) null,
name_product varchar(50) null,
price_product varchar(50) null,
amount_product varchar(50) null,
description_product varchar(50) null,
status_product varchar(50) null);

-- Chèn một số dữ liệu mẫu cho bảng Products.
insert into products(code_product, name_product, price_product, amount_product, description_product, status_product)
values('1','may lanh','5000','2','abcd','available'),
('45','may giat','7000','5','abcd','available'),
('6','may quat','3000','2','abcd','available');

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
alter table products add unique index unique_index(code_product);


-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table products add index composite_index(name_product, price_product);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * 
from products
where code_product = 45; 

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view products_view as
select code_product, name_product, price_product, status_product
from products;

-- tieesn hanh sua doi 
update products_view 
set code_product = '5'
where name_product like 'may giat';

-- Tiến hành xoá view
drop view products_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
CREATE PROCEDURE show_all_product()
BEGIN
SELECT * FROM products;
END //
call show_all_product();
-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
create procedure add_new_product(in insert_code varchar(50),  
in insert_name varchar(50), 
in insert_price varchar(50), 
in insert_amount varchar(50), 
in insert_description varchar(50), 
in insert_status varchar(50))
begin
insert into products(code_product, 
name_product, 
price_product, 
amount_product, 
description_product, 
status_product)
values(insert_code, 
insert_name, 
insert_price, 
insert_amount, 
insert_description, 
insert_status);
end //
call add_new_product('21','tu lanh','15000','10','abcd','available');

-- Tạo store procedure sửa thông tin sản phẩm theo id
-- drop procedure edit_product;
delimiter //
create procedure edit_product(in find_id int,
in insert_edit varchar(50),
in statement varchar(50))
begin 
if statement like 'code_product'
	then update products 
	set code_product = insert_edit 
	where id_product = find_id;
    end if;
if statement ='name_product'
	then update products 
	set name_product = insert_edit 
	where id_product = find_id ;
    end if;
if statement ='price_product'
	then update products 
	set price_product = insert_edit 
	where id_product = find_id ;
    end if;
if statement ='amount_product'
	then update products 
	set amount_product = insert_edit 
	where id_product = find_id; 
    end if;
if statement ='decripton_product' 
	then update products 
	set decripton_product = insert_edit 
	where id_product = find_id;
    end if;
end//
call edit_product('3', 'tivi', 'name_product');

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_products(in id_find int)
begin
delete from products
where id_product = id_find;
end//
call delete_products(1);

















