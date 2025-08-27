package io.u2ware.ocpp.server.v2_0_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v2_0_1.messaging.CSMS;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSCommandTemplate;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommandTemplate;

@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired(required = false) CSMS server;
	protected @Autowired(required = false) CSMSCommandTemplate serverTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.0.1)CSMS               : "+server);
		logger.info("(v2.0.1)CSMSCommandTemplate: "+serverTemplate);
		if(server == null || serverTemplate == null) return;
			
		/////////////////////////////////////
		// OCPP Server Test  without I/O
		/////////////////////////////////////
		ChargingStationCommandTemplate mockClientTemplate = new ChargingStationCommandTemplate("mockClientTemplate");
		MockWebSocketHandlerInvoker.of(ac).connect(serverTemplate, mockClientTemplate);
		Thread.sleep(1000);	

		/////////////////////////////////////
		// 
		/////////////////////////////////////
		serverTemplate.send(CSMSCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

	}
}
