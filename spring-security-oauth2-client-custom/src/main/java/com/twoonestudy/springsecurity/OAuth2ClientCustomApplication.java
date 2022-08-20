package com.twoonestudy.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity(debug = true)
@SpringBootApplication
public class OAuth2ClientCustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ClientCustomApplication.class, args);
    }

}
