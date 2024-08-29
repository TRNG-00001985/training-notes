# Lecture / Guided coding example

1. Annotation Based Configuration
2. Spring MVC
3. Spring Boot

---

### Annotation-Based Configuration

Annotation-based configuration in Spring allows you to define beans and configure dependency injection using annotations instead of XML. This approach promotes cleaner, more concise code.

- **`@Configuration`**: Marks a class as a source of bean definitions.
- **`@Bean`**: Indicates that a method produces a bean managed by the Spring container.
- **`@Autowired`**: Automatically injects dependencies into a bean's constructor, setter, or field.
- **`@ComponentScan`**: Configures component scanning, which detects classes annotated with `@Component`, `@Service`, `@Repository`, or `@Controller` and registers them as beans.

### Stereotype Annotations

Stereotype annotations are specialized annotations that indicate the role of a class in the Spring framework.

- **`@Component`**: A generic stereotype for any Spring-managed component.
- **`@Service`**: Indicates a service layer component.
- **`@Repository`**: Marks a class as a Data Access Object (DAO), also provides automatic exception translation.
- **`@Controller`**: Identifies a class as a Spring MVC controller.

### Component Scanning

Component scanning is the process of automatically detecting and registering beans in the Spring context.

- **Usage**: Typically configured using `@ComponentScan` in a `@Configuration` class or in XML. It scans the specified package and its sub-packages for classes annotated with stereotype annotations.
- **Custom Filters**: You can include or exclude specific classes during component scanning using filters.


### Spring MVC

#### Spring MVC Architecture and Annotations

Spring MVC is a framework for building web applications following the Model-View-Controller (MVC) design pattern.

**Model:** The component that deals with all the data-related logic or business logic is Model

**View:** This component deals with the UI logic of the application.

**Controller:** It is an interface between Model and View. It is used to process business logic and incoming requests, manipulate data using the Model component and interact with the Views to give the final output.

**DispatcherServlet**: The core component that dispatches requests to the appropriate handlers, configured via `web.xml` or automatically in Spring Boot.

The flow in Spring MVC is as follows:

- The request from the client is taken to web.xml which sends the request to the DispatcherServlet.

- Based on the request, the request is sent to a specific controller.

- An XML file is created for spring MVC and all the controllers are annotated with the @Controller annotation.

- The response from the controller is model and view name.

- The DispatcherServlet interacts with the view template and sends the response.

In this architecture, as the DispatcherServlet handles all the requests and sends the response there is no direct interaction between the client and the controllers.

As DispatcherServlet interacts with the view template, at any point in time the developer can change the view from JSP to thymeleaf or any other view template easily.


- **Annotations**:
  - **`@Controller`**: Defines a controller in Spring MVC.
  - **`@RequestMapping`**: Maps HTTP requests to handler methods.
  - **`@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`**: Specialized annotations for HTTP methods.


### Spring Boot

### **Comparison: Spring vs. Spring Boot**

| **Feature**                | **Spring**                                                  | **Spring Boot**                                                |
|----------------------------|-------------------------------------------------------------|----------------------------------------------------------------|
| **Configuration**          | XML-based or Java-based configuration; requires manual setup | Convention over configuration; auto-configuration based on dependencies |
| **Component Scanning**     | Manual configuration using `@ComponentScan` or XML          | Automatic. included with `@SpringBootApplication`              |
| **Dependency Management**  | Manual. Must manage dependencies explicitly                  | Pre-configured starters simplify dependency management         |
| **Setup Complexity**       | Requires detailed setup and configuration                   | Simplifies setup. project can be quickly scaffolded            |
| **Web Application**        | Requires `DispatcherServlet` configuration                  | Auto-configures web applications with embedded servers         |
| **Profiles and Environment** | Profiles need manual configuration                        | Supports profiles out of the box with easy environment-specific configuration |
| **Monitoring and Metrics** | Requires additional setup for monitoring and metrics        | Comes with built-in Actuator for easy monitoring and health checks |
| **Development Tools**      | Standard IDE tools, custom setup needed for live reload      | Devtools provide hot reload, live reload, and other features out of the box |

#### Spring Boot Tools

1. **Devtools**: Provides features like automatic restart, live reload, and configurations for a faster development experience.
2. **Lombok**: A Java library that automatically plugs into your editor and builds tools to reduce boilerplate code (e.g `@Getter`, `@Setter`, `@AllArgsConstructor`).
3. **SpringBoot Starters**: Pre-configured templates for various technologies, like `spring-boot-starter-web` for web applications, making setup faster and more straightforward.
4. **Environment**: Spring Boot uses properties or YAML files to configure environment-specific settings. Profiles (`@Profile`) can be used to manage different configurations for different environments.
   - Spring Profiles provide a way to segregate parts of your application configuration and make it be available only in certain environments. Any `@Component`, `@Configuration` can be marked with `@Profile` to limit when it is loaded.
   -  `@PropertySource` is an annotation used to declare a property file to be loaded into the Spring Environment. The properties defined in this file can then be accessed within the Spring application using the `@Value` annotation or through the Environment abstraction.
5. **SpringBoot Actuator**: Provides production-ready features like health checks, metrics, and monitoring via built-in endpoints (`/actuator/health`, `/actuator/metrics`, etc.).

### Auto Configuration

Auto-configuration in Spring Boot automatically configures your application based on the dependencies present on the classpath.

- **`@EnableAutoConfiguration`**: Automatically configures Spring beans based on the application’s environment and classpath. It's typically used in the main class.
- **`@SpringBootApplication`**: A combination of `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.


### **Request Handling and RESTful API Development**

#### **`@Controller` and `@RestController`**

- **`@Controller`**: Used in Spring MVC applications to define controllers that return views (typically HTML pages).
- **`@RestController`**: Combines `@Controller` and `@ResponseBody`, designed for RESTful APIs where the response is typically JSON or XML.
- `@ResponseBody`: tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.

#### **HTTP Method Annotations**

- **`@GetMapping`**: Maps HTTP GET requests to specific handler methods.
- **`@PostMapping`**: Maps HTTP POST requests.
- **`@PutMapping`**: Maps HTTP PUT requests.
- **`@PatchMapping`**: Mops HTTP PATCH requests.
- **`@DeleteMapping`**: Maps HTTP DELETE requests.

### **Request Data**

#### **Path Variables and Request Parameters**

- **`@PathVariable`**: Extracts values from URI templates and binds them to method parameters.
- **`@RequestParam`**: Extracts query parameters from the request URL and binds them to method parameters.

#### **`@RequestBody`**

- **`@RequestBody`**: Binds the body of the HTTP request to a method parameter, typically used for handling JSON data in RESTful APIs.


# Exception handiling


## HTTP Status Codes

- HTTP response status codes indicate whether a specific HTTP request has been successfully completed. 
- Status codes are issued by a server in response to a client's request made to the server.
Responses are grouped in five classes
- 1xx informational response (100–199) –  the request was received, continuing process
- 2xx successful (200–299) – the request was successfully received, understood, and accepted 
- 3xx redirection (300–399)  – further action needs to be taken in order to complete the request
- 4xx client error (400–499) – the request contains bad syntax or cannot be fulfilled
- 5xx server error (500–599)  – the server failed to fulfil an apparently valid request

**Examples:** 
2xx- success
- 200: OK, the request is successful and provided the requested reponse
- 201:Created
- 202: Accepted
- 204:No Content

3xx redirection 
- 301: Moved Permnenntly
- 302: Found
- 304: Not Modified

4xx: client error
- 400: Bad Request
- 401: Unauthorized
- 403: Forbidden
- 404: Not Found

5xx: server errors
- 500: Interbal server error
- 503:  Server Unavilabe

## `@ResponseStatus(code= HTTPStatus.code)`

## `@Exception Handler`
