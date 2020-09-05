#Specify a base image
FROM openjdk:8-jdk-alpine
#Copy the jars or libraries
COPY target/fib-web-service.jar fib-web-service.jar
#Default start command
CMD ["sh", "-c", "java -jar /fib-web-service.jar"]