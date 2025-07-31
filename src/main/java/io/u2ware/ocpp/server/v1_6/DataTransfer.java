package io.u2ware.ocpp.server.v1_6;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.exception.ErrorCodes; // 3.
import io.u2ware.ocpp.v1_6.handlers.DataTransfer.CentralSystemHandler; // 2.
import io.u2ware.ocpp.v1_6.model.DataTransferRequest;
import io.u2ware.ocpp.v1_6.model.DataTransferResponse;

@Component // 1.
public class DataTransfer implements CentralSystemHandler { // 2.

    protected Log logger = LogFactory.getLog(getClass());

    @Override/** DataTransfer [1/4] */
    public DataTransferRequest sendDataTransferRequest(
        String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t DataTransfer[1/4] sendDataTransferRequest(%s)\n", id));
        return DataTransferRequest.builder().build();
    }

    @Override/** DataTransfer [3/4] */
    public void receivedDataTransferResponse(
        String id, DataTransferResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t DataTransfer[3/4] receivedDataTransferResponse(%s)\n", id));
    }

    @Override/** DataTransfer [2/4] */
    public DataTransferResponse receivedDataTransferRequest(
        String id, DataTransferRequest req) {
        logger.info(String.format("\n\n\t DataTransfer[2/4] receivedDataTransferRequest(%s)\n", id));
        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("your error message"); // 3.
        }
        return DataTransferResponse.builder().build();
    }

    @Override/** DataTransfer [4/4] */
    public void sendDataTransferResponse(
        String id, DataTransferResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t DataTransfer[4/4] sendDataTransferResponse(%s)\n", id));
    }
}
