# FROM openjdk:17

# COPY . app/

# WORKDIR /app

# EXPOSE 8080

# ENTRYPOINT ["sh", "-c", "java -Dserver.port=8081 -jar target/ms-service-1.0.2.jar"]

FROM maven:3.8.5-openjdk-17 as build

WORKDIR /app

COPY . .

RUN mvn clean install

FROM openjdk:17 as java17

COPY --from=build ./app/target/*.jar ./ms-service-base.jar

EXPOSE 8082
# -Dspring.profiles.active=production
# -Dserver.port=8082

ENTRYPOINT java -jar ms-service-base.jar
