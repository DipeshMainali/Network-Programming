package com.example.networkprogaming.unit3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-02
 **/
public class ProxiesExample {
//    proxy server receives a request for a remote server from a local client
//    proxy server makes the request to the remote server and forwards the result back to the local client
//
//    1. for security reasons, such as to prevent remote hosts from learning private details about the local
//    network configuration
//
//    2. to prevent users from accessing forbidden sites by filtering outgoing requests and limiting
//    which sites can be viewed
//
//    3. for performance, to allow multiple users to retrieve the same popular documents
//    from a local cache rather than making repeated downloads from the remote server.

    private void setProxyByProperties() {
        System.setProperty("http.proxyHost", "192.168.254.254");
        System.setProperty("http.proxyPort", "9000");
        System.setProperty("http.nonProxyHosts", "docs.google.com|console.google.com");
    }

    private void setProxyByClass() {
        SocketAddress address = new InetSocketAddress("proxy.example.com", 80);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, address);

    }

    private void setProxyBySelector() {
        ProxySelector selector = new CustomProxySelector();
        ProxySelector.setDefault(selector);
    }
}
