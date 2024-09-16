# Lecture/ Guided coding example

1. Load balancer
2. monitoring (prometheus + grafana)

---


### Load Balancing

- Load Balancing distributes incoming traffic across multiple servers to ensure no one server gets overwhelmed. This boosts availability and performance.

### Key Points:
- **Types**: Hardware (physical), Software (cloud/on-prem), and Client-Side (e.g., Spring Cloud LoadBalancer).
- **Algorithms**: 
  - **Round Robin**: Cycles through servers.
  - **Least Connections**: Goes to the server with fewer connections.
  - **IP Hash**: Routes based on client IP.
  - **Weighted Round Robin**: Prioritizes servers with higher capacity.

### Benefits:
- **High Availability**: Traffic is rerouted when a server fails.
- **Scalability**: Add more servers easily, and traffic is distributed automatically.
- **Optimized Resources**: Balances the load, preventing server overload.
- **Better Performance**: Reduced response times for users.

### Use Cases:
- **Microservices** and **Web Servers** benefit from dynamic load balancing, especially in high-traffic environments.


### API Gateway - Spring Cloud Gateway
- **Definition**: The API gateway routes requests to appropriate services, acting as an entry point for all client requests.
- **Key Features**:
  - **Routing**: Routes requests to appropriate microservices.
  - **Security**: Can provide security (authentication, authorization) at the gateway level.
  - **Load Balancing**: Distributes traffic to backend services usng `Spring cloud load balancer`.
  - **Caching and Monitoring**: Integrates with monitoring and can cache responses.
  
### Spring cloud load balancer
- Spring Cloud LoadBalancer is a client-side load balancer. It distributes requests from clients across available instances of a service. Rather than depending on a centralized load balancer, each client is responsible for deciding where to send its requests.

**Workflow:**
1. Service Discovery: LoadBalancer gets information about the available instances of a service (e.g., through a service registry like Eureka or Consul).
2. Request Distribution: It selects a healthy instance based on its algorithm and forwards the request to that instance.
3. Fault Tolerance: If one instance goes down, LoadBalancer will avoid sending requests to it and redirect to healthy instances.

### Load balancer filter in spring cloud gateway

The LoadBalancer Filter may be used in configuration by using a URI with the lb scheme. (lb://service-name), it uses the Spring Cloud LoadBalancerClient to resolve the name to an actual host and port and replaces the URI in the same attribute.


### Monitoring




