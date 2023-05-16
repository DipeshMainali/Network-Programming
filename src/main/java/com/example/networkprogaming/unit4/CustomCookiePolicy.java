package com.example.networkprogaming.unit4;
//A cookie policy that blocks all other cookies except for .gov cookies
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-08
 **/
public class CustomCookiePolicy implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        return uri.getAuthority().toLowerCase().endsWith(".gov")
                || cookie.getDomain().toLowerCase().endsWith(".gov");
    }
}