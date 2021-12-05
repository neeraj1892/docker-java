FROM openjdk:8-jre-alpine

EXPOSE 8080
RUN mkdir /usr/app
COPY ./target/demo-1.0.1.jar /usr/app
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "demo-1.0.1.jar"]