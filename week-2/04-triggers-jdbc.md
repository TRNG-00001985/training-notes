# Lecture/Guided Coding Example

1. Triggers

---

# Triggers

- A predefined action action that is executed everytime a specific event occurs.
- the event could be a DML command INSERT, UPDATE, DELETE .
- Triggers are usefull maintain the consistancy.



synatx

```sql
CREATE TRIGGER trigger_name [BEFORE | AFTER] [INSERT| DELETE | UPDATE]
FOR EACH ROE
// sql tatements
```

# JDBC (Java Database Connectivity)

**Singleton Design Pattern:** ensures that the class has only only ine instance for global access and the instance is created when it is needed for the first time (Lazy initialization).

1. a private constructor to prevent instantiation from other classes.
2. a private static variable to hold the single instance.
3. a public static method to provide access to the instance.

**DAO Design Pattern:** abstracts the database logic from business logic using an interface.

1. interface defining operations
2. implementation class with the actual database code

### JDBC Driver

- enabeles java appliations to access the database.

**types**

1. JDBC-ODBC bridge plus ODBC driver, also called Type 1 driver
2. Native-API, partly Java driver, also called Type 2 driver
3. JDBC-Net, pure-Java driver, also called Type 3 driver
4. Native-protocol, pure-Java driver, also called Type 4 driver

- DriverManager class then sends all JDBC API calls to the loaded driver

## JDBC Steps


1. add Mysql connector dependency
2. import packages
3. load and register the driver
4. establish connection using connection object 
5. statement
6. execution of the query
7. access the result
8. close the connection


### Statement, Prepared Statement and Callable Statement

**Statement:**

- used fot executing sql queries
- susecptibl eto SQL Injection
- suitable for DDL commands

**PreparedStatement**


- used for executing precompiled SQL queries with parameters.
- prevents SQL injection and improves performance.
- suitable when a a sql query is executed multiple times

**CallableStatement**

- used to execute stored procedures

### executeUpdate, executeQuery, execute

**executeUpdate:**

- used for executing SQL statements like INSERT, UPDATE, DELETE.
- returns the number of affected rows.

**executeQuery:**

- used for executing SELECT statements.
- returns a ResultSet containing the data.

**ResultSet:**

- a table of data representing the result of a database query.
- navigation methods: `next()`, `previous()`, `first()`, `last()`
- data retreival methods: `getDataType()` (getLong(), getString())  

**execute:**

- can be used for any type of SQL statement.
- returns a boolean. Returns true if the result is a ResultSet, false if it is an update count or no result.

**SQL Injection**

- SQL Injection is a code injection technique of injecting malicious SQL queries through user input.
- it allows attackers to access and manipulate the database. ex: unauthorized access, data manipulation, data deletion, administarative operations on the database.








