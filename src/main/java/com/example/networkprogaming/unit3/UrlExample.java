package com.example.networkprogaming.unit3;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-04-20
 **/
public class UrlExample {

    public static void main(String[] args) {

        // secure http
        checkProtocol("https://www.amazon.com/exec/obidos/order2/");
// file transfer protocol
        checkProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
// Simple Mail Transfer Protocol
        checkProtocol("mailto:elharo@ibiblio.org");
// telnet
        checkProtocol("telnet://dibner.poly.edu/");
// local file access
        checkProtocol("file:///etc/passwd");
// gopher
        checkProtocol("gopher://gopher.anc.org.za/");
// Lightweight Directory Access Protocol
        checkProtocol(
                "ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
// JAR
        checkProtocol(
                "jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
                        + "/com/macfaq/io/StreamCopier.class");
// NFS, Network File System
        checkProtocol("nfs://utopia.poly.edu/usr/tmp/");
// a custom protocol for JDBC
        checkProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");
// rmi, a custom protocol for remote method invocation
        checkProtocol("rmi://ibiblio.org/RenderEngine");
// custom protocols for HotJava
        checkProtocol("doc:/UsersGuide/release.html");
        checkProtocol("netdoc:/UsersGuide/release.html");
        checkProtocol("systemresource://www.adc.org/+/index.html");
        checkProtocol("verbatim:http://www.adc.org/");
    }

    private static void checkProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");

            System.out.println(u.getPath());
            System.out.println(u.getPort());
            System.out.println(u.getHost());
            System.out.println(u.getQuery());

        } catch (MalformedURLException ex) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }


    private static void otherConstruction() throws MalformedURLException {
        URL url = new URL("http", "www.eff.org", "/blueribbon.html#intro");
        URL url2 = new URL("http", "fourier.dur.ac.uk", 8000, "/~dma3mjh/jsci/");


        // Using Relative Url
        URL u1 = new URL("http://www.ibiblio.org/javafaq/index.html");
        URL u2 = new URL(u1, "mailinglists.html");

    }

    private static void retriveInformation() throws MalformedURLException {

//        InputStream openStream() throws IOException -
//        URLConnection openConnection() throws IOException
//        URLConnection openConnection(Proxy proxy) throws IOException
//        Object getContent() throws IOException
//        Object getContent(Class[] classes) throws IOException

        try {
            URL u = new URL("http://www.lolcats.com");
            InputStream in = u.openStream();
            int c;
            while ((c = in.read()) != -1) System.out.write(c);
            in.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void getData(String url) {
        // http:www.oreilly.com
        InputStream in = null;
        try {
// Open the URL for reading
            URL u = new URL(url);
            in = u.openStream();
// buffer the input to increase performance
            in = new BufferedInputStream(in);
// chain the InputStream to a Reader
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
// ignore
                }
            }
        }
    }


    private static void retriveInformationByContent() throws IOException {
        URL u = new URL("http://www.lolcats.com");
        Object obj = u.getContent();
        System.out.println(obj.toString());
    }

    private static void equalityChecker(String url1, String url2) throws MalformedURLException {
        URL u1 = new URL(url1);
        URL u2 = new URL(url2);
        if (u2.equals(u1)) {
            System.out.println("Url are same.");
        } else {
            System.out.println("They are not same urls");
        }

        u1.toString();
        String.valueOf(u1);

        // Methods to Convert
//        public String toString()
//        public String toExternalForm()
//        public URI toURI() throws URISyntaxException
    }
}
