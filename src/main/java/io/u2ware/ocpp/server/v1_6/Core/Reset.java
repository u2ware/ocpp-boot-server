package io.u2ware.ocpp.server.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.Reset.ServerHandler;

@Component
public class Reset implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public ResetRequest sendResetRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendResetRequest, id));
        return ResetRequest.builder().build();
    }

    @Override
    public void receivedResetResponse(String id, ResetResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedResetResponse, id));
    }
}
