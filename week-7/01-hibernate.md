# Lecture/ Guided Coding Example

1. Hibernate
    - Annotations for multiplicy
    - Inheritance Hierarchies
---

### Mapping entity associations / relationships

- mappings are used to establish unidirectional or bidirectional relationsips between tabels.


1. `@OneToOne`
2. `@OneToMany` and`@ManyToOne`
3. `@ManyToMany`

- `@JoinColumn`: defines a column that joins two entities.

- `@JoinTable`: defines a table that joins two entities.

  - used for one-to-one, one-to-many, many-to-one and many-to-many.

- `@PrimaryKeyJoinColoumn`: specifies that the entities primary key is a foreign key to another enity.

  - typically used for one-to-one


**nullable**: boolean value. if true allows null values.

**updatable** : boolen value. if true allows updating the FK.

**unique**: unique values

#### cascade

`CascadeType`: cascading properties from parent table to  child for `ALL`, `REMOVE`, `PERSIST` and `MERGE` etc.

#### Orphan removal

- usage is to delete orphaned entities from the database.

### Inheritance Heirarchies

Ineritance is one of the key concepts in any OOP language. RDBMS doesnt provide straight forward implementation for inheritance. Hibernate or any other JPA implementation, has to aply a mapping stratergy to map the inheritance heirarchy.

There are four stratergies for inheritance. They are:

1. Mapped Superclass

- mapped super class os not an entity but the concrete classes that inherit the mapped superclass are entities.
- If you want to share the state and mapping information between the entities mapped super calss is the suitable stratergy.
- It doesnt support the polymorphic queries(queries for instances of a class and all instances of its subclasses).


```java
@MappedSuperclass
public abstract class Payment {
    private Long id;
    private double amount;
    private String currency;
    
}

@Entity
public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardType;
    
}

@Entity
public class PaypalPayment extends Payment {
    private String paypalAccount;
    
}
```
2. Table per class 

- Each concrete entity class in the hierarchy has its own table in the database.
- support polymorphic queries and association mappings, but the polymorphic queries are complex.


```java
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {
    @Id
    private Long id;
    private double amount;
    private String currency;
    
}

@Entity
public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardType;
    
}

@Entity
public class PaypalPayment extends Payment {
    private String paypalAccount;
    
}

```


3. Single table

- maps all entities of the inheritance hierarchy to the same databse tabels
- this approach makes polymorphic queries efficient and provides the best performance.
- Since all entities are mapped to a single table each record uses only a subset of available columns and other are set to null. Therefore, you can not use the not null constraints on any column.
- The `DiscriminatorColumn` is usd to determine the entity class of each record.
- `DiscriminatorFormula` is an alternative to `DiscriminatorColumn`. You annotate the superclass (which maps the real table as default) with one of them. With `DiscriminatorColumn` it creates an additional column (as default called "dtype") which contains the discriminator value.


```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_type")
public abstract class Payment {
    @Id
    private Long id;
    private double amount;
    private String currency;
    
}

@Entity
@DiscriminatorValue("CC")
public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardType;
    
}

@Entity
@DiscriminatorValue("PP")
public class PaypalPayment extends Payment {
    private String paypalAccount;
    
}
```


4. Joined

- Joined table maps each class of inheritance heirarchy to its own table.
- superclass is mapped to a table and the subclasses are mapped to a table and share the columns in superclass.

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {
    @Id
    private Long id;
    private double amount;
    private String currency;
    
}

@Entity
public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardType;
    
}

@Entity
public class PaypalPayment extends Payment {
    private String paypalAccount;
    
}
```

### Validation

- **Validation** in Spring is used to ensure that the data being saved or processed meets certain criteria.
  - **JSR-303/JSR-380 Annotations**: `@NotNull`, `@Size`, `@Min`, `@Max`, `@Email`, etc., are used to enforce validation rules on entity fields.
  - **Custom Validators**: You can create custom validators by implementing the `ConstraintValidator` interface.
  - **BindingResult**: Captures validation errors and allows you to handle them in your controller methods.





