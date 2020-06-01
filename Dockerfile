FROM openjdk:8-jdk

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/*.jar

ADD wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["./wait-for-it.sh", "mysql-container:3306", "--", "java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
