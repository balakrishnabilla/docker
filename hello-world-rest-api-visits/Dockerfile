#Specify a base image
FROM openjdk:8-jdk-alpine
#Copy the jars or libraries
COPY target/hello-world-rest-api-visits.jar app/hello-world-rest-api-visits.jar
#Default start command
CMD ["sh", "-c", "java -jar app/hello-world-rest-api-visits.jar"]

