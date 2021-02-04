package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		// TODO: check for lenth within boundary
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
		//TODO
		// encapsulate/encode the payload of this message in the
		// encoded byte array according to message format
		byte[] encoded = null;
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		int length = payload.length;
		encoded[0] = (byte) length;
		
		for (int i = 0; i <= payload.length; i++) {
			encoded[i + 1] = payload[i];
		}
		return encoded;
	}

	public void decapsulate(byte[] received) {
		//TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message ggg
		int length = received[0];
		payload = new byte[length];
		
		for (int i = 0; i <= payload.length; i++) {
			payload[i] = received[i + 1];
		}
	}
}