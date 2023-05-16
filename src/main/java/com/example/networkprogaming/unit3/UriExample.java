package com.example.networkprogaming.unit3;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-04-27
 **/
public class UriExample {

    public static void main(String[] args) {
        String[] uri = {
                "tel:+1-800-9988-9938", // voice
                "http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc", // web
                "urn:isbn:1-565-92870-9" // book
        };
        // write to run availableMethods function for uri array value
    }

    private static void construction(String uri) throws URISyntaxException {
//    public URI(String uri) throws URISyntaxException
//    public URI(String scheme, String schemeSpecificPart, String fragment) throws URISyntaxException
//    public URI(String scheme, String host, String path, String fragment) throws URISyntaxException
//    public URI(String scheme, String authority, String path, String query, String fragment) throws URISyntaxException
//    public URI(String scheme, String userInfo, String host, int port, String path, String query, String fragment) throws URISyntaxExceptio

        URI u = new URI(uri);

//         for non-hierarchical URIs
        URI absolute = new URI("http", "//www.ibiblio.org" , null);
        URI relative = new URI(null, "/javafaq/index.shtml", "today");

        // for hierarchical URIs such as http and ftp URLs
        URI u2= new URI(
                "http",
                "www.ibiblio.org",
                "/javafaq/index.html",
                "today");

        URI u3 = new URI(
                "http",
                "www.ibiblio.org",
                "/javafaq/index.html",
                "referrer=cnet&date=2014-02-23",
                "today");

        URI u4 = new URI(
                "ftp",
                "anonymous:elharo@ibiblio.org",
                "ftp.oreilly.com",
                21,
                "/pub/stylesheet",
                null,
                null);

        URI sureUri = URI.create("ftp://anonymous:elharo%40ibiblio.org@ftp.oreilly.com:21/pub/stylesheet");
    }

    private static void availableMethods(String value) throws URISyntaxException {
        URI u = new URI(value);
        System.out.println("The URI is " + u);
        if (u.isOpaque()) {
            System.out.println("This is an opaque URI.");
            System.out.println("The scheme is " + u.getScheme());
            System.out.println("The scheme specific part is "
                    + u.getSchemeSpecificPart());
            System.out.println("The fragment ID is " + u.getFragment());
        } else {
            System.out.println("This is a hierarchical URI.");
            System.out.println("The scheme is " + u.getScheme());
            try {
                u = u.parseServerAuthority();
                System.out.println("The host is " + u.getHost());
                System.out.println("The user info is " + u.getUserInfo());
                System.out.println("The port is " + u.getPort());
            } catch (URISyntaxException ex) {
// Must be a registry based authority
                System.out.println("The authority is " + u.getAuthority());
            }
            System.out.println("The path is " + u.getPath());
            System.out.println("The query string is " + u.getQuery());
            System.out.println("The fragment ID is " + u.getFragment());
        }
    }

    public static void assignment() {
        // write about follow methods: what do they do.
//        getScheme()
//        getSchemeSpecificPart()
//        getRawSchemeSpecificPart()
//        getFragment()
//        getRawFragment()
//        isAbsolute()
//        isOpaque()
//        getAuthority()
//        getFragment()
//        getHost()
//        getPath()
//        getPort()
//        getQuery()
//        getUserInfo()
//        getRawAuthority()
//        getRawFragment()
//        getRawPath()
//        getRawQuery()
//        getRawUserInfo()
//        parseServerAuthority()
    }
}
