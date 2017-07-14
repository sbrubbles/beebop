## Pre-requisites
Java 8 (preferrably JDK) and Maven 3 must be installed and the `bin` directory within their installation paths defined 
in the system's `PATH` variable. The variable `JAVA_HOME` must also be set with the Java installation directory. 

## Testing the application

### Building the project
Open a terminal window, go to the directory where the application is, and execute the following command:
```
mvn clean install
```

### Starting the embedded tomcat server
After building the project, execute the following command in the same directory:

```
mvn tomcat7:run
```

### Accessing the application

Open the link below in your web browser:

```
http://localhost:8080/beebop
```
