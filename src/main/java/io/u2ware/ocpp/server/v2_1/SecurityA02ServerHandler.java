package io.u2ware.ocpp.server.v2_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.handlers.CertificateSigned; //-> 2
import io.u2ware.ocpp.v2_1.handlers.SignCertificate; //-> 2
import io.u2ware.ocpp.v2_1.handlers.TriggerMessage; //-> 2
import io.u2ware.ocpp.v2_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_1.messaging.CSMSSession; //-> 4
import io.u2ware.ocpp.v2_1.model.CertificateSignedRequest;
import io.u2ware.ocpp.v2_1.model.CertificateSignedResponse;
import io.u2ware.ocpp.v2_1.model.SignCertificateRequest;
import io.u2ware.ocpp.v2_1.model.SignCertificateResponse;
import io.u2ware.ocpp.v2_1.model.TriggerMessageRequest;
import io.u2ware.ocpp.v2_1.model.TriggerMessageResponse;

@Component("SecurityA02Handler_v2_1") 
public class SecurityA02ServerHandler  implements 
    TriggerMessage.CSMSHandler, 
    SignCertificate.CSMSHandler, 
    CertificateSigned.CSMSHandler
    {

    protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired(required = false) CSMSSession ocppSession; //

    @Override
    public String usecase() {
        return "A02"; //
    }

    @Override/** TriggerMessage [1/4] */
    public TriggerMessageRequest sendTriggerMessageRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t TriggerMessage[1/4] sendTriggerMessageRequest(%s)\n", id));
        return TriggerMessageRequest.builder().build();
    }   


    @Override/** TriggerMessage [3/4] */
    public void receivedTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t TriggerMessage[3/4] receivedTriggerMessageResponse(%s)\n", id));
    }


    @Override/** SignCertificate [2/4] */
    public SignCertificateResponse receivedSignCertificateRequest(String id, SignCertificateRequest req) {
        logger.info(String.format("\n\n\t SignCertificate[2/4] receivedSignCertificateRequest(%s)\n", id));
        return SignCertificateResponse.builder().build();
    }

    @Override/** SignCertificate [4/4] */
    public void sendSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t SignCertificate[4/4] sendSignCertificateResponse(%s)\n", id));
        ///////////////////////////////////////////////////////////////
        // You can send other OCPP CALL messages using 'ocppTemplate'.
        ///////////////////////////////////////////////////////////////
        CSMSCommand command = 
            CSMSCommand.ALL.CertificateSigned.buildWith("A03");
        ocppSession.offer(command, id); //
    }

    @Override/** CertificateSigned [1/4] */
    public CertificateSignedRequest sendCertificateSignedRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t CertificateSigned[1/4] sendCertificateSignedRequest(%s)\n", id));
        return CertificateSignedRequest.builder().build();
    }  

    @Override/** CertificateSigned [3/4] */
    public void receivedCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t CertificateSigned[3/4] receivedCertificateSignedResponse(%s)\n", id));
    }
}
