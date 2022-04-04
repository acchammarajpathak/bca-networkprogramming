package networking;
import java.net.*;
import java.io.*;
import java.util.*;
public class MultiThradeDateNtimeServer {
    public static void main(String[]args){
        try{
           
 ServerSocket ss = new ServerSocket(20202);
 System.out.println("---Server has been started---");
 while(true){
 Socket s = ss.accept();
 
 Thread th = new DayTimeThread(s);
 th.start();
 }
 }
 catch(IOException e){
 System.err.println("IO Error. "+e);
 }
 }
}
class DayTimeThread extends Thread{
 Socket soc;
 String msg = "Thank you.";
 DayTimeThread(Socket soc){
 this.soc = soc;
 }
 @Override
 public void run(){
 try{
 DataInputStream inp = new DataInputStream(soc.getInputStream());
 String name = inp.readUTF();
 System.out.println("Time sent to :"+name);
 //Sending time to client
 Writer w = new OutputStreamWriter(soc.getOutputStream());
 Date now = new Date();
 w.write(now.toString());
 w.flush();
 }
 catch(IOException e){
 System.err.println("IO Error. "+e);
 }
 finally{
 try{
 soc.close();
 }
 catch(IOException e){
 System.err.println("Error. "+e);
 }
 }
 }
}
 
 
