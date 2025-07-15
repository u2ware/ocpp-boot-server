package io.u2ware.ocpp.server.v1_6.InitiatedByCentralSystem;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.messaging.SpecificationOperations;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.DiagnosticsStatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.DiagnosticsStatusNotificationResponse;
import io.u2ware.ocpp.v1_6.model.GetDiagnosticsRequest;
import io.u2ware.ocpp.v1_6.model.GetDiagnosticsResponse;
import io.u2ware.ocpp.v1_6.usecase.GetDiagnostics.ServerHandler;


@Component
public class GetDiagnostics implements ServerHandler {
    
    protected Log logger = LogFactory.getLog(getClass());

    @Autowired
    protected SpecificationOperations ocppOperations;

    @Override
    public GetDiagnosticsRequest sendGetDiagnosticsRequest(String id, Map<String,Object> req) {
        logger.info(comment(this, Comment.sendGetDiagnosticsRequest, id));
        return new GetDiagnosticsRequest();
    }

    @Override
    public void receivedGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedGetDiagnosticsResponse, id));
    }

    @Override
    public DiagnosticsStatusNotificationResponse receivedDiagnosticsStatusNotificationRequest(String id, DiagnosticsStatusNotificationRequest req) {
        logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationRequest, id));
        return new DiagnosticsStatusNotificationResponse();
    }

    @Override
    public void sendDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationResponse, id));
    }

}