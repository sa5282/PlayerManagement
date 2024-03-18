# PlayerManagement
Java/SpringBoot based application for managing sports & players that uses an in-memory H2 Database.
Upon startup, the application loads the data from the file `/src/main/resources/data.sql` into the H2 Database.
The data is not persistent, by design, and it is lost when the application shuts down, as this helps in starting over and running the tests again without any data modifications.

## Requirements
The following must be installed on the machine compiling and running this application
- Maven
- Java 11

## Maven Commands
On the command line:
- type `mvn compile` to compile the sources
- type `mvn test` to run the junit classes
- type `mvn package` to generate an executable jar file
- type `mvn sprint-boot:run` to run the application

## Postman Collection
A postman collection named `Postman Endpoints Collection.postman_collection.json` is available at the level in the repository.
Import and open this collection in Postman to call the REST API endpoints inside this application. Each endpoint name is prefixed with B-1, B-2, B-3, B-4, B-5 to help identify the correct endpoint easily.

