package io.u2ware.ocpp.server.v1_6.Reservation;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.SetChargingProfile.ServerHandler;

@Component
public class SetChargingProfile implements ServerHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public SetChargingProfileRequest sendSetChargingProfileRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendSetChargingProfileRequest, id));
        return new SetChargingProfileRequest();
    }

    @Override
    public void receivedSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedSetChargingProfileResponse, id));
    }
}
