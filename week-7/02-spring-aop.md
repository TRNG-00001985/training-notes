# Lecture/Guided coding Example

1. Spring AOP

---


# Aspect Oriented Programming

- Aspect Oriented Programming complements OOP. 
- The key unit in AOP is Aspect.
- Aspects allow modularization of concerns (logging, exception handiling and transaction management) that cut across multiple objects(cross cutting concerns). 

### AspectJ

`@AspectJ` refers to declaring aspects as regular java classes with annotations.

- alternate approach is to use schema based support (XML based).


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

3. **Advise**: action taken by the aspect at a particular join point. `around`, `before` an `after` are the different types of Advise.
   
4. **Pointcut**: Point cut is a predicate the matches a join point. Advise runs at any join point that matches the pointcut expression.

5. **Introduction**: used to declare additional fields or methods on behalf of a type.

6. **Target object or Advised Object**: An object being advised on one or more aspects.

7. **AOP Proxy**: an object created by spring AOP to implement aspect contracts(advise method executions). Spring AOP proxy is either a JDK Dynamic Proxy or a CGLIB proxy.

8. **Weaving**: 
- generating or editing code by directly modifing existing class.
- it can be done in complitime(outside the JVM) or loadtime (Inside JVM at class load time)or runtime(Inside the JVM after the class is loaded).
- Spring AOP performs weaving at the runtime.
- In Spring AOP weaving is 

