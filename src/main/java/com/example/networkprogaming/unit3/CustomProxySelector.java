package com.example.networkprogaming.unit3;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-03
 **/
public class CustomProxySelector extends ProxySelector {

    private List<URI> failed = new ArrayList<URI>();

    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> result = new ArrayList<Proxy>();
        if (failed.contains(uri)
                || !"http".equalsIgnoreCase(uri.getScheme())) {
            result.add(Proxy.NO_PROXY);
        } else {
            SocketAddress proxyAddress
                    = new InetSocketAddress( "proxy.example.com", 8000);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);
            result.add(proxy);
        }
        return result;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
            failed.add(uri);
    }
}
