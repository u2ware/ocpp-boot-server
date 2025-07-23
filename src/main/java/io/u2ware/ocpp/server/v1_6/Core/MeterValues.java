package io.u2ware.ocpp.server.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.MeterValues.ServerHandler;

@Component
public class MeterValues implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public MeterValuesResponse receivedMeterValuesRequest(String id, MeterValuesRequest req) {
        logger.info(comment(this, Comment.receivedMeterValuesRequest, id));
        return MeterValuesResponse.builder().build();
    }

    @Override
    public void sendMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendMeterValuesResponse, id));
    }
}
