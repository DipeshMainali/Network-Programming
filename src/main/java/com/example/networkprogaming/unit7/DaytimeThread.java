package com.example.networkprogaming.unit7;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-01
 **/
public class DaytimeThread extends Thread{
    private final Socket connection;
    DaytimeThread(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            Date now = new Date();
            out.write(now +"\r\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (IOException ignore) {}
        }
    }
}
