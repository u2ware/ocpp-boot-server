package io.u2ware.ocpp.server.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.BootNotification.ServerHandler;

@Component
public class BootNotification implements ServerHandler{

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public BootNotificationResponse receivedBootNotificationRequest(String id, BootNotificationRequest req) {
        logger.info(comment(this, Comment.receivedBootNotificationRequest, id));
        return BootNotificationResponse.builder().build();
    }

    @Override
    public void sendBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendBootNotificationResponse, id));
    } 
        
}
