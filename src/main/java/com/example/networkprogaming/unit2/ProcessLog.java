package com.example.networkprogaming.unit2;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-04-05
 **/
public class ProcessLog {

// input:  205.160.186.76 unknown - [06/April/2023:05:50:58 -0500] "GET /home/profile.png HTTP 1.0" 200 50
// output:  www.texas.com unknown - [06/April/2023:05:50:58 -0500] "GET /home/profile.png HTTP 1.0" 200 50


    public static void main(String[] args) {
        String fileName = "log.txt";
        try (FileInputStream fin =  new FileInputStream(fileName);
             Reader in = new InputStreamReader(fin);
             BufferedReader bin = new BufferedReader(in)) {

            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                // separate out the IP address
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                // Ask DNS for the hostname and print it out
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException ex) {
                    System.err.println(entry);
                }
            }
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }


}
