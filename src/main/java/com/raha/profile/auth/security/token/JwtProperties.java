package com.raha.profile.auth.security.token;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties("jwt")
public class JwtProperties {

    private String secret;
    private String issuer;
    private TokenProps access;
    private TokenProps refresh;

    @Getter
    @Setter
    public static class TokenProps {
        private Integer expiration;
    }
}

