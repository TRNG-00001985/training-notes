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

**[Reference](https://docs.oracle.com/javase/tutorial/index.html)**


## Object-oriented programming
Now that we have seen programs that are processed based on functions and procedures, we also have programs that run based on objects. Yes, they are more detail-oriented and help in data security and integrity.

In the programming world, we define it as a paradigm that is based on the concept of "objects", which are self-contained units of data and functionality. In OOP, objects are created from classes, which define their properties and methods. Objects can interact with each other by sending messages (method calls) and can change their internal state as a result.

OOP is commonly used in many programming languages like Java, C++, Python, C#, etc. OOP is useful for modelling real-world objects and systems, and for creating reusable and maintainable code.

### Abstraction
   
   
Imagine a scenario where we all use an ATM machine for cash withdrawals, money transfers, retrieve mini-statement, and so on in our daily life. But we don't know what internally happens inside an ATM machine when you insert an ATM card for performing any kind of operation. This is a very basic explanation of what abstraction is.
In other words, Abstraction is a technique by which we can hide the data and processes that are not required by a user.

There are 2 ways to achieve abstraction in Java. They are as follows:
1.	Abstract class
2.	Interface

Advantages of abstraction:
1.	It reduces the complexity of code readability.
2.	It removes code duplication and enhances reusability.
3.	It helps to improve the security of an application or program as only important details are provided to the user.
4.	Abstract method can be implemented to perform different tasks depending on the needs.

   
### Encapsulation
For the same ATM machine scenario, can we break open the machine just like that? No. The protective shield-like structure in the machine prevents money from being stolen and that is what we call Encapsulation. It is defined as wrapping up of data into a single unit which in this case refers to the money inside the ATM machine.

Encapsulation can be achieved in the following ways:
1.	Declaring the instance variable of the class as private, so that, it can't be accessed directly from outside the class.
2.	Assign the public setter and getter methods in the class to modify the values of the variables.

Advantages of encapsulation:
1.	The encapsulated code is more coherent and easier to change with the latest demands.
2.	It prevents other classes to gain access to private components.
3.	It enhances the maintainability of the application.
4.	It helps in achieving security.
  
   
### Inheritance
Let's consider a scenario. Suppose a bank wants to open a new ATM branch and set up a new ATM machine. It's always easier to inherit the existing code and implement it in the new machine. In this way, we can be quicker and more efficient. 
In other words, Inheritance is the mechanism by which an object acquires some/all properties of another object.

Why use Inheritance?
1.	For Method Overriding (so runtime polymorphism can be achieved).
2.	For Code Reusability.

Types of Inheritance:
1.	Single inheritance
2.	Multiple inheritance
3.	Multi-level inheritance
4.	Hierarchical Inheritance
5.	Hybrid Inheritance


### Polymorphism
To continue with our scenario, we can perform multiple operations on an ATM machine like cash withdrawal, cash deposit, PIN generation, Balance check, etc. It refers to the ability of an entity to perform multiple tasks while having the same name.

Polymorphism is of two types:
1.	Compile-time polymorphism (Method Overloading): When there are multiple functions with the same name but different parameters, then these functions are said to be overloaded.
2.	Run-time polymorphism (Method Overriding): It occurs when a derived class has a definition for one of the member functions of the base class. That base function is said to be overridden.
