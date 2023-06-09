package com.example.networkprogaming.unit10.examples.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-11
 **/
public class FastUDPDiscardServer extends UDPServer {
    public final static int DEFAULT_PORT = 9;

    public FastUDPDiscardServer() {
        super(DEFAULT_PORT);
    }

    public static void main(String[] args) {
        UDPServer server = new FastUDPDiscardServer();
        Thread t = new Thread(server);
        t.start();
    }

    @Override
    public void respond(DatagramSocket socket, DatagramPacket request) {
    }
}
