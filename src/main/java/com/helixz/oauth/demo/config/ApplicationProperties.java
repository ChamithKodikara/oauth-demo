package com.helixz.oauth.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chamith
 */
@Data
@ConfigurationProperties("app")
@Configuration
public class ApplicationProperties {

    private Auth auth;

    private Endpoint endpoint;

    @Data
    public static class Auth {

        private String resourceId;

        private String kfName;

        private String ksPass;

        private Integer defaultAccessTokenTimeout;

        private Integer defaultRefreshTokenTimeout;

        private Integer failedLoginAttemptAccountLockTimeout;

        private Integer maxFailedLoginAttemptsForAccountLock;

    }

    @Data
    public static class Endpoint {

        private String index;

        private String testEndpoint;

    }
}
