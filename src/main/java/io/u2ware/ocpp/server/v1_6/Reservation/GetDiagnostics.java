package io.u2ware.ocpp.server.v1_6.Reservation;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.GetDiagnostics.ServerHandler;

@Component
public class GetDiagnostics implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public GetDiagnosticsRequest sendGetDiagnosticsRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendGetDiagnosticsRequest, id));
        return GetDiagnosticsRequest.builder().build();
    }

    @Override
    public void receivedGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedGetDiagnosticsResponse, id));
    }

}