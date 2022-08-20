package com.twoonestudy.springsecurity.config;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 监听授权认证成功事件
 */
@Component
public class SpringSecurityEventListener {

    @EventListener(InteractiveAuthenticationSuccessEvent.class)
    public void authenticationSuccessEventListener(InteractiveAuthenticationSuccessEvent event) {
        Authentication authentication = event.getAuthentication();
        System.out.println(authentication.getName());
    }
}
