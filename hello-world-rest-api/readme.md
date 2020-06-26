# Hello World Rest 

## Building an Image

1. Build a Jar - /target/hello-world-rest-api.jar
2. Setup the Prerequisites for Running the JAR - openjdk:8-jdk-alpine
3. Copy the jar
4. Run the jar

### Docker Commands - Creating Image Manually
```
docker run -dit openjdk:8-jdk-alpine
docker container exec naughty_knuth ls /tmp
docker container cp target/hello-world-rest-api.jar naughty_knuth:/tmp
docker container exec naughty_knuth ls /tmp
docker container commit naughty_knuth balak143/hello-world-rest-api:manual1
docker run balak143/hello-world-rest-api:manual1
docker container ls
docker container commit --change='CMD ["java","-jar","/tmp/hello-world-rest-api.jar"]' naughty_knuth balak143/hello-world-rest-api:manual2
docker run -p 8080:8080 balak143/hello-world-rest-api:manual2
```

### Running the Application

Run RestfulWebServicesApplication as a Java Application.

- http://localhost:8080/hello-world

```txt
Hello World
```

- http://localhost:8080/hello-world-bean

```json
{"message":"Hello World"}
```

- http://localhost:8080/hello-world/path-variable/in28minutes

```json
{"message":"Hello World, in28minutes"}
```

## Docker File

### Basic
```
FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/hello-world-rest-api.jar hello-world-rest-api.jar
ENTRYPOINT ["sh", "-c", "java -jar /hello-world-rest-api.jar"]
```

 
