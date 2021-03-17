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



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
NA
