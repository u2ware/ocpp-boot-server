package io.u2ware.ocpp.server.v2_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker; //-> 2
import io.u2ware.ocpp.v2_1.messaging.CSMS;
import io.u2ware.ocpp.v2_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_1.messaging.CSMSCommandTemplate;
import io.u2ware.ocpp.v2_1.messaging.ChargingStation;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommandTemplate; //-> 1

@SpringBootTest
class SecurityA02ServerHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired(required = false) CSMS server;
	protected @Autowired(required = false) CSMSCommandTemplate serverTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.1)CSMS               : "+server);
		logger.info("(v2.1)CSMSCommandTemplate: "+serverTemplate);
		if(server == null || serverTemplate == null) return;
			
        /////////////////////////////////////
        // Test without I/O
        /////////////////////////////////////
		ChargingStation mockClient = new ChargingStation();
		ChargingStationCommandTemplate mockClientTemplate 
			= new ChargingStationCommandTemplate("mockClientTemplate", mockClient); //-> 1
		mockClient.registerHandler(new SecurityA02ClientHandler(mockClientTemplate));

			
		MockWebSocketHandlerInvoker.of(ac)
			.connect(serverTemplate, mockClientTemplate); //-> 2
		
		Thread.sleep(1000);	

		/////////////////////////////////////
		// 
		/////////////////////////////////////
		serverTemplate.send(CSMSCommand.ALL.TriggerMessage.buildWith("A02"));
		Thread.sleep(1000);

	}
}
