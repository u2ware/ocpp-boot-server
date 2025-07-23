package io.u2ware.ocpp.server.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.exception.ErrorCodes;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationAction;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.StartTransaction.ServerHandler;

@Component
public class StartTransaction implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public StartTransactionResponse receivedStartTransactionRequest(String id, StartTransactionRequest req) {
        logger.info(comment(this, Comment.receivedStartTransactionRequest, id));

        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("my error message");
        }
        return StartTransactionResponse.builder().build();
    }

    @Override
    public void sendStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendStartTransactionResponse, id), err);
    }
}
