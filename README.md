Talent Day - MyRetail RESTful Service
======================================================
The goal for this exercise was to create an end-to-end Proof-of-Concept for a products API, which would aggregate product data from multiple sources and return it as JSON to the caller.


Technologies Used
=================
* Java v1.8.0_181
* Spring Boot v2.0.4.RELEASE 
* Gradle v4.8.1
* Lombok v1.16.22
* Spock Core v1.1
* Feign v10.0.1
* MongoDB v4.0.1
* Docker v18.06.1-ce
* Git v2.14.3
* IntelliJ IDEA 2018.2.2 (Ultimate Edition)  

Setup
=================
**Start docker** in Terminal Window 1
1. `$ docker run --name mongoServer -p 27017:27017 -d mongo:latest`
1. `$ docker ps` 	=> To confirm docker container started  

**Access MongoDB** within the docker container
1. `$ docker exec -it mongoServer bash` 
1. `# mongo`  
1. `> use myRetail`  

**Download Project** in Terminal Window 2
1. `$ mkdir <workspace>` if no testing space exists 
1. `$ cd <workspace>`  
1. `$ git clone https://github.com/jenmmiddleton/talentdemo.git`  
1. `$ cd talentdemo`    
1. `$ ./gradlew clean build`

**Run the application** using only one of the following two commands:
* `$ ./gradlew bootRun`
* `$ java -jar ./build/libs/talentdemo-0.0.1-SNAPSHOT.jar`

NOTE: Anything over 80% EXECUTING means that it is currently running and waiting for input
 

Demonstration
=================
Demonstrate MongoDB as NoSQL database used
-----------------------
In Terminal Window 1
* `> db.price.find()`  => should be 6 records for demonstration purposes

Demonstrate GET Request
-----------------------
In a browser window, navigate to: [http://localhost:8080/products/13860428](http://localhost:8080/products/13860428) where it should display the following JSON structure:

```
{
	"id": 13860428
	"name": "The Big Lebowski [Blu-ray]"
	"current_price": {
		"value": 13.49
		"currency_code": "USD"
	}
}
```

