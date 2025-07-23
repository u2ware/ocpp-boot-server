package io.u2ware.ocpp.server.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.GetConfiguration.ServerHandler;

@Component
public class GetConfiguration implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public GetConfigurationRequest sendGetConfigurationRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendGetConfigurationRequest, id));
        return GetConfigurationRequest.builder().build();
    }

    @Override
    public void receivedGetConfigurationResponse(String id, GetConfigurationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedGetConfigurationResponse, id));
    }
}
