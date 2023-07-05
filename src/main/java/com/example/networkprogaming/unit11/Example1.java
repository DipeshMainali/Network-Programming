package com.example.networkprogaming.unit11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-11
 **/
public class Example1 {
    public static void main(String[] args) {
        InetAddress group = null;
        int port = 0;
// read the address from the command line
        try {
            group = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | UnknownHostException ex) {
            System.err.println(
                    "Usage: java MulticastSniffer multicast_address port");
            System.exit(1);
        }
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);
            byte[] buffer = new byte[8192];
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);
                String s = new String(dp.getData(), StandardCharsets.ISO_8859_1);
                System.out.println(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException ignore) {}
            }
        }
    }
}
