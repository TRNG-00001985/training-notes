# Lecture/ Guided Coding Example 

1. MSA

    - SOA
    - MSA
    - Discovery Server & Eureka Server
    - API Gateway
    - Load Balancer

---

### SOA and MSA

### SOA (Service-Oriented Architecture)

Service Oriented Architecture (SOA) is a method of software development that uses software components called services to create business applications. Each service provides a business capability, and services can also communicate with each other across platforms and languages.


- **Key Features**:
  - **Service Reusability**: Each service can be reused in different applications.
  - **Interoperability**: Services can communicate across different platforms and technologies using standardized protocols like SOAP or REST.
  - **Loose Coupling**: Services are independent, with well-defined interfaces.
  - **Service Contract**: A formal definition (WSDL or OpenAPI) of the interaction with a service.
  

### Microservices Architecture (MSA)
- **Definition**: Microservices Architecture divides an application into smaller, independent services, each handling a specific business function.
- **Characteristics**:
  - **Independent Deployment**: Services can be deployed, updated, and scaled independently.
  - **Fine-Grained Services**: Each service is responsible for a single business capability.
  - **Decentralized Data Management**: Each microservice manages its own database, allowing for polyglot persistence.
  - **Technology Agnostic**: Different services can use different languages, frameworks, and databases.
  
#### MSA vs Monolith
- **Monolith**:
  - Entire application is one unified block.
  - Tightly coupled, making updates more difficult.
  - Scaling involves scaling the entire application.
  
- **MSA**:
  - Application is divided into independent microservices.
  - Easier to develop, maintain, and scale.
  - Individual services can be scaled based on demand, leading to more efficient resource utilization.

### 12 Factor App (Key for MSA)
- **Characteristics**:
  1. **Codebase**: One codebase tracked in version control, many deploys.
  2. **Dependencies**: Explicitly declare and isolate dependencies.
  3. **Config**: Store config in the environment.
  4. **Backing Services**: Treat backing services as attached resources.
  5. **Build, Release, Run**: Strictly separate build and run stages.
  6. **Processes**: Execute the app as one or more stateless processes.
  7. **Port Binding**: Export services via port binding.
  8. **Concurrency**: Scale out via the process model.
  9. **Disposability**: Maximize robustness with fast startup and graceful shutdown.
  10. **Dev/Prod Parity**: Keep development, staging, and production as similar as possible.
  11. **Logs**: Treat logs as event streams.
  12. **Admin Processes**: Run admin/management tasks as one-off processes.

- **Advantages of MSA**:
  - Scalability: Each service can scale independently.
  - Flexibility: Teams can use different technologies for each microservice.
  - Resilience: Failure in one service does not affect the entire application.

- **Disadvantages of MSA**:
  - Complexity: Requires a mature DevOps setup and advanced monitoring.
  - Data Consistency: Managing transactions across services is complex.
  - Network Latency: Increased communication between services may lead to performance issues.

### Eureka Client: Registering Services with the Discovery Server

Eureka Client is used by microservices to register themselves with the **Eureka Discovery Server** and discover other services for communication. This allows for dynamic service discovery in a microservices architecture.

#### Steps to Register Services with Eureka Discovery Server

1. **Add Eureka Client Dependency**:
   - Add the following dependency to your Spring Boot microservice's `pom.xml` to enable Eureka client functionality:
     ```xml
     <dependency>
         <groupId>org.springframework.cloud</groupId>
         <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
     </dependency>
     ```

2. **Enable Eureka Client**:
   - Annotate the main application class with `@EnableEurekaClient` to indicate that this microservice will act as a Eureka client:
     ```java
     @SpringBootApplication
     @EnableEurekaClient
     public class MyServiceApplication {
         public static void main(String[] args) {
             SpringApplication.run(MyServiceApplication.class, args);
         }
     }
     ```

3. **Application Properties Configuration**:
   - Configure your service in the `application.properties` or `application.yml` file to point to the Eureka Discovery Server and register itself.
   - Example configuration:
     ```properties
     spring.application.name=my-service
     eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
     eureka.instance.prefer-ip-address=true
     ```

   - **Key Configurations**:
     - `spring.application.name`: The name of the microservice that will register with Eureka. This name will be used by other services to discover it.
     - `eureka.client.service-url.defaultZone`: The URL of the Eureka server where the client will register itself. Typically points to `http://<eureka-server-host>:8761/eureka/`.
     - `eureka.instance.prefer-ip-address`: When set to `true`, the service registers with its IP address rather than its hostname.

4. **Service Registration**:
   - Once the service is started, it will automatically register itself with the Eureka Discovery Server.
   - In the Eureka Dashboard (usually accessible at `http://localhost:8761`), you should be able to see the registered microservices under the `Instances currently registered with Eureka` section.


### Discovery Server (Netflix Eureka)
- **Purpose**: Manages service registration and discovery, allowing microservices to find each other.
- **Key Components**:
  - **Eureka Server**: Acts as a service registry where microservices register themselves.
  - **Eureka Client**: Microservices acting as clients use this to discover and communicate with other services.

- **Configuring Discovery Server**:
  1. Set up a Eureka server using Spring Boot.
  2. Add necessary dependencies (`spring-cloud-starter-netflix-eureka-server`).
  3. Annotate the main class with `@EnableEurekaServer`.
  4. Microservices register by adding the dependency `spring-cloud-starter-netflix-eureka-client` and configuring application properties.


[reference](https://spring.io/guides/gs/service-registration-and-discovery)


### API Gateway - Spring Cloud Gateway
- **Definition**: The API gateway routes requests to appropriate services, acting as an entry point for all client requests.
- **Key Features**:
  - **Routing**: Routes requests to appropriate microservices.
  - **Security**: Can provide security (authentication, authorization) at the gateway level.
  - **Load Balancing**: Distributes traffic to backend services.
  - **Caching and Monitoring**: Integrates with monitoring and can cache responses.


---

### Load Balancer - Ribbon
- **Definition**: Ribbon is a client-side load balancer used to distribute requests across available instances of a microservice.
- **Key Features**:
  - **Dynamic Load Balancing**: Automatically discovers service instances via Eureka.
  - **Custom Rules**: Can implement load balancing strategies (e.g., Round-Robin, Weighted Response Time).
  - **Client-Side**: Load balancing happens at the client, allowing flexibility in selecting a service instance.
