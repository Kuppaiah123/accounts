FROM adoptopenjdk/openjdk8 as build

MAINTAINER com.app

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]