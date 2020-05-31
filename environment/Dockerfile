FROM openjdk:11-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=./target/desafio-back-votos-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} desafio-back-votos-application.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/desafio-back-votos-application.jar"]