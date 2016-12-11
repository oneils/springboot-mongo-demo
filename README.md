# Project description
This is a simple Demo of using `Spring Boot` and `MongoDB`. Application has a simple form on the main page. 
Entered data on the form will be saved `users` collection in `MongoDB`. 

# How to build project
To build, or run project `java` and `MongoDB` should be installed.

From the root folder of the project just run `./gradlew build`
Compiled `springboot-mongo-demo.jar` file can be found at `build/libs`

# How to run project locally

1. To run project from the built `.jar` file:
From the root folder of the project run the following command in terminal:
```bash
java -jar build/libs/springboot-mongo-demo.jar
```

2. To run the project with gradle:
From the roor folder of the project run the following command in terminal:
```bash
gradlew bootRun
```

3.To run the project from the Intellij Idea:
Open the project in Intellij Idea  
Open `DemoApp.java` file. Right click on the `main` method and select `Run 'DemoApp.main()'` on the pop-up window.

Running the project locally assumes that `java` and `MongoDB` are installed locally.

## Project architecture
Application consists of:
* `UserController ` which handles request from `index.html` page
* `UserResource` - is `REST` endpoint for retrieving `Users`
* `UserRepository` - repository interface for persistence and retrieving `Users` from `MongoDB`

Because it's a simple demo for storing and retrieving users to/from database, `UserRepository` injected directly in 
`UserController` and `UserResource`.
