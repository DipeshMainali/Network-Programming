package com.example.networkprogaming.unit3;


import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-01
 **/
public class UrlEncoding {
//   1. non‐alphanumeric characters are converted into % sequences
//            (except the space, underscore, hyphen, period, and asterisk characters)
//   2. also encodes all non-ASCII characters
//   3. space is converted into a plus sign
//   4. also converts tildes, single quotes, exclamation points, and parentheses to percent escapes





//    1. The capital letters A–Z
//    2. The lowercase letters a–z
//    3. The digits 0–9
//    4. The punctuation characters - _ . ! ~ * ' (and ,)


    //        / & ? @ # ; $ + = and %

    public static void main(String[] args) {
        try {
//            URLEncoder.encode("This string has spaces", "UTF-8");

            System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
            System.out.println(URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
            System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
            System.out.println(URLEncoder.encode("This+string+has+pluses", "UTF-8"));
            System.out.println(URLEncoder.encode("This/string/has/slashes", "UTF-8"));
            System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
            System.out.println(URLEncoder.encode("This:string:has:colons", "UTF-8"));
            System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-8"));
            System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-8"));
            System.out.println(URLEncoder.encode("This.string.has.periods", "UTF-8"));
            System.out.println(URLEncoder.encode("This=string=has=equals=signs", "UTF-8"));
            System.out.println(URLEncoder.encode("This&string&has&ampersands", "UTF-8"));
            System.out.println(URLEncoder.encode("Thiséstringéhasé non-ASCII characters",
                    StandardCharsets.UTF_8));

            String input = "";
            String output = URLDecoder.decode(input, StandardCharsets.UTF_8);
            System.out.println(output);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }
    }

    public static void encodeByPart() throws UnsupportedEncodingException {
        String url = "https://www.google.com/search?";
        url += URLEncoder.encode("hl", "UTF-8");
        url += "=";
        url += URLEncoder.encode("en", "UTF-8");
        url += "&";
        url += URLEncoder.encode("as_q", "UTF-8");
        url += "=";
        url += URLEncoder.encode("Java", "UTF-8");
        url += "&";
        url += URLEncoder.encode("as_epq", "UTF-8");
        url += "=";
        url += URLEncoder.encode("I/O", "UTF-8");
        System.out.println(url);
    }

    public static void encodeByPartUsingClass() {
        QueryBuilder qs = new QueryBuilder();
        qs.add("hl", "en");
        qs.add("as_q", "Java");
        qs.add("as_epq", "I/O");
        String url = "http://www.google.com/search?" + qs;
        System.out.println(url);
    }
}