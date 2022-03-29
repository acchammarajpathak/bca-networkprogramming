/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acchamma.NetworkProgramming;
import java.net.*;
import java.io.*;
import java.util.*;


public class ArithmeticServer {
    public static void main(String[] args){
  int n,i,f=1;
        System.out.println("----Server-----");
    try{
       
        //Creating Server Socket
        ServerSocket ss = new ServerSocket(23232);
        while(true){
        //Accepting client Connection
        Socket s = ss.accept();
        //Receiving message from client
        DataInputStream inp = new DataInputStream(s.getInputStream());
        n = inp.readInt();
        //Calculating factorial
        for(i=n;i>0;i--)
            f=f*i;
        //Returning factorial to client
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeInt(f);
            out.flush();
           
        //Closing socket Connection
        ss.close();
        
        
        }
    
    }
    catch(IOException e){
    System.err.println("Connection Error"+e);
    
    }
    
    }
    
}