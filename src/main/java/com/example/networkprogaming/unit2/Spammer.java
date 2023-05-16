package com.example.networkprogaming.unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-04-05
 **/
public class Spammer {
    public static final String LOOKUP_HOST = "sbl.spamhaus.org";

    public static void main(String[] args) {
        String[] hosts = {"207.34.56.23", "125.12.32.4", "130.130.130.130", "www.facebook.com"};
        for (String host : hosts) {
            if (isSpammer2(host)) {
                System.out.println(host + " is a known spammer.");
            } else {
                System.out.println(host + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            byte[] addressBytes = address.getAddress();
            StringBuilder query = new StringBuilder(LOOKUP_HOST);
            for (byte number : addressBytes) {
                int unsignedByte = number < 0 ? number + 256 : number;
                query.insert(0, unsignedByte + ".");
            }
            InetAddress addr = InetAddress.getByName(query.toString());
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    private static boolean isSpammer2(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            byte[] addressBytes = address.getAddress();
            String  query = LOOKUP_HOST;
            for (byte number : addressBytes) {
                int unsignedByte = number < 0 ? number + 256 : number;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    private static boolean isSpammer3(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            byte[] addressBytes = address.getAddress();
            String  query = LOOKUP_HOST;
            for (int i = 0; i < addressBytes.length; i++) {
                byte number = addressBytes[i];
                int unsignedByte = number < 0 ? number + 256 : number;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
