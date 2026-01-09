FROM eclipse-temurin:17-jre
WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8443
RUN mkdir -p /app/output
ENTRYPOINT ["java","-jar","app.jar"]
