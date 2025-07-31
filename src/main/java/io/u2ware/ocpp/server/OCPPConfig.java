package io.u2ware.ocpp.server;

import org.springframework.context.annotation.Configuration;

import io.u2ware.ocpp.config.EnableOcppServer;
import io.u2ware.ocpp.OCPPVersion;

@Configuration
@EnableOcppServer(version = OCPPVersion.V1_6, uri="/ocpp")
public class OCPPConfig {
    
}
