FROM openjdk:17
COPY /build/libs/service-registry-0.0.1-SNAPSHOT.jar app.jar
COPY /src/main/resources/application.properties /app/application.properties
VOLUME /app
CMD ["java","-jar","app.jar"]