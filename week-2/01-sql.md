# Lecture/Guided Coding Example Plan

1. Database theory
2. Sublanguages
3. Structure
4. DDL
5. DML
6. DQL

---

### MySQL

**[mysql workbench download](https://dev.mysql.com/downloads/workbench/)**

#### What is a Database?

- a database is a structured collection of tables that store related data.
- databases are used to efficiently store, manage, and retrieve data for various applications. 
- each table consists of rows and columns.
- each row represents a unique record and each column represents a specific field within the record. 

#### What is RDMS

Relational Database Management System (RDBMS) is a type of database management system that stores data in a structured format, using rows and columns(SQL).

### Sublanguages of SQL

SQLis divided into several sublanguages as following:

**DDL (Data Definition Language):**
- **Purpose:** Defines the structure of the database.
- **Commands:** CREATE, ALTER, DROP, TRUNCATE

**DML (Data Manipulation Language):**
- **Purpose:** Manages data within schema objects.
- **Commands:** INSERT, UPDATE, DELETE

**DQL (Data Query Language):**
- **Purpose:** Retrieves data from the database
- **Commands:** SELECT

**DCL (Data Control Language):**
- **Purpose:** Manages access to the data within the database, including granting and revoking permissions.
- **Commands:** GRANT, REVOKE

**TCL (Transaction Control Language):**
- **Purpose:** Manages transactions within the database, ensuring data integrity.
- **Commands:** COMMIT, ROLLBACK, SAVEPOINT

### Structure

#### Schema

A Schema in MySQL is a collection of database objects like tables, views, indexes, and stored procedures.

#### SQL Data Types

MySQL supports various data types, categorized into several groups:
- **Numeric:** 
  - Integer types: INT, SMALLINT, TINYINT, MEDIUMINT, BIGINT
  - Fixed Point - DECIMAL (n,d)
  - Floating type: FLOAT, DOUBLE
  - BIT
- **String:** CHAR, VARCHAR, TEXT, BLOB
- **Date/Time:** DATE, TIME, DATETIME, TIMESTAMP, YEAR
- **Boolean:** BOOLEAN (internally TINYINT(1). 0-false, 1-true)


**[mysql data types sql docs](https://dev.mysql.com/doc/refman/8.4/en/data-types.html)**

#### Table Structure

- A table in MySQL consists of rows and columns
- each column has a specific data type and constraints


#### Uniqie key

All values in a column are unique.

#### Primary Key

A primary key is a uniqie identifier for records in a table. Each table has a single primany key and it cant be NULL.

#### Foreign Key

A foreign key is a uniqie identifier for records in another table.

#### Composite Key

A primary key with two or more columns

### DDL (Data Definition Language)

#### Create, Drop, Truncate

- **CREATE:** Used to create a new table or database.

**syntax**

```sql
  CREATE DATABASE databse_name;
  CREATE TABLE table_name (
      column1 datatype constraints,
      column2 datatype constraints,
      ...
  );
```

example:

```sql
```
- **DROP:** Deletes a table or database.

```sql
  DROP TABLE table_name;
  DROP DATABASE database_name;
```

example:

``` sql

```

- **TRUNCATE:** removes all rows from a table without deleting the table itself.

```sql
    TRUNCATE TABLE table_name;
```

example:

```sql
```

### Constraints

**Data Type:** data type of the column

**Primary Key:** Uniquely identifies each row in a table.
```sql
PRIMARY KEY (column_name)
```

**Unique:** Ensures all values in a column are unique.
```sql
column_name datatype UNIQUE
```

**Auto Increment:** Automatically generates a unique number for new rows.
```sql
column_name datatype AUTO_INCREMENT
```

**Check:** Ensures that all values in a column satisfy a specific condition.
```sql
column_name datatype CHECK (condition)
```

**SET Null:** When a referenced row is deleted, all corresponding rows in the child table will have their foreign key columns set to NULL.

```sql
FOREIGN KEY (column_name) REFERENCES parent_table (column_name) ON DELETE SET NULL
```

**Cascade:** Automatically updates or deletes related rows in child tables when a row in the parent table is updated or deleted.
```sql
FOREIGN KEY (column_name) REFERENCES parent_table (column_name) ON DELETE CASCADE ON UPDATE CASCADE
```

**Default:** Sets a default value for a column when no value is specified.

```sql
column_name datatype DEFAULT default_value
```

### DML (Data Manipulation Language)

**INSERT:** adds new rows to a table.
```sql
INSERT INTO table_name (column1, column2, ...) VALUES (value1, value2, ...);
```

**UPDATE:** modifies existing rows in a table.
```sql
UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;
```

**DELETE:** removes rows from a table.
```sql
DELETE FROM table_name WHERE condition;
```

### DQL (Data Query Language)

**Queries:** Used to retrieve data from one or more tables.

#### Clauses

**WHERE:** Filters records that meet a specified condition.
```sql
SELECT column1, column2, ... FROM table_name WHERE condition;
```

**LIKE:** Searches for a specified pattern in a column.
```sql
SELECT column1, column2, ... FROM table_name WHERE column_name LIKE pattern;
```

patten matching:

- begining `c%`
- ending `%c`
- containing `%c%`
- no of charactes `___`

**REGEXP_LIKE(name, pattern)** Regular expression

- `.` - single character
- `*` - zero or more
- [a-z], [0-9] , alpha numeric
- `^` - begining
- `$` - ending

**[pattern matching sql docs](https://dev.mysql.com/doc/refman/8.4/en/pattern-matching.html)**

**ORDER BY:** Sorts the result set in ascending or descending order.

```sql
SELECT column1, column2, ... FROM table_name ORDER BY column_name ASC|DESC;
```

**GROUP BY & HAVING:** Groups rows that have the same values into summary rows, and filters groups based on a condition.
```sql
SELECT column1, COUNT(column2) FROM table_name GROUP BY column1 HAVING COUNT(column2) > value;
```


#### Aggregate Functions

**Count:** returns the number of rows that match a specified condition.
```sql
SELECT COUNT(column_name) FROM table_name WHERE condition;
```

**SUM:** returns the sum of a numeric column.
```sql
SELECT SUM(column_name) FROM table_name WHERE condition;
```

**AVG:** returns the average value of a numeric column.
```sql
SELECT AVG(column_name) FROM table_name WHERE condition;
```

**MIN:** returns the minimum value of a column.
```sql
SELECT MIN(column_name) FROM table_name WHERE condition;
```

**MAX:** returns the maximum value of a column.
```sql
SELECT MAX(column_name) FROM table_name WHERE condition;
```


