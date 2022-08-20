package com.twoonestudy.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * 覆盖yml配置
 */
@Configuration
public class OAuth2LoginConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.requestMatchers().mvcMatchers("/foo");
//        return http.build();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
//        http.requestMatchers().mvcMatchers("/bar");
//        return http.build();
//    }
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return new InMemoryClientRegistrationRepository(this.giteeClientRegistration());
//    }
//
//    private ClientRegistration giteeClientRegistration() {
//        return ClientRegistration.withRegistrationId("gitee")
//                .clientId("71d5c8b12c44ed568480413da7fe5403606666caa4c4807dcd7c8dd02bf676a1")
//                .clientSecret("876ae45f43efe1ad7ba6ed5b2e677ef7834c1986d21a2a5b65a969108a2ac48c")
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
//                .authorizationUri("https://gitee.com/oauth/authorize")
//                .tokenUri("https://gitee.com/oauth/token")
//                .userInfoUri("https://gitee.com/api/v5/user")
//                .userNameAttributeName("name")
//                .clientName("Gitee")
//                .build();
//    }

    @Bean
    SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        http.oauth2Login(oauth2 -> oauth2.userInfoEndpoint(userInfo -> userInfo.userService(CustomUserService())));
        http.oauth2Client();
        return http.build();
    }

    private OAuth2UserService<OAuth2UserRequest, OAuth2User> CustomUserService() {
        final String CUSTOM = "customize";
        final CompositeOAuth2UserService compositeOAuth2UserService = new CompositeOAuth2UserService();
        compositeOAuth2UserService.getUserServiceMap().put(CUSTOM, new CustomOAuth2UserService());
        return compositeOAuth2UserService;
    }
}
