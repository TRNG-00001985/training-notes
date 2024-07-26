# Lecture/Guided Coding Example

1. Casting
2. Java APIs
3. Maven

---

## Casting

### Primitives
- **Narowing:** conversion of a larger primitive to smaller one.
ex: int - > short

- **Widening:** conversion of a smaller primitive to larger one.
ex: short -> int

### Objects

- **Upcasting:** subclass reference to superclass.
- **Downcasting:** superclass reference to subclass.

## enum

- a special data type for pre defined constants
- in Java enum decleration defines a class (enum type)
- values method is used to get the array conteing all the constants in the order they are declared
- as enums are of class type they support constructors, methods and other fields.
- an enum cant extend other class beacuse it extends the `java.lang.Enum`.
- the constructors are package private or private access.

## Java APIs

### Reflection API

- used to examine and modify the runtime behavior of applications running on JVM.

#### use cases

- Extensibility Features : applications can instantiate objects for user defined classed at runtime using the fully qualified name. 
- Class Browsers and IDEs: to view the structire of the class, for code completion, quick navigation and real time error checking 
- Debugging and Testing

**Ex:**

Spring : Dependency Injection, Bean Creation and Management and AOP etc.
#### drawbacks

- performace overhead
- security restrictions
- exposure to internals

### DateTime API

- Java DateTime API is introduced in Java 8 and uses the ISO-8601 (Gregorian calender system) as the default calender.

#### datetime class or enum

- Instant
- LocalDate
- LocalDateTime
- ZonedDateTime
- LocalDate
- MonthDay
- Year
- YearMonth
- Month

## Apache Maven


- Apache maven is package manager and a build automation tool. It is used for describing, building, and managing Java applications using the POM. 
- project setup templtes
- dependency management
- isolation between the project dependencies and plugins
- central repository system


### Central Repository

- project dependencies can be loaded from a local file system(.m2/repository in the home dir of user) or a public repository, such as maven central repository.
- if an artifact or plugin is not available in local repository, it is downloaded from the maven central repository.

### POM

- Project Object Model
- maven project configuration file written in XML.
- contains the project desciption and configuration of plugins ad dependencies.




