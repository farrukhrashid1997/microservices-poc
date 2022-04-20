FROM openjdk:17
EXPOSE 8989
ADD target/cloud-gateway.jar cloud-gateway.jar
ENTRYPOINT ["java", "-jar", "/cloud-gateway.jar"]
