package no.hvl.dat110.messaging;


public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		// TODO: check for length within boundary
		if((payload.length >= MessageConfig.SEGMENTSIZE)) {
			payload = null;
		}
		this.payload = payload;
	}
	
	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {
		
		byte[] encoded;
		
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = (byte) payload.length;
		
		for(int i = 0; i < payload.length; i++) {
			encoded[i + 1] = payload[i];
		}
		return encoded;
	}

	public void decapsulate(byte[] received) {
		
		byte[] decoded = new byte[received[0]];
		
		for (int i = 0; i < decoded.length; i++) {
			decoded[i] = received[i + 1];

		}
		
		payload = decoded;
	}
}