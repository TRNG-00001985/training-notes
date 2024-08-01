## Multiplicity

### One to One

- Each record in one table is linked to only one record in another table, and vice versa.

### One to Many

- A record in one table can be associated with multiple records in another table.

### Many to One

- Multiple records in one table can be associated with a single record in another table.

### Many to Many

Multiple records in one table can be associated with multiple records in another table


## Indexes

**Clustered Index:** 

- InnoDB created a cluster index when the table is created. 

- the primary key is the clustered index.
- if primary key is not defined, the first unique and not null column is the clustered index.
- if there is no primary key or unique index, InnoDb generated a hidden clustered index named `GEN_CLUST_INDEX` on a synthetic column with row ids.

**Secondary Index:**

- Indexes other than primary indexes are secondary indexes.

- secondary index contains the primary key and the column specified for the secondary index.

```sql
CREATE INDEX index_name ON Table(Column1, Column2, ....);
```

```sql
ALTER TABLE name
DROP INDEX index_name;
```

MySQL Supports B-Tree and Hash Indexes.


## Views

- views act as virtual tabels.
- views are stored queries that generate a result set when invoked. 


Create View

```sql
CREATE VIEW view_name AS [QUERY]
```

Access View

```sql
SELECT * FROM view_name;
```

Drop View

```sql
DROP VIEW view_name
```

Alter View

```sql
ALTER VIEW view_name AS QUERY
```
- views abstract the table structure and reduce the complexity of queries.

## Scalar Functions

- SQL functions that take one paramater and return a single value.

- UCASE
- LCASE
- MID
- LENNGTH
- ROUND
- FLOOR
- CEIL


[mysql operator and function reference](https://dev.mysql.com/doc/refman/8.4/en/built-in-function-reference.html)


## Sequence 

- A Database object that generated a sequence of numerical values according to specified condition.

usecase: to generate uniqie values primary keys

In MySQL Auto_increment is used to create a sequence for the primay keys


## Stored Procedure

- a set of SQL statements that can be executed as a program.
- performace improvement, security and encapsulation of complex operations.


```sql
delimiter //

create procedure procedure_name (paramneters)
begin
 -- SQL statements
end//

delimiter ;
```

```sql
call prodeure_name (args)
```

```sql
DROP PROCEDURE IF EXISTS procedure_name
```
