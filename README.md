# talking-clock
Talking clock application to show time in human friendly format
This project consists of three objectives that involve creating a command-line program with and without arguments and a REST service to convert numeric time to human-friendly text.

## Prequisites:
1. JDK-> 1.8
2. Maven-> 3.8.5
3. For windows, Install gitbash to run the script.
4. For mac/linux, run on default terminal


## Objective 1 and 2

### Human Friendly Time Command-line Program

- A command-line program that returns the current time using the "Human Friendly Text" format.
- Converts numeric time to human-friendly text.
- Supports an optional Numeric Time parameter for custom input.
- Written in Java 1.8.
- Includes a bash script for running the program.

#### Instructions to run the script for objective 1 and 2.

To run the program on Windows use Gitbash and for Mac/Linux use their default terminal.
1. Clone the project.
2. cd to objective1and2/.
3. For current time, run "./talking-clock.sh".
4. Sample: $ ./talking-clock.sh 
              Fourteen past Eleven
5. Example command for custom time, run "./talking-clock.sh 12:14".
6. Sample: $ ./talking-clock.sh 12:14
              Fourteen past Twelve

## Objective 3 

### Human Friendly Time REST Service
Implements a REST service to expose the clock functionality.
Accepts an optional Numeric Time parameter and returns "Human Friendly Text" as JSON.
Written in Java 1.8 and Spring Boot 2.5.5.
Includes unit tests for validation and conversion logic.

#### Instructions to run the REST service for objective3
1. Run the Spring Boot application using your preferred IDE like Intellij, Eclipse or STS.
2. To run the application through terminal run the command "mvn spring-boot:run".
3. To run the unit tests run the command "mvn clean install".
4. Once the application is up and running, open the brower and test the rest service using the below urls:
   a. http://localhost:8080/api/convert 
   Output: {"humanFriendlyText":"Twelve past Five"}
   b. http://localhost:8080/api/convert?time=12:35
   Output: {"humanFriendlyText":"Twenty five to One"}


#### Folder Structure
objective1and2/: Contains files related to Objective 1 and 2.
The objective1and2/talking-clock.sh is the bash script to run the command-line program.
objective3/: Contains files related to Objective 3.
objective3/src/main/java/: Source code files for the REST service.
objective3/src/test/java/: Unit tests for the REST service.
objective3/pom.xml: Maven configuration file for Objective 3.

## Contributions
Contributions to this project are welcome! Feel free to fork the repository and submit pull requests.
