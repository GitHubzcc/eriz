package com.eriz.Socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpChatServer {
    public static void main(String[] args) {

        System.out.println("----------客服---------");
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            Scanner input = new Scanner(System.in);

            while (true) {
                byte[] bs2 = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bs2, bs2.length);
                socket.receive(packet);
                byte[] message = packet.getData();
                System.out.println("顾客说：" + new String(message,0,message.length));
                String str = input.next();
                byte[] bs = str.getBytes();
                DatagramPacket packet1 = new DatagramPacket(bs, bs.length, InetAddress.getByName("127.0.01"), 6666);
                socket.send(packet1);
                if (str.equals("bye")) {
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
