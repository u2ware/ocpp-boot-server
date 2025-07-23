package io.u2ware.ocpp.server.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.DataTransfer.ServerHandler;

@Component
public class DataTransfer implements ServerHandler{

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public DataTransferRequest sendDataTransferRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendDataTransferRequest, id));
        return DataTransferRequest.builder().build();
    }

    @Override
    public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedDataTransferResponse, id));
    }       
    
    @Override
    public DataTransferResponse receivedDataTransferRequest(String id, DataTransferRequest req) {
        logger.info(comment(this, Comment.receivedDataTransferRequest, id));
        return DataTransferResponse.builder().build();
    }

    @Override
    public void sendDataTransferResponse(String id, DataTransferResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendDataTransferResponse, id));
    }    
}
