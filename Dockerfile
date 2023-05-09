FROM maven:3.9.1-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/*.jar garage-project-app.jar
ENTRYPOINT ["java","-jar","garage-project-app.jar"]
