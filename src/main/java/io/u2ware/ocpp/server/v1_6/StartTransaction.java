package io.u2ware.ocpp.server.v1_6;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.exception.ErrorCodes; // 3.
import io.u2ware.ocpp.v1_6.handlers.StartTransaction.CentralSystemHandler; // 2.
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;

@Component // 1.
public class StartTransaction implements CentralSystemHandler { // 2.

    @Override/** StartTransaction [2/4] */
    public StartTransactionResponse receivedStartTransactionRequest(
        String id, StartTransactionRequest req) {
        
        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("your error message"); // 3.
        }
        return StartTransactionResponse.builder().build();
    }

    @Override/** StartTransaction [4/4] */
    public void sendStartTransactionResponse(
        String id, StartTransactionResponse res, ErrorCode err) {        
    }     
}
