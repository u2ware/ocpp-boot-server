# ocpp-boot-server
OCPP server implementation based on spring-boot


# Requriement

```xml
<dependency>
	<groupId>io.u2ware</groupId>
	<artifactId>ocpp-boot</artifactId>
	<version>0.9.9</version>
</dependency>
```
   
> [ocpp-boot](https://github.com/u2ware/ocpp-boot?tab=readme-ov-file#install) 
    

# Usage

```bash
./mvnw springboot:run
```

> http://localhost:8081


# @EnableOcppServer 

```java
@SpringBootApplication 
@EnableOcppServer(               //-> (1) 
    version = OCPPVersion.V1_6,  //-> (2) 
	uri = "/yourocpp"              //-> (3) 
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
1. '@EnableOcppServer' automatically registers the following beans:

	|beanName|Description|
	|------|:---|
	|ocppOperations|[SpecificationOperations]() object that matches the version.|
	|ocppTemplate|[SpecificationSendingOperations]() object that matches the version.|
	|ocppInitializer|Scan for a Handler that matches the version and register it in [SpecificationOperations]().|

2. version. V1_6, V2_0_1, V2_1

(3) URI. ocpp clients can connect via URL.(ws://localhost:18080/yourocpp)



# Customize Usecase  

If you want to customize a Usecase, implement the corresponding server handler.

```java
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.exception.ErrorCodes;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationAction;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;

import io.u2ware.ocpp.v1_6.usecase.StartTransaction.ServerHandler; 

@Component // 1
public class StartTransaction implements ServerHandler { // 2 

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public StartTransactionResponse receivedStartTransactionRequest(String id, StartTransactionRequest req) {
        logger.info(comment(this, Comment.receivedStartTransactionRequest, id));

        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("your error message"); // 3
        }
        return StartTransactionResponse.builder().build();
    }

    @Override
    public void sendStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendStartTransactionResponse, id), err);
    }
}
```

```java
@Component // 1
public class RemoteStartTransaction implements ServerHandler { // 2
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public RemoteStartTransactionRequest sendRemoteStartTransactionRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendRemoteStartTransactionRequest, id));
        return RemoteStartTransactionRequest.builder().build();
    }

    @Override
    public void receivedRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res,
            ErrorCode err) {
        logger.info(comment(this, Comment.receivedRemoteStartTransactionResponse, id));

        if(! ObjectUtils.isEmpty(res)) {
            SpecificationAction action = Specification.InitiatedByChargePoint.DataTransfer.message();  // 4
            ocppOperations.convertAndSend(id, action);
        }

    }
}
```
1. Declare @Component so that 'ocppInitializer' scans the beans.
2. Implement a Client Handler according to OCPP messages. 
3. OCPP CALL-ERROR messages can be sent by throwing an error code. 
4. You can send other OCPP CALL messages using [SpecificationSendingOperations]().

# Test without I/O (preparing)





# Test with I/O (preparing)






