# Plan

1. Java Classes & Objects
2. Methods

## Classes & Objects

### Object

- a software bundle of state and behavior.
- instance of a class
- data encapsulation : hiding internal state and interacting using objects methods.
- decleration, instantiation and initialization
  
### Class

- A blue print from which an object is created
- state is stored in fields and behavior is exposed through methods.

#### Class Members

- variales
- methods
- contants

### Interface

- The interface containes the behavior of an object. (methods of a class)
  
### Package

- A package is a namespace that organizes the related classes and intefaces.

#### Benifits

- modularity
- Information hiding
- code re-use
- plugabillity and debugging ease 


#### Member variables

- fields
- local variables
- paramaters


### Methods

- used to define the behavior of an object

**components:**

- modifier
- return type
- method signature (name+ parameter list)
- exception list
- metod body

### Constructors

- invoked when creating objects from the class.
- declerations are similar to method except the name is class name and no return type

Types:

- No Args Constructor
- Parameterised constructor

### this and super keywords
- this() : used to call the cinstructor of the same class
- this: reference to the current object
- super() : used to call the parent class constructor
- 

### Access Modifiers

- public : globally accessible
- private : can be accessed in the class
- protected : package private and can be accessed by the subclasses
- default : package-private


|  Modifier | Class | Package | Subclass | World |
|:---------:|:-----:|:-------:|:--------:|:-----:|
| public    | Y     | Y       | Y        | Y     |
| protected | Y     | Y       | Y        | N     |
| default   | Y     | Y       | N        | N     |
| private   | Y     | N       | N        | N     |

### Non Access Modifiers

- static : shared accross all instances of a class
- final : methods cant an overriden, variables and method parameters cant be reassigned
- abstract : used to declare abstract class and methods
- synchronized : prevents multithreading for a block of code
- volatile : changes made to a varibale is reflected across multiple threads
- transient : prevents serialization of a member variable of a class
- native : indicate that the methods is implemented in other languages like C and C++.

#### Static members

- methods : can be accessed direcly using class name and cant access the instance variables of a class
- blocks : used to initialize the static variables in a class
- variables : values shared across all instances and can be directly accessed using class name
- static nested classes : cant access the instance variables and methods of an enclosing class



### Interface & Abstract classes

**Inteface:** 

- reference type
- contains:
  - constants : static and final
  - default methods : new functionality
  - static methods : utility methods or elper methods
  - nested types
- all methods and constants are public by default

**Abstract Class**

- declared abstract but may or may not include the abstract methods
- declare fields that are not constants
- declare concrete methods
- may have static methods

### Nested Classes

- static nested class : cannot access the outer class instance variables and methods.
- inner class: access to outer class variables and methods. cant define any static members.

#### Shadowing

- declaration of a variable or parameter in a particular scope has the same name as another decleration in the enclosing scope.

