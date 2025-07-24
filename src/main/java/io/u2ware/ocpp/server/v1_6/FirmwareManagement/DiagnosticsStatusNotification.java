package io.u2ware.ocpp.server.v1_6.FirmwareManagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.DiagnosticsStatusNotification.ServerHandler;

@Component
public class DiagnosticsStatusNotification implements ServerHandler{
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public DiagnosticsStatusNotificationResponse receivedDiagnosticsStatusNotificationRequest(String id,
            DiagnosticsStatusNotificationRequest req) {
        logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationRequest, id));
        return DiagnosticsStatusNotificationResponse.builder().build();
    }

    @Override
    public void sendDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res,
            ErrorCode err) {
        logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationResponse, id));
    }
}
