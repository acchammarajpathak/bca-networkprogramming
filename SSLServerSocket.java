
package acchamma.NetworkProgramming;
import javax.net.ssl.*;
import java.io.*;
import java.net.*;
public class SSLServerSocket {
    public static void main(String[] args) {
        SSLServerSocketFactory ssf =(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try{
            ServerSocket ss = ssf.createServerSocket(12121);
            System.out.println("Server is running");
            Socket s = ss.accept();
            System.out.println("Connection has accepted");
            String msg ="Hello from SSL Server.";
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(msg);
            out.flush();
            s.close();
        
        }
        catch(Exception e){}
    }
}
