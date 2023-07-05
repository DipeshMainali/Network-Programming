package com.example.networkprogaming.unit9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-09
 **/
public class ExampleClient {
    public static int DEFAULT_PORT = 19;
    public static String DEFAULT_HOST = "";
    public static void main(String[] args) {
        try {
            SocketAddress address = new InetSocketAddress(DEFAULT_HOST, DEFAULT_PORT);
            SocketChannel client = SocketChannel.open(address);
            ByteBuffer buffer = ByteBuffer.allocate(74);
            WritableByteChannel out = Channels.newChannel(System.out);
            while (client.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    Chargen is not commonly used these days, and may be blocked by local
//    firewalls even if it’s turned on. It’s vulnerable to a “ping-pong” denial-
//    of-service attack, in which spoofed Internet packets cause two hosts to
//    spew an unlimited amount of data at each other. Furthermore, be‐
//    cause it’s almost infinitely asymmetric—the server sends an unlimi‐
//    ted amount of data in response to the smallest of client requests—it’s
//    very easy for even a few dozen compromised hosts, much less a large
//    botnet, to convince a chargen server to saturate its local bandwidth.
}
