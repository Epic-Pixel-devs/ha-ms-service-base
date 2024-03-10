FROM openjdk:17

COPY . app/

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -Dserver.port=8081 -jar target/ms-service-1.0.2.jar"]