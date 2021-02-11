FROM openjdk:8
ADD /target/skillwill-test.jar skillwill-test.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "skillwill-test.jar"]