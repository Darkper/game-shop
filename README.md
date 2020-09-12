# game-shop
Game Shop Demo


# How it works

The application uses Spring boot (Web, Jpa).

* Use the idea of Domain Driven Design to separate the business term and infrastruture term.
* Use Jpa to implement the repositories for persistence.
* Use [CQRS](https://martinfowler.com/bliki/CQRS.html) pattern to separate the read model and write model.

And the code organize as this:

1. `api` is the web layer to implement by Spring MVC
2. `core` is the business model including entities and services
3. `application` is the high level services for query with the data transfer objects
4. `infrastructure`  contains all the implementation classes as the technique details

# Database

Use MySql database, the connection and password are found `application.properties`.

# Getting started

You need Java 11 installed.

    ./gradlew bootRun
    
The entry point address of the backend API is at http://localhost:8080/api
