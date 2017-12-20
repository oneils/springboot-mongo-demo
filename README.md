# Project description

This is a simple Demo of using `Spring Boot` and `MongoDB`. Application has a simple form on the main page. 
Entered data on the form will be saved `users` collection in `MongoDB`. 

## Project architecture

Application consists of:

* `UserController` which handles request from `index.html` page
* `UserResource` - is `REST` endpoint for retrieving `Users`
* `UserRepository` - repository interface for persistence and retrieving `Users` from `MongoDB`

Because it's a simple demo for storing and retrieving users to/from database, `UserRepository` injected directly in 
`UserController` and `UserResource`.

## How to build project

To build, or run project `java` and `MongoDB` should be installed.

From the root folder of the project just run `./gradlew build`
Compiled `springboot-mongo-demo.jar` file can be found at `build/libs`

## How to run project locally

1. To run project from the built `.jar` file:

From the root folder of the project run the following command in terminal:

```bash
java -jar build/libs/springboot-mongo-demo.jar
```

2. To run the project with gradle:

From the root folder of the project run the following command in terminal:

```bash
gradlew bootRun
```

3.To run the project from the Intellij Idea:

Open the project in Intellij Idea  
Open `DemoApp.java` file. Right click on the `main` method and select `Run 'DemoApp.main()'` on the pop-up window.

Running the project locally assumes that `java` and `MongoDB` are installed locally.

## How to work with the application

After application is started open the following into any browser [http://localhost:8080](http://localhost:8080)

Application also provides `REST` API for retrieving all users or user by `userID`.  
To retrieve all users:
[http://localhost:8080/api/users](http://localhost:8080/api/users)   
To retrieve user by ID:   
[http://localhost:8080/api/users/user_id](http://localhost:8080/api/users/user_id)   
`user_id` should be replaced by real `ID` from the main page.

## How to run in Docker

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