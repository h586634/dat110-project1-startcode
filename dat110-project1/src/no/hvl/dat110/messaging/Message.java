package no.hvl.dat110.messaging;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {

		if ((payload.length >= MessageConfig.SEGMENTSIZE)) {
			throw new IllegalArgumentException("Payload is bigger than " + (MessageConfig.SEGMENTSIZE-1) + "B");
		} else {
			this.payload = payload;
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	/**
	 * Encapsulates the message.
	 * @return byte array
	 */
	public byte[] encapsulate() {

		byte[] encoded = new byte[MessageConfig.SEGMENTSIZE];

		encoded[0] = (byte) payload.length;

		for (int i = 0; i < payload.length; i++) {
			encoded[i + 1] = payload[i];
		}
		return encoded;
	}

	/**
	 * Decapsulates incoming message
	 * @param received
	 */
	public void decapsulate(byte[] received) {

		byte[] decoded = new byte[received[0]];

		for (int i = 0; i < decoded.length; i++) {
			decoded[i] = received[i + 1];

		}

		payload = decoded;
	}
}