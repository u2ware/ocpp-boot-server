package io.u2ware.ocpp.server.v1_6;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.Heartbeat; // 2.
import io.u2ware.ocpp.v1_6.handlers.RemoteStartTransaction; // 2.
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandOperations; // 4.
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionResponse;


@Component // 1.
public class MyCustomHandler implements 
    RemoteStartTransaction.CentralSystemHandler, // 2.
    Heartbeat.CentralSystemHandler {  // 2.

    protected @Autowired CentralSystemCommandOperations operations; // 4.

    @Override
    public String[] features() {
        return new String[]{"MyCustomHandler"};
    }

    @Override/** MyCustomHandler [2/8] */
    public HeartbeatResponse receivedHeartbeatRequest(
        String id, HeartbeatRequest req) {
        return HeartbeatResponse.builder().build();
    }

    @Override/** MyCustomHandler [4/8] */
    public void sendHeartbeatResponse(
        String id, HeartbeatResponse res, ErrorCode err) {        
        
        CentralSystemCommand command = 
            CentralSystemCommand.ALL.RemoteStartTransaction.buildWith("MyCustomHandler");

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
