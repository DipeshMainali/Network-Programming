package com.example.networkprogaming.unit7;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-31
 **/
public class ServerExample {
    public void example(int port) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true) {
                Socket connection = null;
                try {
                    connection = server.accept();
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString() + "\r\n");
                    out.flush();
                    connection.close();
                } catch (IOException ignore) {
                } finally {
                    try {
                        if (connection != null) connection.close();
                    } catch (IOException ex) {
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException ex) {
            }
        }
    }

    public void exampleByte(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    OutputStream out = connection.getOutputStream();
                    byte[] time;

                    time = new Date().toString().getBytes();

                    out.write(time);
                    out.flush();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

//    public ServerSocket(int port) throws BindException, IOException
//    public ServerSocket(int port, int queueLength) throws BindException, IOException
//    public ServerSocket(int port, int queueLength, InetAddress bindAddress) throws IOException
//    public ServerSocket() throws IOException


//    Socket Options
//      • SO_TIMEOUT
//      • SO_REUSEADDR
//      • SO_RCVBUF
}
