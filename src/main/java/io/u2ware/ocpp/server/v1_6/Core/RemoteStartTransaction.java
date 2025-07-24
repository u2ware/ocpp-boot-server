package io.u2ware.ocpp.server.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.RemoteStartTransaction.ServerHandler;
import io.u2ware.ocpp.v1_6.messaging.SpecificationAction;

@Component // 1
public class RemoteStartTransaction implements ServerHandler { // 2

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public RemoteStartTransactionRequest sendRemoteStartTransactionRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendRemoteStartTransactionRequest, id));
        return RemoteStartTransactionRequest.builder().build();
    }

    @Override
    public void receivedRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res,
            ErrorCode err) {
        logger.info(comment(this, Comment.receivedRemoteStartTransactionResponse, id), err);

        if(! ObjectUtils.isEmpty(res)) {
            SpecificationAction action = Specification.InitiatedByChargePoint.DataTransfer.message();  // 4
            ocppOperations.convertAndSend(id, action);
        }

    }
}
