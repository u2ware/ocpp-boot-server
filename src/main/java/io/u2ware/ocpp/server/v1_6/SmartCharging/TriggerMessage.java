package io.u2ware.ocpp.server.v1_6.SmartCharging;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.TriggerMessage.ServerHandler;

@Component
public class TriggerMessage implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public TriggerMessageRequest sendTriggerMessageRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendTriggerMessageRequest, id));
        return new TriggerMessageRequest();
    }

    @Override
    public void receivedTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedTriggerMessageResponse, id));
    }
}
