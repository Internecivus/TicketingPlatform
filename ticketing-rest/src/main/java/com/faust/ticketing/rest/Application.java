package com.faust.ticketing.rest;

import javax.ws.rs.ApplicationPath;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@ApplicationPath("/api")
public class Application extends javax.ws.rs.core.Application {
    public final static String DOMAIN_NAME = "http://localhost:3000";
}
