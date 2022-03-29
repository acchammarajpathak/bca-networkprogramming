
package acchamma.NetworkProgramming;
import java.io.*;
import java.net.*;
import java.util.*;


public class OddEvenClient {
    public static void main(String [] args){
    int num;
    String result ="";
    System.out.println("----Client------");
    try{
        //Connecting to serv er
        Socket s = new Socket("localhost",23232);
        //To take input from user
        Scanner inp =new Scanner(System.in);
        System.out.println("Enter number:");
        num = inp.nextInt();
        //Sending number to server
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeInt(num);
        out.flush();
        //Receiving Result from Server
        DataInputStream in = new DataInputStream(s.getInputStream());
        result = in.readUTF();
        //Displaying Result
        System.out.println(+num+"is "+result);
        //Closing Connection
        s.close();
        
    
    
    }
    catch(IOException e){
    System.err.println("Connection Error"+e);
    }
    
    
    }
    
}
    
