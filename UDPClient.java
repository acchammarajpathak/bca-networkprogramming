package acchamma.NetworkProgramming;

import java.net.*;
import java.io.*;
import java.util.*;

public class UDPClient {

    public static void main(String[] args) throws Exception {
        Scanner inp = new Scanner(System.in);
//        String IPAddress = "localhost";
        InetAddress IPAddress = InetAddress.getLocalHost();
        int port = 12121;
        DatagramSocket ds = new DatagramSocket();
        byte[] sendBuffer = new byte[1024];
         byte[] receiveBuffer = new byte[1024];
        System.out.println("Enter your message :");
        String msg = inp.nextLine();
        sendBuffer = msg.getBytes();
        //message send
        DatagramPacket sdp = new DatagramPacket(sendBuffer, sendBuffer.length, IPAddress, port);
        ds.send(sdp);
        //receiving msg
        DatagramPacket rdp = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        ds.receive(rdp);
        String receivedMsg = new String(rdp.getData());
        System.out.println("Message from server :"+receivedMsg);
    }

}