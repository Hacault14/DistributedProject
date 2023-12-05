FROM openjdk:11
ADD target/spring-boot-blog-app-0.0.1-SNAPSHOT.jar spring-boot-blog-app-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-blog-app-0.0.1-SNAPSHOT.jar"]