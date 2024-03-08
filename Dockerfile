FROM openjdk:17

COPY . app/

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "kotlin -Dserver.port=8080 -jar target/ms-service-0.0.1-SNAPSHOT.jar"]