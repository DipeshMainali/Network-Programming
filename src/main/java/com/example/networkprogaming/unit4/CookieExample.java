package com.example.networkprogaming.unit4;

import java.net.*;
import java.util.List;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-08
 **/
public class CookieExample {
    public static void init() {
        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        manager.setCookiePolicy(new CustomCookiePolicy());
        CookieHandler.setDefault(manager);



//        CookiePolicy
//        public boolean shouldAccept(URI uri, HttpCookie cookie)
    }

    public static void storingCookies() {
        CookieManager manager = new CookieManager();
        CookieStore store = manager.getCookieStore();


//        void add(URI uri, HttpCookie cookie)
//        List<HttpCookie> get(URI uri)
//        List<HttpCookie> getCookies()
//        List<URI> getURIs()
//        boolean remove(URI uri, HttpCookie cookie)
//        boolean removeAll()
    }
}
