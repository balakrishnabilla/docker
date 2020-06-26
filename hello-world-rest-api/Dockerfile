#Specify a base image
FROM openjdk:8-jdk-alpine
#Copy the jars or libraries
COPY target/hello-world-rest-api.jar hello-world-rest-api.jar
#Default start command
CMD ["sh", "-c", "java -jar /hello-world-rest-api.jar"]


