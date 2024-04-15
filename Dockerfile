FROM adoptopenjdk/openjdk11
COPY driver2023-0.0.1-SNAPSHOT.jar /usr/src/bootdocker/driver2023-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/bootdocker
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/usr/src/bootdocker/driver2023-0.0.1-SNAPSHOT.jar"]