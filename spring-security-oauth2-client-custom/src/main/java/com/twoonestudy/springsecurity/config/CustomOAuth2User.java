package com.twoonestudy.springsecurity.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

public class CustomOAuth2User implements OAuth2User {

    private final Set<GrantedAuthority> authorities;

    private final Map<String, Object> attributes;

    private final String nameAttributeKey;

    //用户信息所在的属性名
    public static final String DATA_KEY = "data";

    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes, String nameAttributeKey) {
        this.authorities = new LinkedHashSet<>(authorities);
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return (Map<String, Object>) attributes.get(DATA_KEY);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getName() {
        return this.getAttribute(this.nameAttributeKey).toString();
    }

}
