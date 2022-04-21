
package acchamma.NetworkProgramming;
import java.net.*;
import java.io.*;

public class MulticastClient {
    public static void main(String[] args)throws UnknownHostException {
        InetAddress address = InetAddress.getByName("225.1.1.1");
        byte[] buffer = new byte[512];
        try
        (MulticastSocket clientSocket = new MulticastSocket(12121)){
            clientSocket.joinGroup(address);
            while(true){
            DatagramPacket mcPacket = new DatagramPacket(buffer,buffer.length);
            clientSocket.receive(mcPacket);
            String msg = new String(mcPacket.getData());
                System.err.println("Multicast message received :"+msg);
            
            }
        }catch(IOException ex){
        ex.printStackTrace();
        }
    }
    
}
