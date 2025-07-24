package io.u2ware.ocpp.server.v2_0_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_0_1.exception.*;
import io.u2ware.ocpp.v2_0_1.model.*;
import io.u2ware.ocpp.v2_0_1.usecase.A03.ServerHandler;

@Component
public class A03 implements ServerHandler{
    
    protected Log logger = LogFactory.getLog(getClass());

    @Override
    public SignCertificateResponse receivedSignCertificateRequest(String id, SignCertificateRequest req) {
        logger.info(comment(this, Comment.receivedSignCertificateRequest, id));
        return new SignCertificateResponse();
    }

    @Override
    public void sendSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendSignCertificateResponse, id));
    }

    @Override
    public CertificateSignedRequest sendCertificateSignedRequest(String id, Map<String,Object> req) {
        logger.info(comment(this, Comment.sendCertificateSignedRequest, id));
        return new CertificateSignedRequest();
    }

    @Override
    public void receivedCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedCertificateSignedResponse, id));
    }    
}
