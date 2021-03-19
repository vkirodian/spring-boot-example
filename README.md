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

You can also provide dev or prod properties file running the application.

<i>Note: If you want to run prod profile, kindly refer HTTPS Support section first</i>

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

<b>GET/POST/PUT/DELETE API's</b>

For more details check following java class 

```java 
com.demo.springboot.controller.WebServiceController 
```

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

<b>File Upload/Download</b>

Upload API saves the uploaded file at /images directory

```bash
POST http://localhost:8081/file/upload
```
Download API would provide you with an image file from /images/imagefordownload.jpg

```bash
GET http://localhost:8081/file/download
```

<i>Note: The /images directory should be parallel to the applications jar file</i>


<b>Rest Template Example</b>

For more details refer following java class

```java
com.demo.springboot.controller.WebServiceConsumer
```
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

<b>ThymeLeaf Example</b>

For more details refer following java class

```java
com.demo.springboot.controller.ThymeLeafController class
```
Lists all the students in the system, gives you option to edit/delete any student.
You can also add new students.

```bash
GET http://localhost:8081/tl/index
```

Uses <b>AJAX</b> calls to access http://localhost:8081/student/students API.

This uses GET call.

```bash
http://localhost:8081/tl/view-students
```

This uses POST call.

```bash
http://localhost:8081/tl/add-students
```

<b>CORS</b>

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


<b>Internationalization</b>

Refer to InternationalizationConfig, LocalizationInterceptor, InterceptorConfig for required code.

```bash
http://localhost:8081/tl/locale
```

<b>Scheduling</b>

For more details refer following java class

```java
com.demo.springboot.scheduler.Scheduler class
```

<b>HTTPS Support</b>

By default the prod profile runs on HTTPS(port 443).
Before you can run in prod profile, generate self-signed certificate.

```bash
keytool -genkey -alias mycert -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650
```
The generated keystore.p12 file should be stored at /keystore directory parallel to the application jar file.

<b>Eureka Client</b>

This application acts as a client for Eureka server running on http://localhost:8761.

This application registers it self with Eureka server as spring-boot-example.

If you want to see this application get registered as a client, you need to run the Eureka Server as well.

Download from : https://github.com/vkirodian/microservices-eureka-demo


<b>Cloud Configuration Client</b>

This application acts as a client for configuration server running on

```bash
http://localhost:8888/spring-boot-example/default
```
To test this you need to download and run Cloud Configuration Server from https://github.com/vkirodian/microservices-config-server-demo.

The following API fetches the properties stored in GitHub. For more details refer README for microservices-config-server-demo.

```bash
http://localhost:8081/test/configServerProps
```

<b>Actuator Support</b>

Access actuator API at

```bash
http://localhost:8081/actuator/
```

<b>Cloud Administrator Client Support</b>

This application has exposed monitoring and management data via Actuator, these data can be accessed using Admin Client support.

Configurations has been added to look for Administrator Server at port 9090.

Download and run https://github.com/vkirodian/microservices-admin-server-demo.

You should be able to see all the monitoring and management data at

```bash
http://localhost:9090/
```
For more details refer ReadMe file at microservices-admin-server-demo project.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
NA
