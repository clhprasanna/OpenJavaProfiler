package com.myjavacode.profiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPServer
implements Runnable {
    public void run() 
    {
        ServerSocket welcomeSocket = null;
        try {
            welcomeSocket = new ServerSocket(6789);
            
            System.out.println("Starting TCP Server");
            
            String configLocation = System.getenv("OPENPROFILER_HOME");
            File file = new File(String.valueOf(configLocation) + "/perfmon.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            do {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                String clientSentence = inFromClient.readLine();
                
                System.out.println("From TCP Server : Client Sent -"+clientSentence);
                
                fileWriter = new FileWriter(file.getAbsoluteFile(), true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(String.valueOf(new Date().toString()) + " - ");
                bufferedWriter.write(clientSentence);
                bufferedWriter.newLine();
                bufferedWriter.close();
            } while (true);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            try {
                welcomeSocket.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }
}
