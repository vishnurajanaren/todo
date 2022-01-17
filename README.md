# todo app


Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [PostgreSQL](https://www.postgresql.org/download)
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.todo.TodoApplication` class from your IDE.

## Plain REST API CRUD with Spring Boot 2 and PostgreSQL.

[![Build Status](https://travis-ci.org/OKaluzny/spring-boot-rest-api-postgresql.svg?branch=master)](https://travis-ci.org/OKaluzny/spring-boot-rest-api-postgresql)

### Technology stack:

* Spring Boot 2;
* Spring Web;
* Spring Data;
* PostgreSQL database;
* Hibernate;
* Lombok;
* Spring Security (as basic authentication).

#### To run this application use:

```bash
mvn spring-boot:run
```

### Example API URL in the Postman: 
[http://localhost:8097/todo/task/all](http://localhost:8097/todo/task/all)

