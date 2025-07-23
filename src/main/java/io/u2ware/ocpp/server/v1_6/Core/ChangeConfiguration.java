package io.u2ware.ocpp.server.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.ChangeConfiguration.ServerHandler;

@Component
public class ChangeConfiguration implements ServerHandler{

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public ChangeConfigurationRequest sendChangeConfigurationRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendChangeConfigurationRequest, id));
        return ChangeConfigurationRequest.builder().build();

    }

    @Override
    public void receivedChangeConfigurationResponse(String id, ChangeConfigurationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedChangeConfigurationResponse, id));

    } 

}
