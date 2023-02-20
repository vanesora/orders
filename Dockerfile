FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar orders.jar
ENTRYPOINT ["java","-jar","/orders.jar"]