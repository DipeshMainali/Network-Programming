package com.example.networkprogaming.unit9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-09
 **/
public class ReadinessSelection {
    public static void main(String[] args) throws IOException {
        SocketAddress address = new InetSocketAddress(80);
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(address);

        SocketChannel channel = server.accept();
        Selector selector = Selector.open();

        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

        // Non-Blocking
        selector.selectNow();
        // Blocking
        selector.select();
        selector.select(5000L);

        selector.selectedKeys();

//        isAcceptable()
//        isConnectable()
//        isReadable()
//        isWritable()

        // to get Channel
//        channel()
//        attachment()

//        cancel()
    }
}
