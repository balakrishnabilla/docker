# Hello World Rest VISITS API using redis as in memory cache

### Docker Commands - Creating Manually
```
download redis from https://github.com/dmajkic/redis/downloads

run redis server locally
run hello-world-visits locally on 8080
make sure you have spring.redis.host=localhost

```
### Run it on docker Manually
````
docker network create redis-network
docker run -p 6379:6379 --network=redis-network --name=redis-server redis
docker run -p 8080:8080 --network=redis-network --name=hello-world-service visits:latest
make sure you have spring.redis.host=redis-server
docker network inspect redis-network

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

- http://localhost:8080/hello-world/path-variable/hither

```json
{"message":"Hello World, hither"}
```
```
http://localhost:8080/hello-world/visits
```
## Docker File

### Basic
```
#Specify a base image
FROM openjdk:8-jdk-alpine
#Copy the jars or libraries
COPY target/hello-world-rest-api-visits.jar hello-world-rest-api-visits.jar
#Default start command
CMD ["sh", "-c", "java -jar /hello-world-rest-api-visits.jar"]

```
#DOCKER COMPOSE
```
version: '3.7'
services:

  redis-server:
    image: 'redis'

  hello-world-service:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - redis-server
```
```
docker network inspect redis-network
docker-compose up --build
docker-compose down
```

#References
````
https://dzone.com/articles/implementation-of-redis-in-micro-servicespring-boo
```
