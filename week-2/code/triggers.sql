
create database banking;

use banking;

-- creating table account
create table account(
no int,
ammount decimal(10,2)
);

-- trigger for sum

create trigger insert_sum before insert on account
for each row set @sum = @sum + NEW.ammount;

set @sum = 0;

insert into account values (1,43432.32), (2, 32432.45), (3, 432432.45), (4, 5235.56);

select @sum;

/*
+-----------+
| @sum      |
+-----------+
| 513532.78 |
+-----------+

*/

drop trigger insert_sum;

-- trigger for deposits and withdrawls
create trigger update_transaction before update on account
for each row
set
@deposits = @deposits + IF(NEW.ammount>OLD.ammount, NEW.ammount-OLD.ammount,0),
@withdrawls = @withdrawls + IF(NEW.ammount<OLD.ammount, OLD.ammount-NEW.ammount,0);

set @deposits = 0;
set @withdrawls = 0;

update account set ammount = account.ammount + 2000 where no = 4;

select @deposits;

update account set ammount = account.ammount - 1000 where no = 3;

select  @withdrawls;


-- employee and audit_log table
create database employee;

use employee;

create table employees(
id int primary key,
name varchar(100),
department varchar(50),
last_modified TIMESTAMP
);

insert into employees values (1, 'John', 'Sales', CURRENT_TIMESTAMP),
(2, 'Jane', 'Marketing', CURRENT_TIMESTAMP);


create table audit_log(
id int primary key auto_increment,
employee_id int,
old_department varchar(50),
new_department varchar(50),
change_time TIMESTAMP,
FOREIGN KEY (employee_id) REFERENCES employees(id)
);


-- audit log trigger
delimiter //

create trigger after_employee_update
after update on employees
for each row
begin
insert into audit_log(employee_id, old_department, new_department, change_time) values (OLD.id, OLD.department, NEW.department, CURRENT_TIMESTAMP);
end//

delimiter ;

update employees set department = 'TRAINING' where id = 2;

select * from audit_log;
/*
+----+-------------+----------------+----------------+---------------------+
| id | employee_id | old_department | new_department | change_time         |
+----+-------------+----------------+----------------+---------------------+
|  1 |           2 | Marketing      | TRAINING       | 2024-08-02 05:05:17 |
+----+-------------+----------------+----------------+---------------------+
*/
