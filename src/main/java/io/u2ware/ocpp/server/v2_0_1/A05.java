package io.u2ware.ocpp.server.v2_0_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_0_1.exception.*;
import io.u2ware.ocpp.v2_0_1.model.*;
import io.u2ware.ocpp.v2_0_1.usecase.A05.ServerHandler;

@Component
public class A05 implements ServerHandler{
    
    protected Log logger = LogFactory.getLog(getClass());

    @Override
    public SetVariablesRequest sendSetVariablesRequest(String id, Map<String,Object> req) {
        logger.info(comment(this, Comment.sendSetVariablesRequest, id));
        return new SetVariablesRequest();
    }

    @Override
    public void receivedSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedSetVariablesResponse, id));
    }

    @Override
    public ResetRequest sendResetRequest(String id, Map<String,Object> req) {
        logger.info(comment(this, Comment.sendResetRequest, id));
        return new ResetRequest();
    }

    @Override
    public void receivedResetResponse(String id, ResetResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedResetResponse, id));
    }

    @Override
    public BootNotificationResponse receivedBootNotificationRequest(String id, BootNotificationRequest req) {
        logger.info(comment(this, Comment.receivedBootNotificationRequest, id));
        return new BootNotificationResponse();
    }

    @Override
    public void sendBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendBootNotificationResponse, id));
    }
}
