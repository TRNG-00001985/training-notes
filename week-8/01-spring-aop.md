# Lecture/Guided coding Example

1. Spring AOP

---


# Aspect Oriented Programming

- Aspect Oriented Programming complements OOP.
- Aspect-oriented programming is a way of modularizing crosscutting concerns much like object-oriented programming is a way of modularizing common concerns. AspectJ is an implementation of aspect-oriented programming for Java.
- The key unit in AOP is Aspect.
- Aspects allow modularization of concerns (logging, exception handiling and transaction management) that cut across multiple objects(cross cutting concerns). 

### AspectJ & Spring AOP

- AspectJ is a powerfull AOP framwork.
- Spring AOP is part of spring framework, and it is a proxy based AOP solution.
- AspectJ provides complete AOP features, it is stand alone and supports both compiletime and runtime weaving.
- It can be intergrated to any java application not just Spring based application.


### Steps to configure AspectJ in SpringBoot

1. add the AspectJ dependency

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.22.1</version>
    <scope>runtime</scope>
</dependency>
```

2. Anotate the main class with `@EnableAspectJAutoProxy`.

```java
@SpringBootApplication
@EnableAspectJAutoProxy
public class RevshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevshopApplication.class, args);
	}

}
```

### AOP Terminology


1. **Aspect**: 
- A modularization of a concern that cuts across muliple classes(ex: transaction management, logging and exception handiling).
- Aspects are implemented using regular classes that are annotated with `@Aspect`. In spring to configure the class as a bean `@Componenet` is also added.
  
2. **Join Point**: A point during execution of a program, such as method execution or exception handiling. In Spring AOP the join point always represents a method execution.

3. **Advise**: action taken by the aspect at a particular join point. `@Around`, `@Before`, `@After`, `AfterReturning` and `@AfterThrowing` are the different types of Advise.

### Key Differences:
| **Advice Type**      | **Execution Timing**                                    | **Use Case**                                            | **Control Over Method Execution** |
|----------------------|---------------------------------------------------------|---------------------------------------------------------|----------------------------------|
| **`@Before`**         | Before the method is called                             | Pre-conditions, logging, validation                      | No                               |
| **`@After`**          | After the method finishes (success or failure)          | Cleanup, final logging                                   | No                               |
| **`@AfterReturning`** | After the method finishes **successfully**              | Inspect or modify the return value                       | No                               |
| **`@AfterThrowing`**  | After the method throws an exception                    | Log or handle exceptions                                 | No                               |
| **`@Around`**         | Before and after the method execution                   | Full control (modify arguments, skip method, change result) | Yes                              |

   
4. **Pointcut**: Point cut is a predicate the matches a join point. Advise runs at any join point that matches the pointcut expression.

5. **Introduction**: used to declare additional fields or methods on behalf of a type.

6. **Target object or Advised Object**: An object being advised on one or more aspects.

7. **AOP Proxy**: an object created by spring AOP to implement aspect contracts(advise method executions). Spring AOP proxy is either a JDK Dynamic Proxy or a CGLIB proxy.

8. **Weaving**: 
- generating or editing code by directly modifing existing class.
- it can be done in complitime(outside the JVM) or loadtime (Inside JVM at class load time)or runtime(Inside the JVM after the class is loaded).
- Spring AOP performs weaving at the runtime. and AspectJ compiler performs weaving at compile time.
- In Spring AOP, weaveing is wiring aspects into the target objects(Advised objects).
- AspectJ offers more advanced features and can perform weaving at multiple stages, including compile-time and load-time, provida greater flexibility, but its complex.


**Usecase:**

1. AOP for logging
2. AOP exception handiling
3. For transaction management


**Implementation**

1. Add the following dependencies

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.22.1</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.9.22.1</version>
</dependency>
```
2. add `@EnableAspectJAutoProxy`  to the main configuration class

```java
@SpringBootApplication
@EnableAspectJAutoProxy
public class RevshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevshopApplication.class, args);
	}

}
```

- it enables support for handling components marked with AspectJ's @Aspect annotation.

3. Create a class annotated with `@Aspect` and `@Component`.

```java
@Component
@Aspect
public class LoggingAspect {

    //methods

}
```


