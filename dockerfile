FROM openjdk:11
ADD /target/myApp-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT docker["java","-jar","backend.jar"]