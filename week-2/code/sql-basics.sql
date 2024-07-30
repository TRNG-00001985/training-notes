create database ecommerce;
use ecommerce;

-- DDL
-- CREATE
CREATE table Product(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(50),
sku_code VARCHAR(50) unique,
price FLOAT(10,2),
CHECK (price>0)
);


CREATE table Orders(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
product_id BIGINT,
quantity INT
);

-- DROP
drop table Orders;

desc Orders;

-- ALTER
ALTER table Orders
ADD FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE SET NULL ON UPDATE CASCADE;


-- DML
-- INSERT
INSERT into Product(product_name, sku_code, price)  values 
('Laptop', 'LAP123', 999.99),
('Smartphone', 'PHN456', 499.49),
('Tablet', 'TAB789', 299.99);

INSERT into Orders(product_id, quantity)
values (1,2),(2,1),(3,2);

-- DELETE
DELETE from Product WHERE id=1;

-- UPDATE
UPDATE Product SET id=5 WHERE id=2;

-- DQL and Clauses
SELECT * from Product WHERE  REGEXP_LIKE(product_name, '') ;

SELECT * from Product ORDER BY product_name DESC;

SELECT SUM(price) FROm Product;

SELECT product_id, SUM(price) FROM Orders GROUP BY product_id HAVING SUM(quantity) > 0;
