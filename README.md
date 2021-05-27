# Petstore - REST Microservice
A petstore microservice, exposing a REST API. Created as a recruitment exercise.
## Brief
We would like you to write a simple REST microservice. It can be kept simple but will need to support both the querying and capture of data, which is validated and persisted.

The point of this exercise is for you to showcase your programming skills / approach and as such you can use whatever operating system, data persistence, framework, build tool and IDE you are comfortable using. We only ask that it is relevant to a role with us so ideally it should be a Spring/Java based application and use technologies as mentioned in the job spec. Maybe you could use Docker to host a database and Hibernate to interact with the database? Maybe you could define your API as an OpenAPI specification with Swagger? Perhaps host it in AWS using RDS or DynamoDB?

If successful at this exercise, as part of your final interview you may be paired up with another engineer from SI and invited to lead an extension of this - ideally on your own laptop (let us know if this is not possible). This pair programming exercise will take place within a friendly and informal environment; it is not our intention to create a test or exam-like atmosphere and the scope will be deliberately kept simple. 

How much time you spend on the exercise in your own time is up to you but we would suggest under 2 hours unless you are particularly enjoying it!

Please send the completed exercise back either as a zip or a link to its location (e.g. on github/AWS). We would like to see it working so please include all assets needed and full instructions - including download urls of 3rd party software if necessary.

Good luck!

## Design
The petstore allows the capture of the following details about a pet:
| **Field** | **Validation** |
| ---- | --- |
| id | this is a UUID which will be generated when the pet is first added to the petstore. |
| name | Maximum of 50 characters |
| species | Only **DOG**, **CAT**, **RABBIT** and **SNAKE** can be added to the petstore. |
| breed | Maximum of 50 characters |
| weight | Specified in kg |
| cost | Specified in Pounds Sterling |

In addition, a pet must have a unique name for each species i.e. a snake and a dog can both be called Fido, but two dogs cannot be called Fido.

The id can be used by the basic service to query the details of a pet in the petstore.

## Usage
In order to run this application in a development environment the following applications will need to be installed:
* [Java 11](https://openjdk.java.net/install/) or above
* [Git 2.31.1](https://git-scm.com/downloads)
* [Maven 3.8.1](https://maven.apache.org/download.cgi)
* [Eclipse IDE 2021-03](https://www.eclipse.org/downloads/) (optional)

*Note*: The initial project was created using [Spring initializr](https://start.spring.io/).

Checkout this project, then run the command `mvn spring-boot:run` in a terminal at the root of this project.

The following URLs provide access to the microservice:

* [OpenAPI definition](http://localhost:8080/v3/api-docs/)
* [Swagger UI](http://localhost:8080/swagger-ui.html)

## Future Development Ideas
These ideas can be used to both enhance the service and to provide a higher quality service for use in a production environment.

* Allow searching of a pet by Species.
* Pagination of pets provided.
* Add integration tests using spring boot / web mvc.
* Improve Swagger UI documentation via annotations.
* Enable HTTPS.
* Caching of GET requests (either via the application or via API Gateway).
* Logging
* Create release artifact within github.

## Development Timeline
The following timeline provides a view into how this service was developed.

During the development of this service the [Pomodoro Technique](https://en.wikipedia.org/wiki/Pomodoro_Technique) was applied.

1. Create basic plan and research technologies for clarification on plan.
2. Ensure setup of of development environment and create spring app from start.spring.io. Import into eclipse.
3. Remove Spring Data JPA temporarily, Add Springdoc-openapi-ui and verify Spring Boot app starts up with swagger UI and openAPI integration.
4. Re-add Spring Data JPA, confirm correct use of Hibernate with minimal configuration, start implementation of REST API.
5. Finished implementation of REST API, run swagger API and manually tested API. 
6. Added error handling for controllers. Added validation for Pet.
7. Corrected validation for name and breed (using Size annotation instead of Max).
8. Added README.md, including tidying up design, instructions and usage.
9. Create Git Repo and push to Github. Create initial Dockerfile.

Total time: 8 pomodoros x 25 mins = 200 mins = 3.33 hours