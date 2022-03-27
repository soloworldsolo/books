FROM openjdk:17-oracle
ADD target/books.jar books.jar
ENTRYPOINT ["java", "-jar" ,"books.jar"]
