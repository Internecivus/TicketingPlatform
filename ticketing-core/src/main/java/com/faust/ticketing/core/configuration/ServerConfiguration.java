package com.faust.ticketing.core.configuration;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class ServerConfiguration {
    public final static Charset CHARSET = StandardCharsets.UTF_8;
    public final static String CHARSET_NAME = CHARSET.name();
    public final static String DOMAIN_NAME = "http://localhost:3000";
}
