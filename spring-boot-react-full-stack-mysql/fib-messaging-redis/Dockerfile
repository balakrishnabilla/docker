#Specify a base image
FROM openjdk:8-jdk-alpine
#Copy the jars or libraries
COPY target/fib-messaging-redis-0.0.1-SNAPSHOT.jar fib-messaging-redis.jar
#Default start command
CMD ["sh", "-c", "java -jar /fib-messaging-redis.jar"]