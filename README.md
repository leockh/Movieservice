

Movieservice is a microservice to maintains a Movie catalog allowing creation/update/deletion of:

    • Movies

    • Movie Directors

    • Movie Ratings


All communication with the program must be via REST, and the program must allow searching on the following criteria:

    • Search movies by Director

    • Search movies where the rating is above a provided rating. 

![Overview Screenshot](https://github.com/leockh/Movieservice/blob/master/doc/images/openapi.png?raw=true)


# Features
* **View Movies** 
* **View Movie Directors** 
* **View Movie Ratings** 
* **Create Movie** 
* **Create Movie Director**
* **Update Movie**
* **Update Movie Director**
* **Update Movie Rating**
* **Delete Movie**
* **Delete Movie Director**
* **Delete Movie Rating**

# Requirements

* Java 8 or newer
* H2 file-based storage in {project.basedir}/testdb.mv.db


# Getting Started
You can run the Movieservice by maven directly.

## Running from JAR
```sh
mvn spring-boot:run
```

Open a browser and navigate to [http://localhost:8080](http://localhost:8080). 

```

## Building
After cloning the repository, building is just a matter of running a standard Maven build:
$ mvn clean package
```


## Swagger
To help document the Kafka APIs, Swagger has been included. The Swagger output is available by default at the following Kafdrop URL:
```
http://localhost:8080/swagger-ui/index.html
```

This can be overridden with the following configuration in application.properties:
```
sopenapi.movieserviceOpenAPI30.base-path=/api/v1
```

You can disable Swagger output with the following configuration:
```
swagger.enabled=false
```

## Postman Test file
```
{project.basedir}/Movieservice Test.postman_collection.json
```

## H2 Console
```
http://localhost:8080/h2-console
```
User ID:sa
Password:password
