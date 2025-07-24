package io.u2ware.ocpp.server.v2_0_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.u2ware.ocpp.config.EnableOcppServer;
import io.u2ware.ocpp.core.OCPPVersion;


@SpringBootApplication
@EnableOcppServer(version = OCPPVersion.V2_0_1, uri="/ocpp")
public class OCPPApplication {

	public static void main(String[] args) {
		SpringApplication.run(OCPPApplication.class, args);
	}

}
