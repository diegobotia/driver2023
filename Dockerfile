FROM adoptopenjdk/openjdk11
COPY driver2023-0.0.1-SNAPSHOT.jar /usr/src/bootdocker/driver2023-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/bootdocker
EXPOSE 8089

# Comando para iniciar el contenedor MySQL
CMD ["docker", "run", "--name", "mysql-standalone", "-e", "MYSQL_ROOT_PASSWORD=sa", "-e", "MYSQL_DATABASE=driver2024", "-e", "MYSQL_USER=sa", "-e", "MYSQL_PASSWORD=sa", "-d", "mysql:5.7"]

# Comando para iniciar el contenedor de la aplicación Spring Boot
CMD ["java", "-jar", "/usr/src/bootdocker/driver2023-0.0.1-SNAPSHOT.jar"]
