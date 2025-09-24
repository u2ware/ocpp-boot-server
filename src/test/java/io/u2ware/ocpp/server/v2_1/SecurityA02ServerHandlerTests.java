package io.u2ware.ocpp.server.v2_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker; //-> 2
import io.u2ware.ocpp.v2_1.messaging.ChargingStationTransport;
import io.u2ware.ocpp.v2_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_1.messaging.CSMSTransport;//-> 1

@SpringBootTest
class SecurityA02ServerHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) CSMSTransport ocppTransport;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.1)CSMSTransport: "+ocppTransport);
		if(ocppTransport == null) return;
			
        /////////////////////////////////////
        // Test without I/O
        /////////////////////////////////////
		ChargingStationTransport mockTransport 
			= new ChargingStationTransport("mockTransport", false); //-> 1
		mockTransport.session().registerHandler(new SecurityA02ClientHandler(mockTransport));

			
		MockWebSocketHandlerInvoker.of(ac)
			.connect(ocppTransport, mockTransport); //-> 2
		
		Thread.sleep(1000);	

		/////////////////////////////////////
		// 
		/////////////////////////////////////
		ocppTransport.offer(CSMSCommand.ALL.TriggerMessage.buildWith("A02"));
		Thread.sleep(1000);

	}
}
