package io.u2ware.ocpp.server.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.Heartbeat.ServerHandler;

@Component
public class Heartbeat implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public HeartbeatResponse receivedHeartbeatRequest(String id, HeartbeatRequest req) {
        logger.info(comment(this, Comment.receivedHeartbeatRequest, id));
        return HeartbeatResponse.builder().build();
    }

    @Override
    public void sendHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendHeartbeatResponse, id));
    }
}
