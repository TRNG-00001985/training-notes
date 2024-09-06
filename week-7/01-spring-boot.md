# Lecture/Guided coding example

1. Response entity
2. Exception Handiling
3. Spring Boot Actuator

---

### ResponseEntity Class

- **ResponseEntity** is a Spring class used to represent the entire HTTP response, including the status code, headers, and body.
  - Provides greater control over the HTTP response returned by RESTful APIs.
  - Common methods include `status(HttpStatus status)`, `body(Object body)`, and `headers(HttpHeaders headers)`.
  - Allows you to set status codes like `200 OK`, `404 NOT FOUND`, or `500 INTERNAL SERVER ERROR` based on the outcome of a request.


```java
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@RequestParam Long id) {

        return userService.getUserById(id);
    }
```

is same as

```java
    @GetMapping
    public ResponseEntity<UserResponse> getUserById(@RequestParam Long id) {

        UserResponse userResponse =  userService.getUserById(id);

        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>(userResponse, responseHeaders, HTTPStatus.ok);
        or

        return new ResponseEntity.ok().headers(responseHeaders).body(userResponse);
    }
```

### Exception Handiling


#### Basic Exception Handling in Spring:
- **`@ExceptionHandler`**: Used to handle exceptions at the controller level. It allows handling specific exceptions thrown in the controller methods.

#### Global Exception Handler with `@ControllerAdvice`:
- **`@ControllerAdvice`**: A global handler for exceptions that applies across all controllers. It enables centralized exception handling.
  

#### **Best Practices**:
- **Create custom exceptions** for specific error scenarios (e.g `ProductNotFoundException`).
- **Return meaningful HTTP statuses** (`HttpStatus.BAD_REQUEST`, `HttpStatus.NOT_FOUND`, etc.) in the response.
- **Use a global exception handler** to avoid repetitive exception handling code in controllers.

#### Where to Place the Global Exception Handler?:
- Define it in a separate package (e.g., `exception`, `error`) for better modularity and separation of concerns. This class will be applied across the entire application.

### Spring Boot Actuator

Spring Boot Actuator provides production-ready features to help you monitor and manage your application, such as health checks, metrics, and more.

#### **Core Features**:
- **Health Check** (`/actuator/health`): Reports the application's health status (UP or DOWN). It can include custom health indicators.
- **Metrics** (`/actuator/metrics`): Provides detailed metrics like memory usage, CPU load, and custom application metrics.
- **Auditing and Tracing**: Actuator enables auditing of your application and provides trace information for requests.
- **Info Endpoint** (`/actuator/info`): Displays application information such as version, build time, and other metadata.

#### **Enabling Actuator**:

1. Add **Spring Boot Actuator dependency** in `pom.xml`:
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
   ```
2. **Expose specific Actuator endpoints** in `application.properties` or `application.yml`:
   ```properties
   management.endpoints.web.exposure.include=health,info,metrics
   ```

[reference for endpoints](https://docs.spring.io/spring-boot/reference/actuator/endpoints.html)

#### **Security for Actuator Endpoints**:
  
  Example configuration:
  ```properties
  management.endpoint.health.show-details=always
  management.endpoints.web.exposure.include=*
  # Secure sensitive endpoints like `/actuator/metrics` and `/actuator/health` with Spring Security.

  management.security.enabled=true
  ```

#### **Best Practices**:
- **Monitor important application components** using Actuator's metrics and health checks.
- **Expose only necessary endpoints** for production environments to avoid security risks.
- **Integrate Actuator with monitoring tools** like Prometheus or Grafana for real-time monitoring.







