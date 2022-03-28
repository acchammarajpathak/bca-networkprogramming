
package acchamma.NetworkProgramming;
import java.io.*;
import java.net.*;
import java.util.*;


public class ChatClient {
    public static void main(String [] args){
    String clientMsg ="";
    String serverMsg ="";
    System.out.println("----Client-----");
    try{
    while(!clientMsg.equals("bye")){
    //Connecting Socket
    Socket s = new Socket("localhost",12345);
    //Preparing message to server
    Scanner msg = new Scanner(System.in);
    clientMsg = msg.nextLine();
    //Sending Message to server
    DataOutputStream out = new DataOutputStream(s.getOutputStream());
    out.writeUTF(clientMsg);
    out.flush();
    //Receiving message from server
    DataInputStream inp = new DataInputStream(s.getInputStream());
    serverMsg = inp.readUTF();
    //Display message to screen
        System.out.println("Server says:"+serverMsg);
    //closing Socket Connection
    s.close();
            
    
    
    
    
    }
    
    
    }
    catch(IOException e){
        System.err.println("Connection Error."+e);
    
    }
    
    }
    
}
