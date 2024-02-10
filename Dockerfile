#
# Build Stage
#
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

#
# package stage
#
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/springboot-0.0.1-SNAPSHOT.jar /app/springboot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/springboot-0.0.1-SNAPSHOT.jar"]