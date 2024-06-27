# Spring Boot Hello World

**A simple Spring Boot 2.x app to send hello world message to a user**

## How to Run Application

**Start the application using any of the commands mentioned below**

> **Note:** First two commands need to run inside the root folder of this project i.e inside the **spring-boot-hello-world** folder


- **Using maven** <br/>``` mvn spring-boot:run```


- **From jar file**
  Create a jar file using '**mvn clean install**' command and then execute
  <br/>```java -jar target/spring-boot-2-hello-world-1.0.2-SNAPSHOT.jar```


- **Directly from IDE**
  <br/>```Right click on HelloWorldApplication.java and click on 'Run' option```
  <br/><br/>

> **Note:** By default spring boot application starts on port number 8080. If port 8080 is occupied in your system then you can change the port number by uncommenting and updating the **server.port** property inside the **application.properties** file that is available inside the **src > main > resources** folder.

<br/>

**Send an HTTP GET request to '/hello' endpoint using any of the two methods**

- **Browser or REST client**
  <br/>```http://localhost:8080/hello```


- **cURL**
  <br/>```curl --request GET 'http://localhost:8080/hello'```

**Send an HTTP GET request to '/goodbye' endpoint using any of the two methods**

- **Browser or REST client**
  <br/>```http://localhost:8080/goodbye```


- **cURL**
  <br/>```curl --request GET 'http://localhost:8080/goodbye'```


## How to Run Unit Test Cases

**Run the test cases using any of the commands mentioned below**

> **Note:** These commands need to run inside the root folder of this project i.e inside the **spring-boot-hello-world** folder

- **To run all the test cases**
  <br/>```mvn test```


- **To run a particular test class**
  <br/>```mvn -Dtest=HelloWorldControllerTest test```
  <br/>or
  <br/>```mvn -Dtest=HelloWorldApplicationTests test```

## How to create Jib image

**Create a Jib image using the command mentioned below**

> **Note:** This command needs to run inside the root folder of this project i.e inside the **spring-boot-hello-world** folder.

> **Note:** Make sure you have Docker hub account and you are logged in to your Docker hub account.

> **Note:** Update the image name in the **pom.xml** file.

> **Note:** If your project contains multiple classes with the `main` method, such as `com.example.helloworld.HelloWorldApplication` and `com.testing.HelloWorldApplication`, you should specify the `mainClass` in the `jib-maven-plugin` configuration in your `pom.xml` file. This helps Maven identify the correct class to run. 
 
Here is an example of how to do it:

```xml
<plugin>
    ...
      <container>
          <mainClass>com.example.helloworld.HelloWorldApplication</mainClass>
      </container>
    ...
</plugin>
```

- **To create a Jib image**
  <br/>```mvn compile jib:build```