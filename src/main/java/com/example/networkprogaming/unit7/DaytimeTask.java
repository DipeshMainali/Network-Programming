package com.example.networkprogaming.unit7;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-01
 **/
public class DaytimeTask implements Callable<Boolean> {
    private final Socket connection;
    DaytimeTask(Socket connection) {
        this.connection = connection;
    }
    @Override
    public Boolean call() {
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
        return true;
    }
}
