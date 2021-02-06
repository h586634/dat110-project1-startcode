package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		Charset charset = Charset.forName("ISO-8859-1");
		
		byte[] srtByteArr = charset.encode(str).array();
		byte[] encoded = new byte[srtByteArr.length+1];
		encoded[0] = rpcid;
		
		System.arraycopy(encoded, 0, encoded, 1, srtByteArr.length);
		
		/* lapp sammen, utgangspunkt:
		System.arraycopy(firstArray, 0, result, 0, fal);
		System.arraycopy(secondArray, 0, result, fal, sal);
		*/

		return encoded;
	}

	public static String unmarshallString(byte[] data) {
		byte[] nyData = new byte[data.length-1];
		System.arraycopy(data, 1, nyData, 0, nyData.length);		

		return new String(nyData, Charset.forName("ISO-8859-1"));
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {
		/*
		if(data.length > 1) {
			//throw exception with stacktrace?
		}
		*/
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] intByteArr = ByteBuffer.allocate(4).putInt(x).array();
		byte[] encoded = new byte[5];
		
		System.arraycopy(intByteArr, 0, encoded, 1, 4);

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		byte[] nyData = new byte[data.length-1];
		System.arraycopy(data, 1, nyData, 0, nyData.length);	

		return ByteBuffer.wrap(nyData).getInt();

	}
}
