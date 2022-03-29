/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acchamma.NetworkProgramming;
import java.net.*;
import java.io.*;

        
public class OddEvenServer {
    public static void main(String []args){
        int n;
    String result = "";
    System.out.println("----Server-----");
    try{
       
        //Creating Server Socket
        ServerSocket ss = new ServerSocket(23232);
    
        //Accepting client Connection
        Socket s = ss.accept();
        //Receiving message from client
        DataInputStream inp = new DataInputStream(s.getInputStream());
        n = inp.readInt();
        //Checking odd or even
        if(n%2 == 0)
            result = "even";
        else
            result = "odd";
        //Returning factorial to client
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(result);
            out.flush();
           
        //Closing socket Connection
        ss.close();
        
        
        }
    
    
    catch(IOException e){
    System.err.println("Connection Error"+e);
    
    }
    
    }
}
      
    

