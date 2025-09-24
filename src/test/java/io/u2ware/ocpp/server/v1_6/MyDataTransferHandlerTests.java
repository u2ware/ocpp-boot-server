package io.u2ware.ocpp.server.v1_6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointTransport;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemTransport;


@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) CentralSystemTransport ocppTransport;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v1.6)CentralSystemTransport: "+ocppTransport);
		if(ocppTransport == null) return;
		
		/////////////////////////////////////
		// OCPP Server Test without I/O
		/////////////////////////////////////
		ChargePointTransport mockTransport = new ChargePointTransport("mockTransport");
		MockWebSocketHandlerInvoker.of(ac).connect(ocppTransport, mockTransport);
		Thread.sleep(1000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		ocppTransport.offer(CentralSystemCommand.Core.DataTransfer.build());
		Thread.sleep(1000);
	}
}
