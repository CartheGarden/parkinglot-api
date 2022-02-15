FROM openjdk:11

EXPOSE 8080

ADD build/libs/parkinglot-api-0.0.1-SNAPSHOT.jar parkinglot-api.jar

ENTRYPOINT ["java","-jar","parkinglot-api.jar"]
