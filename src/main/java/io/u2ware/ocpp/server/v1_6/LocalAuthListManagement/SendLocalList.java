package io.u2ware.ocpp.server.v1_6.LocalAuthListManagement;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.SendLocalList.ServerHandler;

@Component
public class SendLocalList implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public SendLocalListRequest sendSendLocalListRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendSendLocalListRequest, id));
        return SendLocalListRequest.builder().build();
    }

    @Override
    public void receivedSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedSendLocalListResponse, id));
    }
}
