# VixDigitalApplication
VixDigitalApplication has been built using JAVA 8,Spring boot (4.3.2), microservices,Postgresql as the backend.

The application has 2 services 
1. HTTPPoller service 
2. VixService


   - HTTPPollerService polls the vix.digital after using a scheduled executor after every 10 minutes and fetches the response from the site.
   The service response parameters fetched - such as statusCode, message, responseTimeInMilliseconds is then persisted to the database table - service_info.
   
   In case the response code received is not 200 or if the response time in milliseconds exceeds 200 milliseconds , a warning message is logged in the console.
   
   - VixService
   REST API built which lets a user to add / update / delete a service.
   
    a. To fetch the details of a service - service name, description, id etc 
       GET request - localhost:6162/services
    b. Service can be added using a POST request to the URL - localhost:6162/services
    c. Service can be updated my making a PUT request to the URL- localhost:6162/services
    d. Service can be deleted by making a DELETE request to the URL - localhost:6162/services
    
    To change the port number (in case 8185 is already used on your machine, kindly change it in application.properties file)

Prerequisites :

JAVA (version 8 or above) should be installed on the system.
Maven should be installed
IDE (Eclipse / Intelli J) should be installed (in case api should be run using an IDE)
Installation TO install the project, follow the steps below - clone / download the git project using git clone and git checkout commands.

USING AN IDE

Import the three projects using any IDE (IntelliJ / eclipse).
Open the VixDigitalApplication.java and right click and run the class.
USING A JAR

The API can also be run using a jar
To run the api using jar - browse to the location where the project has been downloaded / cloned
Run the command mvn clean install , which would create the jar - poller-0.0.1-SNAPSHOT.jar under target folder 4 browse to target and run the command java -jar poller-0.0.1-SNAPSHOT.jar , which would start the application and can be tested using a browser
   
   
   


