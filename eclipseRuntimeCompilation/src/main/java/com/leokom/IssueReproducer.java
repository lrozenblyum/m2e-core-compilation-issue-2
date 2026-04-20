package com.leokom;

import java.net.URI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class IssueReproducer {
	private static final Logger log = LogManager.getLogger(IssueReproducer.class);

	abstract class WSDesc extends WebSocketClient {
		WSDesc(URI serverUri) {
			super(serverUri);
		}

		@Override
		public void onOpen(ServerHandshake handshakedata) {
			// Eclipse: The type org.slf4j.Logger cannot be resolved. 
			// It is indirectly referenced from required type org.java_websocket.AbstractWebSocket
			
			// Workaround: use com.iqm.api.device.draeger.tas.IssueReproducer.log
			log.debug("Should be compiled");
		}
	}
}
