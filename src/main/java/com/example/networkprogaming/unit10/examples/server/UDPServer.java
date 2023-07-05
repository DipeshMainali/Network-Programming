package com.example.networkprogaming.unit10.examples.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-10
 **/
public abstract class UDPServer implements Runnable {
    private final int bufferSize; // in bytes
    private final int port;
    private volatile boolean isShutDown = false;

    public UDPServer(int port, int bufferSize) {
        this.bufferSize = bufferSize;
        this.port = port;
    }

    public UDPServer(int port) {
        this(port, 8192);
    }

    @Override
    public void run() {
        byte[] buffer = new byte[bufferSize];
        try (DatagramSocket socket = new DatagramSocket(port)) {
            socket.setSoTimeout(10000); // check every 10 seconds for shutdown
            while (true) {
                if (isShutDown) return;
                DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
                try {
                    socket.receive(incoming);
                    this.respond(socket, incoming);
                } catch (SocketTimeoutException ex) {
                    if (isShutDown) return;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } // end while
        } catch (SocketException ex) {
            System.out.println("Could not bind to port: " + port + " " + ex);
        }
    }

    public abstract void respond(DatagramSocket socket, DatagramPacket request)
            throws IOException;

    public void shutDown() {
        this.isShutDown = true;
    }
}
