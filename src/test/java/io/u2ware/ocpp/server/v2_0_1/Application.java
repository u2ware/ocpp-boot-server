package io.u2ware.ocpp.server.v2_0_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.u2ware.ocpp.config.EnableOcppServer;
import io.u2ware.ocpp.OCPPVersion;


@SpringBootApplication
@EnableOcppServer(version = OCPPVersion.V2_0_1, uri="/ocpp")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
