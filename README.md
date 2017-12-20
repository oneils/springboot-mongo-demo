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

3. To run the project from the Intellij Idea:

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

## How to build and run application using `Docker` file

On how to run and build application using `Docker` please read this [README](docker/README.md) file or this tutorial:
[How to run Spring Boot and MongoDB in Docker container](https://dev-pages.info/how-to-run-spring-boot-and-mongodb-in-docker-container/)