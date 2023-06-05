package com.example.networkprogaming.unit7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-01
 **/
public class SocketThread {
    public final static int PORT = 13;
    public void simpleThreadExample() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = server.accept();
                    Thread task = new DaytimeThread(connection);
                    task.start();
                } catch (IOException ignore) {}
            }
        } catch (IOException ex) {
            System.err.println("Couldn't start server");
        }
    }

    public void fixedThreadExample() {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = server.accept();
                    Callable<Boolean> task = new DaytimeTask(connection);
                    pool.submit(task);
                } catch (IOException ignore) {}
            }
        } catch (IOException ex) {
            System.err.println("Couldn't start server");
        }
    }
}
