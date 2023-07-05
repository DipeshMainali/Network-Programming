package com.example.networkprogaming.unit10.channel;

import java.io.IOException;
import java.net.SocketOption;
import java.nio.channels.DatagramChannel;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-06-11
 **/
public class SocketOptionExample {
    public static void main(String[] args) {
        try (DatagramChannel channel = DatagramChannel.open()) {
            for (SocketOption<?> option : channel.supportedOptions()) {
                System.out.println(option.name() + ": " + channel.getOption(option));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
