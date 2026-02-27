FROM maven:3-eclipse-temurin-25 AS build
ADD . /project
WORKDIR /project
RUN mvn -e -Dmaven.test.skip package

FROM eclipse-temurin:25-jre
COPY --from=build /project/target/rpsjpa-0.0.1-SNAPSHOT.jar /app/rps.jar
ENTRYPOINT java -jar /app/rps.jar