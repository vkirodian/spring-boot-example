# Spring Boot Example

This project uses all possible features of Spring Boot.

## Installation

Once you have checked out this repository, go to the base directory and build it using maven

```bash
maven clean install
```

## Running the application

Once the project is successfully built, you can run the following command:

```bash
java -jar .\target\spring-boot-example-1.jar
```
The application runs on port 8081.
http://localhost:8081/test/

You can also provide dev or prod properties file runnning the application.

```bash
java -jar .\target\spring-boot-example-1.jar --spring.profiles.active=dev
```

Logs are generated at logs/springbootapp.log

You would need to set authtoken header = 12345678 before hitting any API, alternatively you can comment the code in AuthInterceptor class.

## Spring Boot Features Used

You can check logging using

```bash
http://localhost:8081/test/testLogging
```
GET/POST/PUT/DELETE API's : com.demo.springboot.controller.WebServiceController class

```bash
GET http://localhost:8081/student/students
```
```bash
GET http://localhost:8081/student/students/byId?id=2
```
```bash
PUT http://localhost:8081/student/students/1
body
{
	"id": "1",
	"name": "Johnny Doey"
}
```
```bash
POST http://localhost:8081/student/students
body
{
	"id": "3",
	"name": "Bobby P"
}
```
```bash
DELETE http://localhost:8081/student/students/3
```
File Upload/Download

Upload API saves the uploaded file at /images directory

```bash
POST http://localhost:8081/file/upload
```
Download API would provide you with an image file from /images/imagefordownload.jpg

```bash
GET http://localhost:8081/file/download
```
Rest Template Example : com.demo.springboot.controller.WebServiceConsumer class
Consumes the above defines student/* API's

```bash
GET http://localhost:8081/cons/students
```
```bash
POST http://localhost:8081/cons/students
```
```bash
PUT http://localhost:8081/cons/students
```
```bash
DELETE http://localhost:8081/cons/students
```

ThymeLeaf Example : com.demo.springboot.controller.ThymeLeafController class

Lists all the students in the system, gives you option to edit/delete any student.
You can also add new students.

```bash
GET http://localhost:8081/tl/index
```

Uses AJAX calls to access http://localhost:8081/student/students API.
This uses GET call.

```bash
http://localhost:8081/tl/view-students
```
This uses POSt call.

```bash
http://localhost:8081/tl/add-students
```
If you want to test <b>CORS</b> implementation than run two instances of this application.
One without any profile(running on port 8081)
Another with DEV profile(running on port 8082)

DEV profile instance should be able to server http://localhost:8081/tl/view-students jus fine.
But if you comment in com.demo.springboot.configuration.RestConfig class
You should get CORS error in browser console.

```java
@Bean
public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/student/**").allowedOrigins("http://localhost:8082");
		}
	};
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
NA
