# ocpp-boot-server
OCPP server implementation based on spring-boot

# Usage

```bash
./mvnw springboot:run
```

> http://localhost:8081


# @EnableOcppServer 

```java
@SpringBootApplication 
@EnableOcppServer(              //-> 1. 
    version = OCPPVersion.V1_6, //-> 2. 
	uri = "/yourocpp"           //-> 3. 
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
1. URI. ocpp clients can connect via URL.(ws://localhost:18080/yourocpp)

2. version. V1_6, V2_0_1, V2_1

3. '@EnableOcppServer' automatically registers the following beans:


    * v1.6

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [CentralSystem]()| An object that can offer and answer OCPP version 1.6 message.|
	|ocppTemplate | [CentralSystemCommandOperations]() | An object that can send a [CentralSystemCommand]().|
	|ocppInitializer | [CentralSystemInitializer]()| Scan for a [CentralSystemHandler]() that register it in [CentralSystem]().|


    * v2.0.1

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [CCMS]()| An object that can offer and answer OCPP version 2.0.1 message.|
	|ocppTemplate | [CCMSCommandOperations]()| An object that can send a [CCMSCommand]().|
	|ocppInitializer | [CCMSInitializer]()| Scan for a [CCMSHandler]() that register it in [CCMS]().|

    * v2.1

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [CCMS]()| An object that can offer and answer OCPP version 2.1 message.|
	|ocppTemplate | [CCMSCommandOperations]()| An object that can send a [CCMSCommand]().|
	|ocppInitializer | [CCMSInitializer]()| Scan for a [CCMSHandler]() that register it in [CCMS]().|



# Customize Handler  

If you want to customize a Handler, implement the corresponding server handler.

```java
import io.u2ware.ocpp.v1_6.exception.ErrorCodes; // 3.
import io.u2ware.ocpp.v1_6.handlers.DataTransfer.CentralSystemHandler; // 2.

@Component // 1.
public class DataTransfer implements CentralSystemHandler { // 2.

    @Override/** DataTransfer [1/4] */
    public DataTransferRequest sendDataTransferRequest(
        String id, Map<String, Object> req) {
        return DataTransferRequest.builder().build();
    }

    @Override/** DataTransfer [3/4] */
    public void receivedDataTransferResponse(
        String id, DataTransferResponse res, ErrorCode err) {
    }

    @Override/** DataTransfer [2/4] */
    public DataTransferResponse receivedDataTransferRequest(
        String id, DataTransferRequest req) {
        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("your error message"); // 3.
        }
        return DataTransferResponse.builder().build();
    }

    @Override/** DataTransfer [4/4] */
    public void sendDataTransferResponse(
        String id, DataTransferResponse res, ErrorCode err) {
    }
}
```

```java
import io.u2ware.ocpp.v1_6.handlers.RemoteStartTransaction; // 2.
import io.u2ware.ocpp.v1_6.handlers.UnlockConnector; // 2.
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandOperations; // 4.

@Component // 1.
public class MyCustomHandler implements 
    UnlockConnector.CentralSystemHandler, // 2.
    RemoteStartTransaction.CentralSystemHandler // 2.
    {  

    protected @Autowired CentralSystemCommandOperations operations; // 4.

    @Override
    public String[] features() {
        return new String[]{"MyCustomHandler"};
    }

    @Overridee/** MyCustomHandler [1/8] */
    public UnlockConnectorRequest sendUnlockConnectorRequest(
        String id, Map<String, Object> req) {
        return UnlockConnectorRequest.builder().build();
    }

    @Override/** MyCustomHandler [3/8] */
    public void receivedUnlockConnectorResponse(
        String id, UnlockConnectorResponse res, ErrorCode err) {
        CentralSystemCommand command = 
            CentralSystemCommand.Core.RemoteStartTransaction.buildWith("MyCustomHandler");
        operations.send(command); // 4.            
    }

    @Override/** MyCustomHandler [5/8] */
    public RemoteStartTransactionRequest sendRemoteStartTransactionRequest(
        String id, Map<String, Object> req) {
        return RemoteStartTransactionRequest.builder().build();        
    } 

    @Override/** MyCustomHandler [7/8] */
    public void receivedRemoteStartTransactionResponse(
        String id, RemoteStartTransactionResponse res, ErrorCode err) {   
    }
}
```
1. Declare @Component so that 'ocppInitializer' scans the beans.
2. Implement a Client Handler according to OCPP messages. 
3. <i>OCPP CALL ERROR</i> messages can be sent by throwing an error code. 
4. You can send other <i>OCPP CALL</i> messages using 'ocppTemplate'.

# Test without I/O (preparing)





# Test with I/O (preparing)






