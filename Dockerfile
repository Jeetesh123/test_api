# Use maven to build the application
FROM maven:3.9.8-amazoncorretto-17-al2023 AS build 
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use OpenJDK to run the application
FROM openjdk:17-slim-bullseye
WORKDIR /app
COPY --from=build /app/target/test_api.jar app.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "app.jar"]