FROM openjdk:11-jdk-alpine
EXPOSE 8089
ADD target/Exam-1.0.jar Exam-1.0.jar
ENTRYPOINT ["java","-jar","/Exam-1.0.jar"]
