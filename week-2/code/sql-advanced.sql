-- Index


show index from Products;

create index sku_code_and_name ON Products(sku_code, name);

Select name from Products where sku_code = 'PHN456' and name = "Smartphone";

drop index sku_code_and_name ON Products;

-- Views

create view all_products_orders AS select Products.id, Products.name, Orders.quantity from Products INNER JOIN Orders ON Products.id = Orders.product_id;

select * from all_products_orders;

insert into all_products_orders(quantity) values (4);

select * from Orders;

alter view all_products_orders as select * from Products;

drop view all_products_orders;

-- scalar functions
select length(name) from Products where id = 4;
select round(price) from Products where id =1;

-- country and city tabels

CREATE TABLE country (
    country_id INT PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL
);

CREATE TABLE city (
    city_id INT PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL,
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES country (country_id)
);

INSERT INTO country (country_id, country_name) VALUES
(1, 'United States'),
(2, 'Canada'),
(3, 'United Kingdom'),
(4, 'Australia'),
(5, 'Germany');

INSERT INTO city (city_id, city_name, country_id) VALUES
(1, 'New York', 1),
(2, 'Los Angeles', 1),
(3, 'Toronto', 2),
(4, 'Vancouver', 2),
(5, 'London', 3),
(6, 'Manchester', 3),
(7, 'Sydney', 4),
(8, 'Melbourne', 4),
(9, 'Berlin', 5),
(10, 'Munich', 5);


-- stored procedures

delimiter //
create procedure citycount(IN country_id INT, OUT cities INT)
    BEGIN
    select count(city_id) from city where city.country_id = country_id;
    END//

call citycount(1, @cities);

drop procedure citycount;


-- user defined functions

create function getCityCount(id INT) returns int
begin
declare cities int;
set cities = select count(city_id) from city where city.country_id = id;
return cities
end //

--or 

create function getCityCount(id INT) returns int
begin
return (select count(city_id) from city where city.country_id = id);
end //
