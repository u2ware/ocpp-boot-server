package io.u2ware.ocpp.server.v1_6;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.RemoteStartTransaction; // 2.
import io.u2ware.ocpp.v1_6.handlers.UnlockConnector; // 2.
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandOperations; // 4.
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionResponse;
import io.u2ware.ocpp.v1_6.model.UnlockConnectorRequest;
import io.u2ware.ocpp.v1_6.model.UnlockConnectorResponse;

@Component("MyCustomHandler_v1_6") // 1.
public class MyCustomHandler implements 
    UnlockConnector.CentralSystemHandler, // 2.
    RemoteStartTransaction.CentralSystemHandler // 2.
    {  

    protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired(required = false) CentralSystemCommandOperations operations; // 4.

    @Override
    public String usecase() {
        return "MyCustomHandler";
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
        logger.info(String.format("\n\n\t MyCustomHandler[3/8] receivedHeartbeatResponse(%s)\n", id));
        CentralSystemCommand command = 
            CentralSystemCommand.Core.RemoteStartTransaction.buildWith("MyCustomHandler");
        operations.send(id, command); // 4.            
    }

    @Override/** MyCustomHandler [5/8] */
    public RemoteStartTransactionRequest sendRemoteStartTransactionRequest(
        String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t MyCustomHandler[5/8] sendStartTransactionRequest(%s)\n", id));
        return RemoteStartTransactionRequest.builder().build();        
    } 

    @Override/** MyCustomHandler [7/8] */
    public void receivedRemoteStartTransactionResponse(
        String id, RemoteStartTransactionResponse res, ErrorCode err) {   
        logger.info(String.format("\n\n\t MyCustomHandler[7/8] receivedStartTransactionResponse(%s)\n", id));
    }
}
