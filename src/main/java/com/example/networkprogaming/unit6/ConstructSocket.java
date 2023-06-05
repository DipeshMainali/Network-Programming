package com.example.networkprogaming.unit6;

import java.io.IOException;
import java.net.*;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-25
 **/
public class ConstructSocket {

    public void construct() {
//        public Socket(String host, int port) throws UnknownHostException, IOException
//        public Socket(InetAddress host, int port) throws IOException
        try {
            Socket socket = new Socket("www.yahoo.com", 80);
//            socket.getRemoteSocketAddress();
//            socket.getLocalAddress();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }

//        public Socket()
//        public Socket(Proxy proxy)
//        protected Socket(SocketImpl impl)
        try {
            Socket socket = new Socket();
            SocketAddress address = new InetSocketAddress("time.nist.gov", 13);
            socket.connect(address);
        } catch (IOException ex) {
            System.err.println(ex);
        }


        try {
            SocketAddress proxyAddress = new InetSocketAddress("myproxy.example.com", 1080);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
            Socket s = new Socket(proxy);
            SocketAddress remote = new InetSocketAddress("login.ibiblio.org", 25);
            s.connect(remote);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void constructToFrom() throws IOException {
//        public Socket(String host, int port, InetAddress interface, int localPort)throws IOException, UnknownHostException
//        public Socket(InetAddress host, int port, InetAddress interface, int localPort)throws IOException
            InetAddress inward = InetAddress.getByName("router");
            Socket socket = new Socket("www.yahoo.com", 80, inward, 0);
            // java chooses a random available port between 1024 and 65535
    }

//    Q. Find out which of the first 1024 ports seem to be hosting any servers on a specified host?

    public void answer(String host) {
        for (int i = 1; i < 1024; i++) {
            try {
                Socket s = new Socket(host, i);
                System.out.println("There is a server on port " + i + " of " + host);
                s.close();
            } catch (UnknownHostException ex) {
                System.err.println(ex);
                break;
            } catch (IOException ignore) {
            }
        }
    }


//    SOCKET OPTIONS:

//    TCP_NODELAY
//    SO_TIMEOUT
//    SO_LINGER
//    SO_SNDBUF
//    SO_RCVBUF
//    SO_KEEPALIVE
//    OOBINLINE
//    IP_TOS


    // SOCKET EXCEPTION
//    SocketException extends IOException
//    ProtocolException extends IOException
//    PortUnreachableException
//    NoRouteToHostException
}
