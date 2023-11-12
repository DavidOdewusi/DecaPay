FROM openjdk:17
LABEL maintainer="decapay"
WORKDIR /app
COPY decapay-0.0.1-SNAPSHOT.jar decapay.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "decapay.jar"]

