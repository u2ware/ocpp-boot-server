package io.u2ware.ocpp.server.v2_0_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.config.WebSocketHandlerInvoker;
import io.u2ware.ocpp.v2_0_1.messaging.CSMS;
import io.u2ware.ocpp.v2_0_1.messaging.Specification;
import io.u2ware.ocpp.v2_0_1.messaging.SpecificationSendingTemplate;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStation;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OCPPApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired CSMS server;
	protected @Autowired SpecificationSendingTemplate serverTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("Mock Client...");			
		ChargingStation client = new ChargingStation();
		client.registerDefaultUsecases();
		SpecificationSendingTemplate clientTemplate = new SpecificationSendingTemplate(client);

		logger.info("WebSocketHandlerInvoker... (without I/O)");			
		WebSocketHandlerInvoker.of(ac).connect(serverTemplate, clientTemplate);
		Thread.sleep(2000);

		logger.info("Messaging Initiated By CSMS...");
		for(Specification s : Specification.usecases(server)) {
			serverTemplate.convertAndSend(s.message());
			Thread.sleep(500);
		}

		logger.info("Messaging Initiated By ChargingStation...");			
		for(Specification s : Specification.usecases(client)) {
			clientTemplate.convertAndSend(s.message());
			Thread.sleep(500);
		}	
	}
}
