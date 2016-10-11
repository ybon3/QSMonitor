package com.dtc.test.qsm.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.user.client.Window.Location;

import us.dontcareabout.gwt.client.websocket.WebSocket;
import us.dontcareabout.gwt.client.websocket.event.MessageEvent;
import us.dontcareabout.gwt.client.websocket.event.MessageHandler;
import us.dontcareabout.gwt.client.websocket.event.OpenEvent;
import us.dontcareabout.gwt.client.websocket.event.OpenHandler;

public class WSClient {
	private final WebSocket ws;

	public WSClient() {
		ws = new WebSocket(
			GWT.getHostPageBaseURL().replace(Location.getProtocol(), "ws:") +
			//與下列設定有關：
			//* web.xml 的 springDispatcherServlet
			//* WebSocketServer.registerWebSocketHandler()
			"spring/websocket"
		);
		ws.addOpenHandler(new OpenHandler() {
			@Override
			public void onOpen(OpenEvent e) {
				GWT.log("WS open");
			}
		});
		ws.addMessageHandler(new MessageHandler() {
			@Override
			public void onMessage(MessageEvent e) {
				QSMEP.fireEvent(new RecordEvent(JsonUtils.<Record>safeEval(e.getMessage())));
			}
		});
	}

	public void open() {
		ws.open();
	}
}
