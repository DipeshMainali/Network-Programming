package com.example.networkprogaming.unit10.examples.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-11
 **/
public class UDPEchoServer extends UDPServer {
    public final static int DEFAULT_PORT = 7;

    public UDPEchoServer() {
        super(DEFAULT_PORT);
    }

    public static void main(String[] args) {
        UDPServer server = new UDPEchoServer();
        Thread t = new Thread(server);
        t.start();
    }

    @Override
    public void respond(DatagramSocket socket, DatagramPacket packet)
            throws IOException {
        DatagramPacket outgoing = new DatagramPacket(packet.getData(),
                packet.getLength(), packet.getAddress(), packet.getPort());
        socket.send(outgoing);
    }
}
