package com.faust.ticketing.core.configuration;

import com.faust.security.cryptography.Cryptography;
import com.faust.security.cryptography.CryptographyConfiguration;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Objects;

@Singleton
@Startup
public class PasswordResetConfiguration {
    public final static int PASSWORD_CHAR_SIZE = 28;
    public final static int TOKEN_BYTE_SIZE = 28;
    public final static char TOKEN_DELIMITER = ':';
    public final static TemporalAmount resetPasswordDuration = Duration.of(1, ChronoUnit.HOURS);

    @Getter
    private CryptographyConfiguration configuration;
    @Getter
    private Cryptography cryptography;

    @PostConstruct
    public void init() {
        try {
            configuration = new CryptographyConfiguration(49_999, "PBKDF2WithHmacSHA512", TOKEN_DELIMITER, TOKEN_BYTE_SIZE, PASSWORD_CHAR_SIZE, true);
            cryptography = new Cryptography(configuration);
        }
        catch (final Exception e) {
            throw new RuntimeException("Error creating the configuration", e);
        }
    }
}
