FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/proyectoPrueba-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_pruebajava21.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app_pruebajava21.jar"]