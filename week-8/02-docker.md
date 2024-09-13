# Lecture/ Guided coding example

1. Docker
    - Container vs VMs
    - Contenarization
    - Docker Architecture
    - Installing Docker
    - Docker Images
    - Dockerfile
    - Docker containers
    - Docker Hub
    - Docker CLI Commands
---

- Docker is a open source platform for developing, shipping and running applications. 
- Docker allows to package and run an application  in a loosely isolated environment called a container.


**Docker Architecture**


![Docker Architecture](./images/docker-architecture.webp)


**Docker Client**: Docker client communicates with docker daemon using docker API.

**Docker daemon** : listens for docker api requests. manages docker objects (images, containers, volumes and netwrorks).

**Docker image**: Template with instructions to create docker conatiner. Contains everything thats necessary to run an application( socurce code + config files). Also contains a execution command that is executed when the image in run in a container.

**Docker Container**: An isolated enviorment to run docker images.

**Docker Registry**: A store for docker images. 

- private registry
- public registry: docker hub.


**Docker Commands**

1. `docker ps`: list running containers
2. `docker ps -a` list all containers
3. `docker image ls` or `docker images` : list all images in private registry
4. `docker run [-d](detached mode) -p ` : to run the image in a container. (`docker create image-name` + `docker start container-id`)
5. `docker build path/to/project -t name:version` : to build a docker image
6. `docker pull`: to pull the image from the docker hub.
7. `docker push`: to push the image to  the docker hub.
- create a repository in docker hub
- tag the image `dokcerhubid/name:version`
- `docker push image-name`
1. `docker start container-id`: to start a container
2. `docker stop container-id`: to stop a conatiner. it waits for program to stop running.
3.   `docker kill container-id`: to stop a container
4.   `docker rm container-id` : to delete a container
5.   `docker image rm image-id` : to delete an image
6.   `docker system prune` : all the stopped containers and unused images, networks and volumes are deleted.
7.   `docker exce container -it id command [sh](shell)` : to execute a commands inside of the container.
8.   `docker logs  container-id` : show log files of a container
9.   `docker logs  --since time container-id` : show log files of a container for a specific period of time
10.  `docker logs  --tail n container-id` : show log files of a container with count n.
11.  `docker init` : helpfull to build an image with guided procedure.

-it : -i +-t

`-i` : keeps SDIN open
`-t` : makes sure that the text is entered and output text is formated properly.


**Dockerfile**

- Docker builds images by reading the instructions from a Dockerfile. Dockerfile is a text file that contains instructions.

commands used in docker file:

1. FROM <image>: Defines a base for your image.
2. RUN <command>: Executes any commands in a new layer on top of the current image and commits the result. RUN also has a shell form for running commands.
3. WORKDIR <directory>	: Sets the working directory for any RUN, CMD, ENTRYPOINT, COPY, and ADD instructions that follow it in the Dockerfile.
4. COPY <src> <dest>: Copies new files or directories from <src> and adds them to the filesystem of the container at the path <dest>.
5. CMD <command>: Lets you define the default program that is run once you start the container based on this image. Each Dockerfile only has one CMD, and only the last CMD instance is respected when multiple exist.

---


VM Isntance


1. `sudo yum install -y docker`
2. `sudo service docker start`
3. `sudo service docker stop`
4. `sudo service docker status`