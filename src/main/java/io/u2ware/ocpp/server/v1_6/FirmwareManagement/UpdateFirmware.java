package io.u2ware.ocpp.server.v1_6.FirmwareManagement;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.UpdateFirmware.ServerHandler;

@Component
public class UpdateFirmware implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public UpdateFirmwareRequest sendUpdateFirmwareRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendUpdateFirmwareRequest, id));
        return UpdateFirmwareRequest.builder().build();
    }

    @Override
    public void receivedUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedUpdateFirmwareResponse, id));
    }
}
