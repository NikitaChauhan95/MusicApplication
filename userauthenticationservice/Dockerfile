
    #here openjdk is docker image for Java 11, as in pom.xml Java version is 11
    FROM openjdk
    #creating a working directory inside the image
    WORKDIR usr/lib
    #setting environment variable same name that are there in application.properties file
#     ENV MYSQL_DATABASE=wave34
#     ENV MYSQL_URL=mysql://localhost:3306/wave34
    #Copy executable jar file getting created inside target and add it in usr/lib working director
    ADD ./target/userauthenticationservice-0.0.1-SNAPSHOT.jar /usr/lib/userauthenticationservice-0.0.1-SNAPSHOT.jar
    #Run the jar file
    ENTRYPOINT ["java","-jar","userauthenticationservice-0.0.1-SNAPSHOT.jar"]