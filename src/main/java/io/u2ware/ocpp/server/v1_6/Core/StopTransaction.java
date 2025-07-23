package io.u2ware.ocpp.server.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.StopTransaction.ServerHandler;

@Component
public class StopTransaction implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public StopTransactionResponse receivedStopTransactionRequest(String id, StopTransactionRequest req) {
        logger.info(comment(this, Comment.receivedStopTransactionRequest, id));
        return StopTransactionResponse.builder().build();
    }

    @Override
    public void sendStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendStopTransactionResponse, id));
    }
}
