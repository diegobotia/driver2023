FROM adoptopenjdk/openjdk11
# Descargar la imagen de MySQL durante el proceso de construcción
RUN docker pull mysql:5.7
COPY driver2023-0.0.1-SNAPSHOT.jar /usr/src/bootdocker/driver2023-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/bootdocker
EXPOSE 8089

# CMD para iniciar el contenedor MySQL y la aplicación Spring Boot
CMD ["sh", "-c", "docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=sa -e MYSQL_DATABASE=driver2024 -e MYSQL_USER=sa -e MYSQL_PASSWORD=sa -d mysql:5.7 && docker run -d -p 8089:8089 --name docker2023 --link mysql-standalone:mysql docker2023"]
# Comando para iniciar el contenedor de la aplicación Spring Boot
CMD ["java", "-jar", "/usr/src/bootdocker/driver2023-0.0.1-SNAPSHOT.jar"]
