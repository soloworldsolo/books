FROM openjdk:17-oracle
ADD target/books-0.0.1-SNAPSHOT.jar books.jar
ENTRYPOINT ["java", "-jar" ,"books.jar"]
