package io.u2ware.ocpp.server.v1_6.FirmwareManagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.FirmwareStatusNotification.ServerHandler;

@Component
public class FirmwareStatusNotification implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public FirmwareStatusNotificationResponse receivedFirmwareStatusNotificationRequest(String id,
            FirmwareStatusNotificationRequest req) {
        logger.info(comment(this, Comment.receivedFirmwareStatusNotificationRequest, id));
        return FirmwareStatusNotificationResponse.builder().build();
    }

    @Override
    public void sendFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res,
            ErrorCode err) {
        logger.info(comment(this, Comment.sendFirmwareStatusNotificationResponse, id));
    }
}
