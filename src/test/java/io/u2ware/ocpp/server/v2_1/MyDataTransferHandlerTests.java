package io.u2ware.ocpp.server.v2_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker; //-> 2
import io.u2ware.ocpp.v2_1.messaging.ChargingStationSession; //-> 1
import io.u2ware.ocpp.v2_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_1.messaging.CSMSSession; 

@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) CSMSSession ocppSession;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.1)CSMSSession: "+ocppSession);
		if(ocppSession == null) return;
			
        /////////////////////////////////////
        // Mock Object
        /////////////////////////////////////
		ChargingStationSession mockSession 
			= new ChargingStationSession("mockSession"); //-> 1
		
		MockWebSocketHandlerInvoker.of(ac)
			.connect(ocppSession, mockSession); //-> 2
		
		Thread.sleep(1000);	

		/////////////////////////////////////
		// Test without I/O
		/////////////////////////////////////
        CSMSCommand command 
            = CSMSCommand.ALL.DataTransfer.build();
        ocppSession.offer(command); //-> 3

        Thread.sleep(1000);
	}
}
