package com.example.networkprogaming.unit2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-04-03
 **/
public class InternetProtocol {
    public static void main(String[] args) throws UnknownHostException, SocketException {
//        String host = "www.google.com";
//        InetAddress address = InetAddress.getByName(host);
//        System.out.println(address);
//        System.out.println(Arrays.toString(address.getAddress()));
//
//        byte[] addressByte = {-100,-6,-50,100};
//        InetAddress address2 = InetAddress.getByAddress(addressByte);
//        System.out.println(address2);
//        InetAddress address3 = InetAddress.getByAddress(host, addressByte);
//        System.out.println(address3);
//        InetAddress address4 = InetAddress.getLoopbackAddress();
//        System.out.println(address4);
//
//
//        InetAddress[] address5 = InetAddress.getAllByName(host);
//
//        for (InetAddress add: address5) {
//            System.out.println(add);
//        }

//        NetworkInterface networkInterface = NetworkInterface.getByName(host);
//        Enumeration addresss = networkInterface.getInetAddresses();

        Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
        while (networks.hasMoreElements()) {
            NetworkInterface network = networks.nextElement();

            System.out.println(network.getIndex());
            System.out.println(network);
            System.out.println(network.getDisplayName());
            System.out.println(network.getName());
            System.out.println(network.getInetAddresses());
        }
    }
}
