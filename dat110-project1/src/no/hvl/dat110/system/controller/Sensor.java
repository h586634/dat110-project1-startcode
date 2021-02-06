package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	/**
	 * Pings sensonr for a Integer read with a marshalled void request.
	 * 
	 * Reads and marshals an Integer response.
	 * 
	 * @return Integer from response.
	 */
	public int read() {
		
		byte[] request = RPCUtils.marshallVoid(RPCID);
		byte[] response = rpcclient.call(request);
				
		return RPCUtils.unmarshallInteger(response);
	}
	
}
