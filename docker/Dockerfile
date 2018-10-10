FROM java:8
RUN mkdir -p /usr/src/myapp
WORKDIR /usr/src/myapp
COPY memoir-0.0.1-SNAPSHOT.jar /usr/src/myapp/app.jar
ENTRYPOINT ["java", "-jar","/usr/src/myapp/app.jar"]
