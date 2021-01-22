# insurance
Test task. Design a data model for a simplistic insurance domain.

Minimal Spring Boot sample app.

Requirements
For building and running the application you need:

JDK 1.8
Maven 3
PostgreSQL 11

Running the application locally.
There are several ways to run a Spring Boot application on your local machine. 
One way is to execute the main method in the src/main/java/com/lizoon/insurance/InsuranceApplication.java class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

Also this application is deployed to heroku:
https://vehicleinsurance.herokuapp.com/  

Mappings:
Get:
http://localhost:8080/ - show all policies in json format

http://localhost:8080/{id} - show a certain policy by id

http://localhost:8080/xmlFormat - show all policies in xml format

Post:
http://localhost:8080/ - create new policy (required json body, for example 
{
    "policyNumber":123,
    "totalAmount":345,
    "effectiveDate":"2021-01-21",
    "expireDate":"2021-05-21"
})
Delete:
http://localhost:8080/{id} - delete a certain policy.
