
package acchamma.NetworkProgramming;
import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServer {
    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        InetAddress IPAddress = InetAddress.getByName("225.1.1.1");
        byte[] buffer = new byte[512];
        try
        (DatagramSocket serverSocket = new DatagramSocket()){
        for (int i=0;i<5;i++){
        String msg = "Sent message no "+i;
        buffer = msg.getBytes();
        DatagramPacket msgPacket = new DatagramPacket(buffer,buffer.length,IPAddress,12121);
        serverSocket.send(msgPacket);
            System.err.println("Server sent packet with msg:"+msg);
            Thread.sleep(500);
        
        }
        }
                
        
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
   