package com.twoonestudy.springsecurity.config;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 多个三方登录共存
 */
public class CompositeOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private Map<String, OAuth2UserService> userServiceMap = new ConcurrentHashMap<>();

    private static final String DEFAULT_KEY = "default_key";

    public CompositeOAuth2UserService() {
        userServiceMap.put(DEFAULT_KEY, new DefaultOAuth2UserService());
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        OAuth2UserService service = userServiceMap.get(clientRegistration.getRegistrationId());
        if (service == null) {
            service = userServiceMap.get(DEFAULT_KEY);
        }
        return service.loadUser(userRequest);
    }

    public Map<String, OAuth2UserService> getUserServiceMap() {
        return this.userServiceMap;
    }
}
