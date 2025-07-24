package io.u2ware.ocpp.server.v2_0_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_0_1.exception.*;
import io.u2ware.ocpp.v2_0_1.model.*;
import io.u2ware.ocpp.v2_0_1.usecase.A01.ServerHandler;

@Component
public class A01 implements ServerHandler{

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
}
