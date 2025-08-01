package io.u2ware.ocpp.server.v2_0_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.handlers.RequestStartTransaction; // 2.
import io.u2ware.ocpp.v2_0_1.handlers.UnlockConnector; // 2.
import io.u2ware.ocpp.v2_0_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSCommandOperations; // 4.
import io.u2ware.ocpp.v2_0_1.model.RequestStartTransactionRequest;
import io.u2ware.ocpp.v2_0_1.model.RequestStartTransactionResponse;
import io.u2ware.ocpp.v2_0_1.model.UnlockConnectorRequest;
import io.u2ware.ocpp.v2_0_1.model.UnlockConnectorResponse;

@Component("MyCustomHandler_v2_0_1") // 1.
public class MyCustomHandler implements 
    UnlockConnector.CSMSHandler, // 2.
    RequestStartTransaction.CSMSHandler // 2.
    {  

    protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired(required = false) CSMSCommandOperations operations; // 4.

    @Override
    public String[] features() {
        return new String[]{"MyCustomHandler"};
    }

    @Override/** MyCustomHandler [1/8] */
    public UnlockConnectorRequest sendUnlockConnectorRequest(
        String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t MyCustomHandler[1/8] sendUnlockConnectorRequest(%s)\n", id));
        return UnlockConnectorRequest.builder().build();
    }

    @Override/** MyCustomHandler [3/8] */
    public void receivedUnlockConnectorResponse(
        String id, UnlockConnectorResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t MyCustomHandler[3/8] receivedUnlockConnectorResponse(%s)\n", id));
        CSMSCommand command = 
            CSMSCommand.ALL.RequestStartTransaction.buildWith("MyCustomHandler");
        operations.send(command); // 4.            
    }

    @Override/** MyCustomHandler [5/8] */
    public RequestStartTransactionRequest sendRequestStartTransactionRequest(
        String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t MyCustomHandler[5/8] sendRequestStartTransactionRequest(%s)\n", id));
        return RequestStartTransactionRequest.builder().build();        
    } 

    @Override/** MyCustomHandler [7/8] */
    public void receivedRequestStartTransactionResponse(
        String id, RequestStartTransactionResponse res, ErrorCode err) {   
        logger.info(String.format("\n\n\t MyCustomHandler[7/8] receivedRequestStartTransactionResponse(%s)\n", id));
    }
}
