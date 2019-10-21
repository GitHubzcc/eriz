package com.eriz.Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    final static int port = 9999;

    public static void main(String[] args) {
        try {
            //1.创建数据报套接字
            DatagramSocket socket = new DatagramSocket(port);
            DatagramSocket datagramSocket = new DatagramSocket(7777);
            //2.创建一个数据报包
            byte[] content = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(content, content.length);
            String str = "我已经收到信息";
            byte[] sendContent = str.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendContent,sendContent.length,InetAddress.getLocalHost(),port);
            //循环接收客户端发送信息
            while (true){
                //3.调用receive方法接收数据包
                socket.receive(datagramPacket);
                //4.从数据报包中获取数据
                byte[] data = datagramPacket.getData();//获取数据报包中的数据
                int length = datagramPacket.getLength();//
                InetAddress ip = datagramPacket.getAddress();
                int port = datagramPacket.getPort();
                System.out.println("内容:" + new String(data, 0, length));
                System.out.println("数据长度:" + length);
                System.out.println("发送方的IP地址:" + ip);
                System.out.println("发送方的端口号:" + port);
                datagramSocket.send(sendPacket);
            }
            //5.释放资源
//            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
