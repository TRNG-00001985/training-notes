# Lecture/ Guided Coding Example 

1. MSA
    - circuit breaker
    - Messaging Queue
    - Distributed Tracing
    - Monitoring tools

---

### Circuit Breaker

The **Circuit Breaker** is a design pattern used to prevent an application from making requests to an external service that is likely to fail or has already failed. It helps in improving the **stability** and **resiliency** of an application by handling faults more gracefully, allowing systems to recover over time without overwhelming dependent services with repeated failed requests.

Key States in Circuit Breaker:

- **Closed**: Communication between services is allowed. Everything is working normally.
- **Open**: Communication between services is halted. The circuit breaker enters this state after a predefined number of failures. This prevents sending further requests to a service that is likely still down.
- **Half-Open**: A trial state where a limited number of requests are sent to check if the underlying service has recovered. If they succeed, the breaker moves back to the closed state; otherwise, it returns to open.

### Sliding Window with Circuit Breaker

A **sliding window** is a time-based or count-based mechanism used to track the number of successful or failed requests in a given period or over a specific number of attempts. This sliding window helps in evaluating the state of the circuit breaker.

- **Time-based window**: Keeps track of the success and failure ratio of requests over a time frame.
- **Count-based window**: Keeps track of a fixed number of recent requests (e.g., last 100 requests) and calculates the failure percentage.

The sliding window improves the adaptability of the circuit breaker, allowing dynamic response based on real-time conditions.

### Fallback Method

When the circuit is in the **open** or **half-open** state, the application should gracefully degrade by providing an alternative path known as a **fallback method**. The fallback method ensures that the application can handle failure without complete downtime. Examples of fallback methods include:

- Returning default data or cached data.
- Redirecting to a different service.
- Queuing the request to be processed later.

### Additional Use Cases

- **Handling intermittent failures**: For services with unpredictable downtime, the circuit breaker helps prevent cascading failures.
- **Rate limiting**: It can be combined with rate limiting to stop excessive calls to the same service.
- **Microservices architecture**: Circuit breakers are particularly useful in distributed systems where many services interact, ensuring that failures in one service don't bring down the whole system.

### Circuit Breaker Implementation in Java (Resilience4j)

**Resilience4j** is a lightweight fault tolerance library designed for Java. It provides an easy-to-implement **circuit breaker** that can be integrated with any Java-based application.

Key features of Resilience4j's Circuit Breaker:
- Configuration of failure rate thresholds.
- Support for sliding windows.
- Custom fallback mechanisms.
- Monitoring via metrics.


### Messaging Queues

A **messaging queue** is a software engineering construct used for asynchronous communication between services or components. It helps in decoupling services by enabling one service to send a message without needing an immediate response. Messages are stored in the queue until they are retrieved and processed by another service.

Key benefits of messaging queues:
- **Decoupling**: Allows services to function independently, improving the architecture’s flexibility.
- **Load balancing**: Multiple consumers can read from the queue to process messages in parallel.
- **Resiliency**: Messages remain in the queue until successfully processed, allowing retry mechanisms in case of failures.

Popular message queue systems include:
- **RabbitMQ**
- **Apache Kafka**
- **Amazon SQS**

### Event-Driven Architecture

An **event-driven architecture (EDA)** is a software design pattern where the flow of the program is determined by events such as user actions, sensor outputs, or messages from other programs. In an EDA, services react to events instead of waiting for requests. It enhances responsiveness and scalability.

Key components in event-driven architecture:
1. **Event Producers**: Services or systems that generate events.
2. **Event Consumers**: Services or systems that react to events.
3. **Event Brokers**: Middleware that helps transmit events between producers and consumers. Common event brokers include Kafka, RabbitMQ, and AWS EventBridge.

### Apache Kafka + Zookeeper

**Apache Kafka** is a distributed event streaming platform capable of handling large-scale data streams in real-time. Kafka is often used in conjunction with **Apache Zookeeper** for cluster management and coordination.

#### Key Features of Kafka:
- **Scalability**: Kafka can handle large volumes of data and distribute them across a cluster of brokers.
- **Durability**: Messages are persisted on disk for reliability.
- **Fault tolerance**: Kafka is designed to be distributed and fault-tolerant, ensuring high availability.
- **Stream processing**: Kafka Streams API allows real-time processing of event streams.

#### Role of Zookeeper in Kafka:
- **Managing Kafka brokers**: Zookeeper helps manage and coordinate Kafka brokers in a cluster.
- **Leader election**: Ensures that if a Kafka broker goes down, another broker can be selected as the leader.
- **Metadata storage**: Zookeeper stores metadata such as partition leadership information.

- by combining Kafka with Zookeeper, large-scale event-driven applications can reliably distribute and process data streams in real time.

### Distributed Tracing

Distributed tracing allows tracking the entire lifecycle of a request as it passes through various services in a microservices architecture, helping to identify performance bottlenecks and issues. Each service involved in processing the request generates tracing data, which is linked together to form a complete trace.

- **Trace ID**: A unique identifier that links all spans across services for a single request. It helps track the request end-to-end.
- **Span ID**: A unique identifier for each segment of the trace, representing individual services or operations within a service.

**Example Trace Flow**:
- **API Gateway** (Trace ID: `XYZ`, Span ID: `123`) → **Order Service** (Span ID: `456`) → **Inventory Service** (Span ID: `789`)

### Sleuth - depricated

Sleuth is a distributed tracing framework that automatically adds trace and span IDs to logs and forwards them to a tracing system like Zipkin. It integrates seamlessly with Spring Boot applications, allowing easy adoption of distributed tracing.


### Overview (Springboot actuator + Micrometer + Zipkin)
In a microservices architecture, distributed tracing is crucial to monitor and debug requests as they propagate through multiple services. **Micrometer**, **Zipkin**, and **Actuator** work together to provide a comprehensive solution:
- **Micrometer**: Offers metrics instrumentation and provides a façade over various tracing tools.
- **Zipkin**: A distributed tracing system that helps gather timing data needed to troubleshoot latency issues in service architectures.
- **Spring Boot Actuator**: Exposes built-in and custom operational endpoints, such as health checks and HTTP tracing.

### Architecture Components

1. **Spring Boot Application**:
   - Acts as the microservice or service running your business logic.
   - Provides production-ready features through **Actuator** to expose operational endpoints.
   - Metrics and traces are gathered through **Micrometer** and reported to **Zipkin**.

2. **Micrometer**:
   - Collects application metrics and traces.
   - Provides an abstraction layer for various metric libraries and tracing libraries (like Brave).
   - Metrics are propagated through **Micrometer’s Observation API**, which integrates well with **Spring Boot**.

3. **Zipkin**:
   - A tracing system that receives data from your services (via the Zipkin Reporter in Micrometer) and displays traces on its UI.
   - Helps to visualize trace data, making it easier to identify latency and failure points across your distributed architecture.

4. **Actuator**:
   - Exposes essential operational data such as health, metrics, and HTTP trace.
   - HTTP tracing in Actuator helps capture HTTP requests and responses to be displayed in **Zipkin**.

### Step-by-Step Configuration

#### 1. Add Dependencies
You need to add the following dependencies to your **`pom.xml`**:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-tracing</artifactId>
</dependency>
<dependency>
    <groupId>io.zipkin.reporter2</groupId>
    <artifactId>zipkin-reporter-brave</artifactId>
</dependency>
```

#### 2. Configure Zipkin and Actuator in `application.properties`
Set the Zipkin base URL and expose the Actuator HTTP trace endpoint:

```properties
# Enable actuator HTTP trace endpoint
management.endpoints.web.exposure.include=httptrace

# Set the Zipkin base URL
spring.zipkin.base-url=http://localhost:9411/

# Enable Micrometer tracing and metrics
management.metrics.export.enabled=true
```

#### 3. Setup Zipkin Server
Run Zipkin locally using Docker using below command:

- **Using Docker**:
  ```bash
  docker run -d -p 9411:9411 openzipkin/zipkin
  ```

#### 5. Monitoring and Viewing Traces in Zipkin
Once the application is running and you've made some HTTP requests, you can go to `http://localhost:9411` (or the Zipkin server's URL) to view the traces. Zipkin provides a UI that visualizes the trace spans, which show the flow of requests between services and any performance bottlenecks.

#### 6. Expose Operational Endpoints with Actuator
Actuator provides built-in endpoints for monitoring your application’s operational data. For HTTP trace, you can visit the `/actuator/httptrace` endpoint (ensure it’s exposed in your configuration).

### Data Flow Overview
1. A request hits the **Spring Boot** application endpoint.
2. **Micrometer** intercepts the request and creates an observation that is started when the request is received.
3. The trace data is captured, including timing and response codes, and sent to **Zipkin** for visualization.
4. **Actuator** exposes operational information such as the HTTP trace, health, and metrics, providing a holistic view of application performance.

### Benefits of This Architecture
- **Centralized Tracing**: By leveraging Micrometer and Zipkin, all requests can be traced end-to-end across services, making it easier to identify bottlenecks and failures in distributed systems.
- **Real-time Monitoring**: Actuator provides real-time insights into your application’s health and metrics, which can be integrated into monitoring systems.
- **Scalability**: This architecture works well with microservices, providing observability for each service, and can be scaled as your system grows.

This combination of **Micrometer**, **Zipkin**, and **Actuator** offers a robust solution for distributed tracing, helping developers ensure application reliability and performance in a distributed microservice environment.





