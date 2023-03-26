FROM amazoncorretto:17-alpine-jdk
MAINTAINER JoacoPerezCampos
COPY target/jepc-0.0.1-SNAPSHOT.jar jepc-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/jepc-0.0.1-SNAPSHOT.jar"]
