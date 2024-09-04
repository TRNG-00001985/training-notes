# Lecture/ Guided Coding Example

1. Spring Data JPA

---

### Spring Data ORM

- **Spring Data ORM** integrates Spring with Object-Relational Mapping (ORM) frameworks like Hibernate, providing a simplified way to interact with relational databases.
- It abstracts data access layers, enabling developers to focus more on the business logic rather than boilerplate CRUD operations.
- Spring Data provides repositories for data access and uses annotations to map Java objects to database tables.

### Annotations

- **Annotations** in Spring Data JPA are used to map entities to database tables and define relationships, constraints, and other metadata.
  - `@Entity`: Marks a class as a JPA entity.
  - `@Table`: Specifies the table name for the entity.
  - `@Id`: Denotes the primary key of the entity.
  - `@GeneratedValue`: Configures how the primary key should be generated.
  - `@Column`: Maps a field to a specific column in the table.
  - `@ManyToOne`, `@OneToMany`, `@OneToOne`, `@ManyToMany`: Define relationships between entities.
  - `@JoinColumn`: Specifies the foreign key column in relationships.

### JPA, Hibernate & Spring Data JPA

- **JPA (Java Persistence API)**: A specification for accessing, persisting, and managing data between Java objects and relational databases.
- **Hibernate**: A popular implementation of JPA that provides additional features beyond the JPA specification.
- **Spring Data JPA**: A Spring framework module that simplifies data access using JPA. It builds on top of JPA and Hibernate, providing repository abstractions, query methods, and more.

### JPA Repository vs Crud Repository

- **CrudRepository**: A Spring Data interface providing CRUD operations (Create, Read, Update, Delete) for entities.
  - Basic methods include `save()`, `findById()`, `findAll()`, `delete()`.
- **JpaRepository**: An extension of `CrudRepository` and `PagingAndSortingRepository` with additional JPA-specific methods.
  - Adds methods like `findAll(Sort sort)`, `findAll(Pageable pageable)`, `flush()`, and `saveAndFlush()` for batch operations and pagination.

### Property Expressions

- **Property Expressions** allow you to define query methods in repositories based on entity properties.
  - Example: `findByFirstNameAndLastName(String firstName, String lastName)` automatically generates a query to find entities by `firstName` and `lastName`.
  - Supports various keywords like `And`, `Or`, `Between`, `LessThan`, `GreaterThan`, `Like`, `In`, `OrderBy`, etc.



[property expression](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)


### Pagination & Sorting

- Pagination allows you to split large datasets into manageable chunks or pages. This is particularly useful when displaying data in a UI or when processing large result sets.

**Pagination**


```java
 Pageable pageable = PageRequest.of(page, size);
 productRepository.findAll(pageable);
```

**Sort**

- Sorting allows you to order your query results based on one or more fields.

```java
 public List<Product> getProductsSorted(String sortBy) {
        return productRepository.findAll(Sort.by("name"));
    }
```

### Transaction Management

- **Transaction Management** ensures that a series of operations are executed as a single unit of work, maintaining data integrity.
- **@Transactional**: Spring annotation that marks a method or class as transactional. All methods within the transaction boundary either succeed or fail together.
- **Propagation**: Defines how the transaction should propagate to other methods. Common options include:

  **REQUIRED:**
  - Default propagation; joins the existing transaction or creates a new one if none exists.
  **SUPPORTS:**
  - Joins the existing transaction if available; executes non-transactionally if none exists.
  **MANDATORY:**
  - Must join an existing transaction; throws an exception if none exists.
  **NEVER:**
  - Must execute non-transactionally; throws an exception if a transaction exists.
  **NOT_SUPPORTED:**
  - Suspends the current transaction (if any) and executes non-transactionally.
  **REQUIRES_NEW:**
  - Suspends the current transaction (if any) and creates a new transaction.
  **NESTED:**
  - Joins the existing transaction with a savepoint; rolls back to savepoint on failure, or acts like REQUIRED if no  transaction exists.

- **Isolation**: Controls the visibility of data changes between concurrent transactions. Options include `READ_COMMITTED`, `REPEATABLE_READ`, and `SERIALIZABLE`.
  - **Rollback**: Specifies conditions under which a transaction should be rolled back.

```java
@Transactional()
```

```java
@Transactional(rollbackFor = Exception.class) 
```


