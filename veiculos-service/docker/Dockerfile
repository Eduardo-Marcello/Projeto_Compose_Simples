FROM amazoncorretto:22
LABEL author="eduardomarcello"
WORKDIR /app
COPY veiculos-service-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]