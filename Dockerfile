FROM openjdk:11
EXPOSE 8080:8080
RUN mkdir /app
COPY ./*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]