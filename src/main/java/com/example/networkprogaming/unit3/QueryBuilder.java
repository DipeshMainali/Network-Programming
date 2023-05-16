package com.example.networkprogaming.unit3;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-01
 **/
public class QueryBuilder {
    private final StringBuilder query = new StringBuilder();
    public QueryBuilder() {
    }
    public void add(String name, String value) {
        query.append('&');
        encode(name, value);
    }
    private void encode(String name, String value) {
        query.append(URLEncoder.encode(name, StandardCharsets.UTF_8));
        query.append('=');
        query.append(URLEncoder.encode(value, StandardCharsets.UTF_8));
    }
    public String getQuery() {
        return query.toString();
    }
    @Override
    public String toString() {
        return getQuery();
    }
}
