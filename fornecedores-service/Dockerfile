# estagio de build: compila o jar com maven + jdk 17
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# baixa as dependencias antes do codigo para aproveitar o cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests -B

# estagio final: so o jre e o jar
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "app.jar"]
