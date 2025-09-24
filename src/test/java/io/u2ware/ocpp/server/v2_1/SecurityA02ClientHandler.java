package io.u2ware.ocpp.server.v2_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.handlers.CertificateSigned;
import io.u2ware.ocpp.v2_1.handlers.SignCertificate;
import io.u2ware.ocpp.v2_1.handlers.TriggerMessage;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommand;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationTransport;
import io.u2ware.ocpp.v2_1.model.CertificateSignedRequest;
import io.u2ware.ocpp.v2_1.model.CertificateSignedResponse;
import io.u2ware.ocpp.v2_1.model.SignCertificateRequest;
import io.u2ware.ocpp.v2_1.model.SignCertificateResponse;
import io.u2ware.ocpp.v2_1.model.TriggerMessageRequest;
import io.u2ware.ocpp.v2_1.model.TriggerMessageResponse;

public class SecurityA02ClientHandler  implements 
    TriggerMessage.ChargingStationHandler,
    SignCertificate.ChargingStationHandler, //-> 2.
    CertificateSigned.ChargingStationHandler //-> 2.
    {

    protected Log logger = LogFactory.getLog(getClass());

    protected ChargingStationTransport ocppTransport; //-> 4.

    public SecurityA02ClientHandler(ChargingStationTransport ocppTransport){
        this.ocppTransport = ocppTransport;
    }

    @Override
    public String usecase() {
        return "A02";
    }

    @Override
    public TriggerMessageResponse receivedTriggerMessageRequest(String id, TriggerMessageRequest req) {
        logger.info(String.format("\n\n\t TriggerMessage[2/4] receivedTriggerMessageRequest(%s)\n", id));
        return TriggerMessageResponse.builder().build();
    }

    @Override
    public void sendTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t TriggerMessage[4/4] sendTriggerMessageResponse(%s)\n", id));

        ChargingStationCommand command = 
            ChargingStationCommand.ALL.SignCertificate.buildWith(usecase());
        ocppTransport.offer(command, id); //-> 4        
    }


    @Override
    public SignCertificateRequest sendSignCertificateRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t SignCertificate[1/4] sendSignCertificateRequest(%s)\n", id));
        return SignCertificateRequest.builder().build();
    }


    @Override
    public void receivedSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t SignCertificate[3/4] receivedSignCertificateResponse(%s)\n", id));
    }


    @Override
    public CertificateSignedResponse receivedCertificateSignedRequest(String id, CertificateSignedRequest req) {
        logger.info(String.format("\n\n\t CertificateSigned[2/4] receivedCertificateSignedRequest(%s)\n", id));
        return CertificateSignedResponse.builder().build();
    }   

    @Override
    public void sendCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t CertificateSigned[4/4] sendCertificateSignedResponse(%s)\n", id));
    }
}
