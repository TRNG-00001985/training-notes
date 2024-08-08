# Lecture/Guided Coding Example Plan

1. Functional Programing
   - Method References
   - Optional Class
   - Stream API

---

## Optional

- Object that might or might not contain a value.
- used to provide an optional object instead of a null reference.


syntax

```java
Optional<T> varName
```

**methods**

1. empty() creates an empty optional obj
2. of() - not null values as args
3. ofNullable() - allows null and not null values as input
4. isPresent() - returns true if value is present else false
5. isEmpty() - retruns true if value is absent else false
6. get() - if value is present retruns the value else throws `NoSuchElementException`
7. ifPresent() - an action if the value is present
8. orElse() - returns the value if presnet otherwise returns other
9.  orElseGet() - returns the value if presnet otherwise invokes a function
10. orElseThrow() - Returns the contained value if present, otherwise throws an exception.



## Stream API


- streams let you write codes in declarative style rather than typical imperative programming technique.


### Stream vs Collection


1. **No Storage**:
   - **Streams**: Do not store data. They process data from collections or other sources.
   - **Collections**: Store data in memory.

2. **Functional in Nature**:
   - **Streams**: Support functional programming paradigms with operations like map, filter and reduce.
   - **Collections**: Use imperative operations for data manipulation and retrieval.

3. **Laziness Execution**:
   - **Streams**: Support lazy evaluation, meaning operations are deferred until the terminal operation is invoked.
   - **Collections**: Execute operations immediately and eagerly.

4. **Possibly Unbound**:
   - **Streams**: Can be unbounded, processing data as it becomes available (ex: infinite streams).
   - **Collections**: Typically bounded, holding a finite amount of data.

5. **Consumable**:
   - **Streams**: Are consumable;.once processed, they cannot be reused.
   - **Collections**: Are not consumable; data can be accessed and manipulated multiple times.



## Method References

- method references are used to refer to the existing method by name.
- method references further simplify lambda expression mplementation by refereing to the existing method by name.

**Kinds of references:**

  - Static method
  - Instance methods of a particular objects
  - Instance methods of an arbitrary object of a particular type
  - Constructor

