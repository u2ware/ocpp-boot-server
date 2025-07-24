package io.u2ware.ocpp.server.v2_0_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_0_1.exception.*;
import io.u2ware.ocpp.v2_0_1.model.*;
import io.u2ware.ocpp.v2_0_1.usecase.A04.ServerHandler;

@Component
public class A04 implements ServerHandler{
    
    protected Log logger = LogFactory.getLog(getClass());

    @Override
    public SecurityEventNotificationResponse receivedSecurityEventNotificationRequest(String id, SecurityEventNotificationRequest req) {
        logger.info(comment(this, Comment.receivedSecurityEventNotificationRequest, id));
        return new SecurityEventNotificationResponse();
    }
    @Override
    public void sendSecurityEventNotificationResponse(String id, SecurityEventNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendSecurityEventNotificationResponse, id));
    }
}
