# Lecture/ Guided coding example

1. Docker Compose
    - overview
    - volumes
    - networks
    - docker-compose.yaml

---

### Docker Compose: Overview

**Docker Compose** simplifies managing multi-container Docker applications. It uses a YAML file (`docker-compose.yaml`) to define services, volumes, and networks, making deployment easy and consistent.

### Key Concepts in Docker Compose

1. **Volumes**:
   - **Purpose**: Volumes provide persistent storage, allowing data to survive even if containers are removed.
   - **Types**:
     - **Named Volumes**: Managed by Docker, stored externally from the container, and shareable across containers.
     - **Bind Mounts**: Directly map a host machine directory to a container, useful for local development.
   - **Example**:
     ```yaml
     volumes:
       app-data:
     ```
   - In the service:
     ```yaml
     volumes:
       - app-data:/prometheus/pormetheus.yaml
     ```

2. **Networks**:
   - **Purpose**: Networks allow communication between containers in a controlled environment.
   - **Types**:
     - **Bridge**: Default network for containers on a single host.
     - **Overlay**: Used in Docker Swarm to connect containers across multiple hosts.
   - **Example**:
     ```yaml
     networks:
       backend:
     ```
   - In the service:
     ```yaml
     networks:
       - backend
     ```

3. **`docker-compose.yaml` File**:
   - This is the core of Docker Compose, defining the entire application setup, including services, volumes, and networks.
   - **Basic Structure**:
     ```yaml
     version: '3.7'
     services:
       app:
         image: demo
         ports:
           - "80:80"
         volumes:
           - ./local-data:/path
         networks:
           - backend

     volumes:
       local-data:

     networks:
       backend:
     ```
   - **Key Sections**:
     - **services**: Defines the containers, including images, ports, volumes, and networks.
     - **volumes**: Specifies persistent data storage.
     - **networks**: Manages container-to-container communication.

### Benefits:
- **Volumes** keep your data safe across container restarts and updates.
- **Networks** enable efficient and secure communication between services.
- **`docker-compose.yaml`** allows you to define, manage, and deploy multi-container apps with ease.
