# Lecture / Guided coding Example Plan

1. Hibernate
---

## Hibernate Overview

### 1. **Object-Relational Mapping (ORM)**
Object-Relational Mapping (ORM) is a technique used to convert data between incompatible systems using object-oriented programming languages. Hibernate is an ORM framework for Java, allowing developers to map Java classes (objects) to database tables and Java data types to SQL data types.

**JPA (Java Persistence API)**: JPA is a specification for ORM in Java, defining a set of standards and guidelines that ORM frameworks like Hibernate should follow. JPA provides a set of annotations and APIs to manage relational data in Java applications. While JPA itself is not an implementation, it allows developers to switch between different ORM providers without changing the core application code. 

### ORM Providers

**Hibernate**
- One of the Object-Relational Mapping (ORM) frameworks for Java. It provides a framework for mapping an object-oriented domain model to a relational database, handling complex database interactions while abstracting much of the boilerplate code. 
- Hibernate supports various features such as caching, lazy loading, and transaction management. It's widely used in enterprise applications and integrates well with the Java Persistence API (JPA).


### 2. **Class vs. Schema**

- **Classes:** In Hibernate, classes are Plain Old Java Objects (POJOs) that represent entities in the database. Each class typically corresponds to a table in the database, and each instance of the class represents a row in that table.

- **Schema:** The database schema consists of tables, columns, and relationships that store the data. Hibernate automatically generates or interacts with this schema based on the mapping defined in the Java classes.

### 3. **Hibernate Architecture & Caches**

**Hibernate Architecture:**
- **SessionFactory:** A factory for `Session` objects. It is a thread-safe, immutable object and represents a configuration of Hibernate for a particular database. It is expensive to create, so it is typically created once and reused.
  
- **Session:** A session represents a single unit of work with the database. It is used to create, read, and delete operations for instances of mapped entity classes.

- **Transaction:** A `Transaction` represents a unit of work that is typically a group of operations that are executed together. In Hibernate, transactions are managed through the `Transaction` interface.

- **Query:** The `Query` interface is used to execute queries against the database.

- **Cache:**
  - **First-Level Cache:** Associated with the `Session` object, it is enabled by default and stores entities within the same session.
  - **Second-Level Cache:** Shared across sessions in the SessionFactory. It is not enabled by default and requires additional configuration.
  - **Query Cache:** Works with the second-level cache to store query result sets.

### 4. **Hibernate Annotations**

Hibernate annotations are a way to define metadata directly in your Java code, making it easier to manage mappings without the need for XML configuration files.

- `@Entity`: Specifies that the class is an entity and is mapped to a database table.
- `@Table`: Specifies the table in the database with which the entity is mapped.
- `@Id`: Specifies the primary key of an entity.
- `@GeneratedValue`: Defines the strategy for primary key generation.
- `@Column`: Specifies the column name in the database for a field.
- `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`: Specifies relationships between entities.
- `@JoinColumn`: Specifies the foreign key column.
  
### 7. **Hibernate Query Language (HQL)**

HQL is a powerful, object-oriented query language similar to SQL but works with objects rather than tables. It is used to perform queries on Hibernate entities.

### 8. **Java Persistence Query Language (JPQL)**

JPQL is similar to HQL but is defined by the Java Persistence API (JPA) specification. It is a query language for managing and querying persistent data in databases using Java objects.

### 9. **Native Queries**

Native queries allow you to execute raw SQL queries directly against the database, bypassing HQL/JPQL. This is useful when you need to use database-specific features or perform complex queries that are difficult to express in HQL/JPQL.

### 10. **Criteria API**

The Criteria API provides a programmatic way to create queries. It is useful for building dynamic queries where the query structure is not known until runtime.

### 6. **Inheritance Hierarchies**

Hibernate supports different strategies for mapping inheritance hierarchies:

- **Single Table Inheritance (`@Inheritance(strategy = InheritanceType.SINGLE_TABLE)`)**: All classes in the hierarchy are mapped to a single table. A discriminator column is used to distinguish between types.
  
- **Table Per Class (`@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)`)**: Each class in the hierarchy is mapped to its own table. This results in multiple tables but avoids null columns.
  
- **Joined Table (`@Inheritance(strategy = InheritanceType.JOINED)`)**: A table is created for each class, and subclasses are linked to their parent classes via foreign keys.

