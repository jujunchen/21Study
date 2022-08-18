package com.twoonestudy.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity(debug = true)
@SpringBootApplication
public class AuthorizationResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationResourceServerApplication.class, args);
    }

}
