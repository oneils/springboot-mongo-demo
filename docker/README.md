## How to run application in Docker

This section describes how to run this application and `MongoDB` in Docker containers.   
Docker should be already installed.

### Create network

```bash
docker network create spring_demo_net
```

### Run MongoDB in Docker

Create folder for storing Mongo DB data:

```bash
mkdir -p ~/mongo-data
```

Run Mongo in container:
Before starting `MongoDB` in Docker make sure Mongo is not started on the host where container will be started.

```bash
docker run --name spring-demo-mongo --network=spring_demo_net -v /home/ubuntu/mongo-data:/data/db -d mongo  
```

### Build project and copy jar file to docker folder

To build current project and copy `jar` file to the `docker` folder of current project:

```bash
./gradlew clean build && cp build/libs/springboot-mongo-demo.jar docker/
```

`docker` folder contains a `Dockerfile` from which application's image will be created

### Build application's image

Go to `docker` folder of this project and build image:

```bash
cd docker && docker build --tag=spring-demo-1.0 .
```

### Run Spring Boot in Docker

To run build application `jar` file in Docker:

```bash
docker run -d --name spring-demo --network=spring_demo_net -p 8080:8080  spring-demo-1.0 
```

### Verify application and Mongo started correctly

Open [http://localhost:8080](http://localhost:8080) into any browser, add new user and verify new user is displayed 
in `Saved Users` table.

To verify `MongoDB`'s container logs:

```bash
docker logs spring-demo-mongo
```

To verify Spring Boot Application's logs:

```bash
docker logs spring-demo
```