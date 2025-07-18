# ocpp-boot-server
OCPP server implementation based on spring-boot


## Requriement

```xml
<dependency>
	<groupId>io.u2ware</groupId>
	<artifactId>ocpp-boot</artifactId>
	<version>0.9.9</version>
</dependency>
```
   
> [ocpp-boot](https://github.com/u2ware/ocpp-boot?tab=readme-ov-file#install) 
    

## Usage

```bash
./mvnw springboot:run
```

> http://localhost:8081


# @EnableOcppServer 

```java
@SpringBootApplication 
@EnableOcppServer(               //-> (1) 
    version = OCPPVersion.V1_6,  //-> (2) 
	uri = "/myocpp"              //-> (3) 
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
(1) Enable Ocpp Server annotation 

(1) version. V1_6, V2_0_1, V2_1

(2) URI. ocpp clients can connect via URL.(ws://localhost:18080/myocpp)


# OCPP Specification 

If you want to customize a Usecase, implement the corresponding server handler.

```java


```

# Test without I/O (preparing)



# Test with I/O (preparing)






