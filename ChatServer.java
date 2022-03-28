
package acchamma.NetworkProgramming;
import java.net.*;
import java.io.*;
import java.util.*;


public class ChatServer {
    public static void main(String[] args){
    String clientMsg ="";
    String serverMsg ="";
        System.out.println("----Server-----");
    try{
        while(!serverMsg.equals("bye")){
        //Creating Server Socket
        ServerSocket ss = new ServerSocket(12345);
        //Accepting client Connection
        Socket s = ss.accept();
        //Receiving message from client
        DataInputStream inp = new DataInputStream(s.getInputStream());
        clientMsg = inp.readUTF();
        //Displaying message to screen
            System.out.println("Client says:"+clientMsg);
            //Preparing message to client
            Scanner msg = new Scanner(System.in);
            serverMsg = msg.nextLine();
        //Sending message to client
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeUTF(serverMsg);
        out.flush();
        //Closing socket Connection
        ss.close();
        
        
        }
    
    }
    catch(IOException e){
    
    
    }
    
    }
    
}
