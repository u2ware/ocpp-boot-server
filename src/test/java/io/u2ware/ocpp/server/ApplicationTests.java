package io.u2ware.ocpp.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.web.socket.WebSocketHandler;

import io.u2ware.ocpp.config.WebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationAction;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());


	protected @Autowired ApplicationContext ac;

	protected @Autowired CentralSystem server;
	protected @Autowired SpecificationSendingTemplate serverTemplate;

	@Test
	void context1Loads() throws Exception {


		ChargePoint client = new ChargePoint();
		client.registerDefaultUsecases();
		SpecificationSendingTemplate clientTemplate = new SpecificationSendingTemplate(client);

		logger.info("===================");			
		WebSocketHandlerInvoker.of(ac).connect(serverTemplate, clientTemplate);
		Thread.sleep(2000);


		logger.info("2===================");			

		// SpecificationAction a1 = Specification.InitiatedByCentralSystem.DataTransfer.message();
		// serverTemplate.convertAndSend(a1);
		// Thread.sleep(1000);


		// SpecificationAction a2 = Specification.Core.DataTransfer.message();
		// serverTemplate.convertAndSend(a2);
		// Thread.sleep(1000);


		logger.info(Specification.Core.DataTransfer.category());
		logger.info(Specification.InitiatedByCentralSystem.DataTransfer.category());


		// for(Specification s : Specification.usecases(server)) {
		// 	serverTemplate.convertAndSend(s.message());
		// 	Thread.sleep(500);
		// }

		// logger.info("3===================");			
		// for(Specification s : Specification.usecases(client)) {
		// 	clientTemplate.convertAndSend(s.message());
		// 	Thread.sleep(500);
		// }		

	}
}
