# Lecture/ Guided conding example

1. Consul
2. Config Server

---

## Consul

- a tool from **HashiCorp** that handles service discovery, config management, and health checks. In a microservices setup, where you have multiple services talking to each other, Consul helps by registering the services and making sure they can find one another without hardcoding endpoints.

1. **Service Discovery**: 
   - Instead of manually managing where each service is running, services just register with Consul. Then, other services query Consul to figure out where they need to connect. So no need for hardcoded URLs.
  
2. **Configuration Management**:
   - It comes with a distributed **key-value store**, meaning you can store config values in Consul, and services can pull their configs dynamically, even updating them without redeploying.
  
3. **Health Monitoring**:
   - Consul constantly checks if the services are up and running. If a service goes down, it gets removed from the list of available services, which means your app won’t try to send traffic to it.

4. **Multi-Datacenter Support**:
   - If you're working with multiple data centers, Consul can handle that too, making service discovery work across them seamlessly.

5. **Service Mesh (Consul Connect)**:
   - This adds an extra layer of security and routing. It uses mTLS (mutual TLS) for secure communication between services and lets you manage how services talk to each other, enforcing things like traffic rules.

### Consul vs. Spring Cloud Eureka

**Consul**:

- **Service Discovery**: Works across platforms, not just Java.
- **Config Management**: Built-in key-value store for dynamic configs.
- **Health Checks**: Integrated out-of-the-box.
- **Multi-Datacenter Support**: Good for global setups.
- **Service Mesh**: Consul Connect adds mTLS for security between services.

**Spring Cloud Eureka**:

- **Service Discovery**: Tailored for **Spring Cloud** and **Netflix OSS** stack.
- **High Availability**: Peer-to-peer setup for redundancy.
- **Self-Preservation Mode**: Protects from over-eviction during network issues.
- **Tight Integration**: Works seamlessly with **Spring Boot** apps.



### Comparision

- **Consul**: If you’ve got mixed tech stacks, need config management, or multi-datacenter support.
- **Eureka**: If you’re all-in on Spring and want something tightly integrated.


#### Steps to configure consul:

1. Install consul from [consul](https://developer.hashicorp.com/consul/install)
2. Add the path to the environmental variables
3. run `Consul agent -dev` in terminal
4. access consul in `http://localhost:8500`
5. create a key/value folder.
6. add the following dependencies in springboot app:

```xml
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
        <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-consul-config</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-consul-discovery</artifactId>
		</dependency>

```

7. add the config info in application.properties

```
spring.cloud.consul.host=localhost
spring.cloud.consul.port=8500
spring.cloud.consul.enabled=true
spring.cloud.consul.config.prefix=
spring.cloud.consul.config.format=properties
spring.cloud.consul.config.name=config/demo
spring.cloud.consul.config.data-key=key-nmae
```


## Config Server


- Spring Cloud Config Server centralizes configuration management for distributed applications.

### **Key Features**:

1. **Centralized Configuration**: Manage configs in one place (e.g., Git), simplifying updates.
2. **Environment Profiles**: Different settings for dev, test, and prod environments.
3. **Dynamic Updates**: Change configurations without restarting applications.
4. **Encryption**: Securely encrypt sensitive data like passwords and API keys.
5. **Spring Boot Integration**: Easy to set up with just `@EnableConfigServer`.


### **Setup**:
- **Repository**: Use a Git repo (or supported backend) for config files.
- **Configuration**: Define the repo details in `application.yml` or `application.properties`.
- **Client**: Point your Spring Boot apps to the Config Server endpoint.

### **Use Cases**:
- For multiple microservices needing consistent configuration.
- To avoid hardcoding configs in your codebase.
- When you want to update settings without downtime.

