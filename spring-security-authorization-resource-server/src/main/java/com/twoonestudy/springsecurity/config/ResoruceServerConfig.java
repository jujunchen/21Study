package com.twoonestudy.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
public class ResoruceServerConfig {

    @Bean
    @Order(2)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .mvcMatcher("/userinfo/**")
                .authorizeRequests()
                .mvcMatchers("/userinfo/**").access("hasAuthority('SCOPE_userinfo')")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

}
