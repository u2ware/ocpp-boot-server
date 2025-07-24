package io.u2ware.ocpp.server.v1_6.SmartCharging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.StatusNotification.ServerHandler;

@Component
public class StatusNotification implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public StatusNotificationResponse receivedStatusNotificationRequest(String id,
            StatusNotificationRequest req) {
        logger.info(comment(this, Comment.receivedStatusNotificationRequest, id));
        return StatusNotificationResponse.builder().build();
    }

    @Override
    public void sendStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendStatusNotificationResponse, id));
    }
}
