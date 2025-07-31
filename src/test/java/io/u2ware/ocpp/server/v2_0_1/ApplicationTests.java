package io.u2ware.ocpp.server.v2_0_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.config.WebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;
import io.u2ware.ocpp.v2_0_1.messaging.CSMS;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSCommandTemplate;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommandTemplate;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStation;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommand;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired CSMS server;
	protected @Autowired CSMSCommandTemplate serverTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.0.1)CSMS               : "+server);
		logger.info("(v2.0.1)CSMSCommandTemplate: "+serverTemplate);
			
	}
}
