package acchamma.NetworkProgramming;

import java.net.*;
import java.io.*;
import java.util.*;

public class UDPServer {

    public static void main(String[] args) throws Exception {
       Scanner inp = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket(12121);
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer = new byte[1024];
        //receive from client
        DatagramPacket rdp = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        ds.receive(rdp);
        String receivedMsg = new String(rdp.getData());
        System.out.println("Message from client:" + receivedMsg);
        //send to client
        System.out.println("Enter message to client:");
        String msg = inp.nextLine();
        sendBuffer = msg.getBytes();
        InetAddress IPAddress = rdp.getAddress();
        int port = rdp.getPort();
        DatagramPacket sdp = new DatagramPacket(sendBuffer, sendBuffer.length, IPAddress, port);
        ds.send(sdp);
    }
}
