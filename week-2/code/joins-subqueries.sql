-- joins

select Products.id, Products.name, Orders.quantity from Products 
RIGHT JOIN Orders 
ON Products.id = Orders.product_id 
UNION
select Products.id, Products.name, Orders.quantity from Products 
LEFT JOIN Orders 
ON Products.id = Orders.product_id
; 

select Products.id, Products.name, Orders.quantity from Products 
INNER JOIN Orders 
ON Products.id = Orders.product_id 

-- subqueries

SELECT * from Products WHERE id IN (SELECT product_id from Orders);


-- employee schema
create database employee;

use employee;

CREATE TABLE Employees(

id INT PRIMARY KEY,
name VARCHAR(30),
department_id INT
);

ALTER TABLE Employees
ADD FOREIGN KEY (department_id) REFERENCES Departments(id);


CREATE TABLE Departments(
id INT primary key,
name VARCHAR(30) 
);

CREATE TABLE Projects(
id INT primary key,
name VARCHAR(30),
department_id INT,

FOREIGN KEY (department_id) REFERENCES Departments(id) 
);


INSERT INTO Departments Values
(1, 'Sales'),
(2, 'HR'),
(3, 'IT'),
(4, 'Marketing')
(5, 'Demo');

INSERT INTO Projects Values
(101, 'Project A', 1),
(102, 'Project B', 2),
(103, 'Project C', 3),
(104, 'Project D', 4),
(105, 'Project E', NULL);

INSERT INTO Employees VALUES
(1, 'John', 1),
(2, 'Jane', 2),
(3, 'Mark', 1),
(4, 'Emily', 3),
(5, 'Karen', 5);


Select * from Employees WHERE department_id NOT IN (SELECT Departments.id from Departments 
INNER JOIN Projects
WHERE Projects.department_id = Departments.id);