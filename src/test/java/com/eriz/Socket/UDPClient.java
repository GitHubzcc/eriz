package com.eriz.Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author eriz
 * @data 2019年4月29日
 * @deprecated socket
 */
public class UDPClient {

    public static void main(String[] args) {
//        try {
//            InetAddress inetAddress = InetAddress.getLocalHost();
//            System.out.println(inetAddress.getAddress());
//            System.out.println(inetAddress.getHostName());
//            System.out.println(inetAddress.getHostAddress());
//
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
        int s = 444;
        byte test = (byte) s;
        System.out.println(test);
    }
}
