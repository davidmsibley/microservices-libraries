package gov.usgs.cida.microservices.api.messaging;

import java.util.Map;

public interface MessagingClient {
	
	/**
	 * 
	 * @param requestId
	 * @param serviceRequestId
	 * @param headers
	 * @param message
	 */
	public void sendMessage(String requestId, String serviceRequestId, Map<String, Object> headers, byte[] message);
}
