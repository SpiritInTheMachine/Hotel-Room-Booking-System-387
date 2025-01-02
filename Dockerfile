FROM openjdk:17-jdk-alpine
LABEL authors="Manuel Marcano"
COPY C:/Users/MEL/Desktop/College\ related/WGUClasses/Term\ 2/Advanced\ Java\ -\ D387/target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
