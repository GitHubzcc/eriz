package com.eriz.Socket;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            //1.创建数据报套接字
            DatagramSocket datagramSocket = null;
            try {
                datagramSocket = new DatagramSocket(6666);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            //2.创建数据报包用于封装数据和目标地址
            String str = "hello world!";
            byte[] content = str.getBytes();//将字符串转换为字节的数组
            DatagramPacket datagramPacket = new DatagramPacket(content, content.length, InetAddress.getLocalHost(), 9999);
            //3.调用send方法进行发送数据
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(datagramPacket);
            System.out.println("内容1:" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
            System.out.println("数据长度1:" + datagramPacket.getLength());
            System.out.println("发送方的IP地址1:" + datagramPacket.getAddress());
            System.out.println("发送方的端口号1:" + datagramPacket.getPort());
            //4.释放资源
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
