package com.example.networkprogaming.unit5;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-23
 **/
public class ConfigConnection {
//    protected URL url;
//    protected boolean doInput = true;
//    protected boolean doOutput = false;
//    protected boolean allowUserInteraction = defaultAllowUserInteraction;
//    protected boolean useCaches = defaultUseCaches;
//    protected long ifModifiedSince = 0;
//    protected boolean connected = false;

    public void getUrl() throws IOException {
        URL u = new URL("http://www.oreilly.com/");
        URLConnection uc = u.openConnection();
        System.out.println(uc.getURL());


        uc.setRequestProperty("key", "value");
        uc.addRequestProperty("key", "value");

        uc.getPermission();

        URLConnection.guessContentTypeFromName("name");
        URLConnection.guessContentTypeFromStream(uc.getInputStream());
    }

    public void writingData() throws IOException {
        URL u = new URL("http://www.somehost.com/cgi-bin/acgi");
// open the connection and prepare it to POST
        URLConnection uc = u.openConnection();
        uc.setDoOutput(true);
        OutputStream raw = uc.getOutputStream();
        OutputStream buffered = new BufferedOutputStream(raw);
        OutputStreamWriter out = new OutputStreamWriter(buffered, StandardCharsets.ISO_8859_1);
        out.write("first=Julie&middle=&last=Harting&work=String+Quartet\r\n");
        out.flush();
        out.close();
    }


    public void httpConnection(String url) throws IOException {
        URL u = new URL(url);
        HttpURLConnection http = (HttpURLConnection) u.openConnection();
        http.setRequestMethod("HEAD");
        System.out.println(u + " was last modified at " + new Date(http.getLastModified()));
    }


    public void handleResponse(String url) {
        try {
            URL u = new URL(url);
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
//            uc.getInstanceFollowRedirects();
//            uc.setInstanceFollowRedirects(false);
//
//            HttpURLConnection.getFollowRedirects();
//            HttpURLConnection.setFollowRedirects(true);

            try (InputStream raw = uc.getInputStream()) {
                printFromStream(raw);
            } catch (IOException ex) {
                printFromStream(uc.getErrorStream());
            }
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    private void printFromStream(InputStream raw) throws IOException {
        try (InputStream buffer = new BufferedInputStream(raw)) {
            Reader reader = new InputStreamReader(buffer);
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
// getFollowRedirects()
    //getInstanceFollowRedirects()
    // setChunkedStreamingMode(int)
    // setFixedLengthStreamingMode(int)



    public Date socketRead() throws IOException, ParseException {
        try (Socket socket = new Socket("time.nist.gov", 13)) {
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, StandardCharsets.US_ASCII);
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            return parseDate(time.toString());
        }
    }
    static Date parseDate(String s) throws ParseException {
        String[] pieces = s.split(" ");
        String dateTime = pieces[1] + " " + pieces[2] + " UTC";
        DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
        return format.parse(dateTime);
    }
}
