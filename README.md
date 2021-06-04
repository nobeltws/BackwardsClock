# Backwards Clock

You have been awarded with a task to build a clock which goes back in time (in other words
tick backwards)

## Requirements
1. You’re application should accept 1 parameter from the user which is DECREMENT_BY_SECS
2. As current time increments by 1 second you’re required to decrement time by the number of seconds provided as a parameter.
3. Add necessary validations and handle exceptions.

## Assumptions
1. Application will prompt to ask for user input, DECREMENT_BY_SECS
2. Clock will continue to run until "Enter" key is pressed
3. After clock is stopped, it will once again prompt for user input, DECREMENT_BY_SECS

 
## Compile, Build and Execute Requirements

1. Maven 3.6.3 (For compile and build)
2. Java 11 (For running the jar) 

## Build
 
---sh
cd backwardsClock
mvn compile
mvn package
---

## Run Backwards Clock

---sh
cd backwardsClock/target
java -jar backwardsClock-0.0.1-SNAPSHOT.jar
---