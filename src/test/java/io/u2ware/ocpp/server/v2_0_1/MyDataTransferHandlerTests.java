package io.u2ware.ocpp.server.v2_0_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSTransport;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationTransport;

@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) CSMSTransport ocppTransport;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.0.1)CSMSTransport: "+ocppTransport);
		if(ocppTransport == null) return;
			
		/////////////////////////////////////
		// OCPP Server Test  without I/O
		/////////////////////////////////////
		ChargingStationTransport mockTransport = new ChargingStationTransport("mockTransport");
		MockWebSocketHandlerInvoker.of(ac).connect(ocppTransport, mockTransport);
		Thread.sleep(1000);	

		/////////////////////////////////////
		// 
		/////////////////////////////////////
		ocppTransport.offer(CSMSCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);

	}
}
