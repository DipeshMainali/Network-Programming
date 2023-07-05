package com.example.networkprogaming.unit9;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-09
 **/
public class ChannelExample {
    public void socketChannel() throws IOException {
//        The SocketChannel class reads from and writes to TCP sockets

        // 1. Connecting
        SocketAddress address = new InetSocketAddress("www.cafeaulait.org", 80);
        SocketChannel channel = SocketChannel.open(address);

        SocketChannel channel2 = SocketChannel.open();
        channel2.configureBlocking(false);
        channel2.connect(address);

        // 2. Reading
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        while (buffer.hasRemaining() && channel.read(buffer) != -1) ;

        // 3. Writing
        while (buffer.hasRemaining() && channel.write(buffer) != -1) ;

        // 4. Closing
        channel.close();
        channel2.close();

        channel.isOpen();
    }

    public void serverSocketChannel() throws IOException {
        SocketAddress address = new InetSocketAddress(80);

        // 1. Creating
        ServerSocketChannel server1 = ServerSocketChannel.open();
        ServerSocket socket = server1.socket();
        socket.bind(address);

        // From Java 7
        ServerSocketChannel server2 = ServerSocketChannel.open();
        server2.bind(address);

        // 2. Accepting Connection
        socket.accept();
        server2.accept();
    }

    public void channelsClass() throws IOException {
        SocketAddress address = new InetSocketAddress(80);
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(address);

        SocketChannel channel = server.accept();
        InputStream in = Channels.newInputStream(channel);
    }

    public void asyncChannelsClass() throws IOException, ExecutionException, InterruptedException {
        SocketAddress address = new InetSocketAddress("www.cafeaulait.org", 80);
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<Void> connected = client.connect(address);
        ByteBuffer buffer = ByteBuffer.allocate(74);
// wait for the connection to finish
        connected.get();
// read from the connection
        Future<Integer> future = client.read(buffer);
// do other things...
// wait for the read to finish...
        future.get();
// flip and drain the buffer
        buffer.flip();
        WritableByteChannel out = Channels.newChannel(System.out);
        out.write(buffer);
    }


    public void socketOption() throws IOException {
//        • SocketOption<NetworkInterface> StandardSocketOptions.IP_MULTICAST_IF
//        • SocketOption<Boolean> StandardSocketOptions.IP_MULTICAST_LOOP
//        • SocketOption<Integer> StandardSocketOptions.IP_MULTICAST_TTL
//        • SocketOption<Integer> StandardSocketOptions.IP_TOS
//        • SocketOption<Boolean> StandardSocketOptions.SO_BROADCAST
//        • SocketOption<Boolean> StandardSocketOptions.SO_KEEPALIVE
//        • SocketOption<Integer> StandardSocketOptions.SO_LINGER
//        • SocketOption<Integer> StandardSocketOptions.SO_RCVBUF
//        • SocketOption<Boolean> StandardSocketOptions.SO_REUSEADDR
//        • SocketOption<Integer> StandardSocketOptions.SO_SNDBUF
//        • SocketOption<Boolean> StandardSocketOptions.TCP_NODELAY

        NetworkChannel channel = SocketChannel.open();
        channel.setOption(StandardSocketOptions.SO_LINGER, 240);

        printOptions(SocketChannel.open());
        printOptions(ServerSocketChannel.open());
        printOptions(AsynchronousSocketChannel.open());
        printOptions(AsynchronousServerSocketChannel.open());
        printOptions(DatagramChannel.open());
    }

    private void printOptions(NetworkChannel channel) throws IOException {
        System.out.println(channel.getClass().getSimpleName() + " supports:");
        for (SocketOption<?> option : channel.supportedOptions()) {
            System.out.println(option.name() + ": " + channel.getOption(option));
        }
        System.out.println();
        channel.close();
    }

}
