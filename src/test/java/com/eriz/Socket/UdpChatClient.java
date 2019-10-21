package com.eriz.Socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpChatClient {
    public static void main(String[] args) {
        System.out.println("-----------顾客---------");
        try {
            DatagramSocket socket = new DatagramSocket(6666);
            Scanner input = new Scanner(System.in);
            while (true) {
                String str = input.next();
                byte[] bs = str.getBytes();
                DatagramPacket packet = new DatagramPacket(bs, bs.length, InetAddress.getLocalHost(), 8888);
                socket.send(packet);
                byte[] bs2 = new byte[1024];
                DatagramPacket packet1 = new DatagramPacket(bs2, bs2.length);
                byte[] servermessage = packet1.getData();
                String string = new String(servermessage, 0, servermessage.length);
                System.out.println("客服说：" + string);
                if (servermessage.equals("bye")){
                    break;
                }
            }
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
