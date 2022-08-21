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

    //重点，registrationId -> OAuth2UserService实现
    private Map<String, OAuth2UserService> userServiceMap = new ConcurrentHashMap<>();

    //默认OAuth2UserService实现
    private static final String DEFAULT_KEY = "default_key";

    public CompositeOAuth2UserService() {
        //初始化一个默认值
        userServiceMap.put(DEFAULT_KEY, new DefaultOAuth2UserService());
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        //根据注册客户端id获取对于的OAuth2UserService实现
        OAuth2UserService service = userServiceMap.get(clientRegistration.getRegistrationId());
        //没有获取到自定义的，使用默认实现
        if (service == null) {
            service = userServiceMap.get(DEFAULT_KEY);
        }
        //调用loadUser
        return service.loadUser(userRequest);
    }

    public Map<String, OAuth2UserService> getUserServiceMap() {
        return this.userServiceMap;
    }
}
