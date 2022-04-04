package networking;

import java.net.*;
import java.io.*;
import java.util.*;

public class MultiThradeDateNtimeClient {

    public static void main(String[] args) {

        String hostname = "192.168.1.117";

        try {
            Socket theSocket = new Socket(hostname, 20202);
            DataOutputStream id = new DataOutputStream(theSocket.getOutputStream());
            String name = "Ananda Raj";
            id.writeUTF(name);
            id.flush();

            InputStream timeStream = theSocket.getInputStream();
            StringBuffer time = new StringBuffer();
            int c;
            while ((c = timeStream.read()) != -1) {
                time.append((char) c);
            }
            String timeString = time.toString().trim();
            System.out.println("It is " + timeString + " at " + hostname);
        } // end try
        catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

}
