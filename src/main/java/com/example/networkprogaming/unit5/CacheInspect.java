package com.example.networkprogaming.unit5;

import java.util.Date;
import java.util.Locale;

/**
 * @Author: Dipesh Mainali
 * @Date: 2023-05-23
 **/
public class CacheInspect {
    private Date maxAge = null;
    private Date sMaxAge = null;
    private boolean mustRevalidate = false;
    private boolean noCache = false;
    private boolean noStore = false;
    private boolean proxyRevalidate = false;
    private boolean publicCache = false;
    private boolean privateCache = false;
    public CacheInspect(String s) {
        if (s == null || !s.contains(":")) {
            return; // default policy
        }
        String value = s.split(":")[1].trim();
        String[] components = value.split(",");
        Date now = new Date();
        for (String component : components) {
            try {
                component = component.trim().toLowerCase(Locale.US);
                if (component.startsWith("max-age=")) {
                    int secondsInTheFuture = Integer.parseInt(component.substring(8));
                    maxAge = new Date(now.getTime() + 1000L * secondsInTheFuture);
                } else if (component.startsWith("s-maxage=")) {
                    int secondsInTheFuture = Integer.parseInt(component.substring(8));
                    sMaxAge = new Date(now.getTime() + 1000L * secondsInTheFuture);
                } else if (component.equals("must-revalidate")) {
                    mustRevalidate = true;
                } else if (component.equals("proxy-revalidate")) {
                    proxyRevalidate = true;
                } else if (component.equals("no-cache")) {
                    noCache = true;
                } else if (component.equals("public")) {
                    publicCache = true;
                } else if (component.equals("private")) {
                    privateCache = true;
                } else if (component.equals("no-store")) {
                    noStore = true;
                }
            } catch (RuntimeException ignore) {}
        }
    }
    public Date getMaxAge() {
        return maxAge;
    }
    public Date getSharedMaxAge() {
        return sMaxAge;
    }
    public boolean mustRevalidate() {
        return mustRevalidate;
    }
    public boolean proxyRevalidate() {
        return proxyRevalidate;
    }
    public boolean noStore() {
        return noStore;
    }
    public boolean noCache() {
        return noCache;
    }
    public boolean publicCache() {
        return publicCache;
    }
    public boolean privateCache() {
        return privateCache;
    }
}
