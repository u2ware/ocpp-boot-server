package io.u2ware.ocpp.server.v1_6.FirmwareManagement;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.GetCompositeSchedule.ServerHandler;

@Component
public class GetCompositeSchedule implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public GetCompositeScheduleRequest sendGetCompositeScheduleRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendGetCompositeScheduleRequest, id));
        return GetCompositeScheduleRequest.builder().build();
    }

    @Override
    public void receivedGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res,
            ErrorCode err) {
        logger.info(comment(this, Comment.receivedGetCompositeScheduleResponse, id));
    }
}
