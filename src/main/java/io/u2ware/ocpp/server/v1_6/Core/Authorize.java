package io.u2ware.ocpp.server.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.Authorize.ServerHandler;

@Component
public class Authorize implements ServerHandler{
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public AuthorizeResponse receivedAuthorizeRequest(String id, AuthorizeRequest req) {
        logger.info(comment(this, Comment.receivedAuthorizeRequest, id));
        return AuthorizeResponse.builder().build();
    }

    @Override
    public void sendAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendAuthorizeResponse, id));
    }
}