package io.u2ware.ocpp.server.v1_6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemSession;
import io.u2ware.ocpp.v1_6.messaging.ChargePointSession;


@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) CentralSystemSession ocppSession;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v1.6)CentralSystemSession: "+ocppSession);
		if(ocppSession == null) return;
		
		/////////////////////////////////////
		// OCPP Server Test without I/O
		/////////////////////////////////////
		ChargePointSession mockSession = new ChargePointSession("mockSession");
		MockWebSocketHandlerInvoker.of(ac).connect(ocppSession, mockSession);
		Thread.sleep(1000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		ocppSession.offer(CentralSystemCommand.Core.DataTransfer.build());
		Thread.sleep(1000);
	}
}
