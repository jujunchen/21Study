package com.twoonestudy.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity(debug = true)
@SpringBootApplication
public class SpringSecurityAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAuthorizationServerApplication.class, args);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode("myPassword");
        System.out.println(System.currentTimeMillis());
        assert(encoder.matches("myPassword", result));
        System.out.println(System.currentTimeMillis());
    }

}
