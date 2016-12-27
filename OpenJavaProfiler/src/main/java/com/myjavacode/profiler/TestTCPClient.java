package com.myjavacode.profiler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TestTCPClient {

	public static void main(String[] args) throws IOException {
		
		
		
	            Socket socket = new Socket("localhost", 6789);
	            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
	            dataOutputStream.writeBytes("Testing client");
	            socket.close();
	    
		

	}
	
	

}
