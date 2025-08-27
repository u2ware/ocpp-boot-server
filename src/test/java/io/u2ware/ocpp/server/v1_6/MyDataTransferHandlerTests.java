package io.u2ware.ocpp.server.v1_6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;


@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired(required = false) CentralSystem server;
	protected @Autowired(required = false) CentralSystemCommandTemplate serverTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v1.6)CentralSystem               : "+server);
		logger.info("(v1.6)CentralSystemCommandTemplate: "+serverTemplate);
		if(server == null || serverTemplate == null) return;
		
		/////////////////////////////////////
		// OCPP Server Test without I/O
		/////////////////////////////////////
		ChargePointCommandTemplate mockClientTemplate = new ChargePointCommandTemplate("mockClientTemplate");
		MockWebSocketHandlerInvoker.of(ac).connect(serverTemplate, mockClientTemplate);
		Thread.sleep(1000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		serverTemplate.send(CentralSystemCommand.Core.DataTransfer.build());
		Thread.sleep(1000);
	}
}
