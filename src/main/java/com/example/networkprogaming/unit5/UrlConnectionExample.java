package com.example.networkprogaming.unit5;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-08
 **/
public class UrlConnectionExample {
//    an abstract class that represents an active connection to a resource specified by a URL
//    1. it provides more control over the interaction with a server (especially an HTTP server) than the URL class
//          - can inspect the header sent by the server and respond accordingly
//          - it can set the header fields used in the client request
//          - it can send data back to a web server with POST , PUT , and other HTTP request methods
//    2. is part of Java’s protocol handler mechanism, which also includes the URLStreamHandler class
//          - separate the details of processing a protocol from processing particular data types
//          - providing user interfaces
//          - doing the other work that a monolithic web browser performs
//

    // Opening Connection?
//      1. Construct a URL object.
//      2. Invoke the URL object’s openConnection() method to retrieve a URLConnection object for that URL.
//      3. Configure the URLConnection .
//      4. Read the header fields.
//      5. Get an input stream and read data.
//      6. Get an output stream and write data.
//      7. Close the connection.
//

    public static void main(String[] args) {
    }

    private static void urlConnectionMethod(String url) throws IOException {
        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();

        InputStream buffer = new BufferedInputStream(urlConnection.getInputStream());
        Reader reader = new InputStreamReader(buffer);
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
    }

    private void retrievingHeader(URLConnection urlConnection) {

//          • Content-type
//          • Content-length
//          • Content-encoding
//          • Date
//          • Last-modified
//          • Expires

        System.out.println("Content-type: " + urlConnection.getContentType());
        if (urlConnection.getContentLength() != -1) {
            System.out.println("Content-length: " + urlConnection.getContentLength());
        }
        if (urlConnection.getContentEncoding() != null) {
            System.out.println("Content-encoding: " + urlConnection.getContentEncoding());
        }
        if (urlConnection.getDate() != 0) {
            System.out.println("Date: " + new Date(urlConnection.getDate()));
        }
        if (urlConnection.getLastModified() != 0) {
            System.out.println("Last modified: " + new Date(urlConnection.getLastModified()));
        }
        if (urlConnection.getExpiration() != 0) {
            System.out.println("Expiration date: " + new Date(urlConnection.getExpiration()));
        }


        String contentType = urlConnection.getHeaderField("content-type");
        String contentEncoding = urlConnection.getHeaderField("content-encoding");

        int contentLength = urlConnection.getHeaderFieldInt("content-length", -1);
        Date expires = new Date(urlConnection.getHeaderFieldDate("expires", 0));

        for (int i = 1; ; i++) {
            String headerKey = urlConnection.getHeaderFieldKey(i);
            String header = urlConnection.getHeaderField(i);
            if (header == null) break;
            System.out.println(headerKey + ": " + header);
        }
    }

    private void withProperEncoding(String url) throws IOException {
        String encoding = "ISO-8859-1";

        URL u = new URL(url);
        URLConnection urlConnection = u.openConnection();

        String contentType = urlConnection.getContentType();
        int encodingStart = contentType.indexOf("charset=");
        if (encodingStart != -1) {
            encoding = contentType.substring(encodingStart + 8);
        }

        InputStream buffer = new BufferedInputStream(urlConnection.getInputStream());
        Reader reader = new InputStreamReader(buffer, encoding);
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
    }



    private static void saveBinaryFile(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        String contentType = urlConnection.getContentType();
        int contentLength = urlConnection.getContentLength();

        if (contentType.startsWith("text/") || contentLength == -1) {
            throw new IOException("This is not a binary file.");
        }

        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        byte[] data = new byte[contentLength];

        int offset = 0;
        while (offset < contentLength) {
            int bytesRead = in.read(data, offset, data.length - offset);
            if (bytesRead == -1) break;
            offset += bytesRead;
        }
        if (offset != contentLength) {
            throw new IOException("Only read " + offset + " bytes; Expected " + contentLength + " bytes");
        }

        String filename = url.getFile();
        filename = filename.substring(filename.lastIndexOf('/') + 1);

        try (FileOutputStream fout = new FileOutputStream(filename)) {
            fout.write(data);
            fout.flush();
        }
    }
}
