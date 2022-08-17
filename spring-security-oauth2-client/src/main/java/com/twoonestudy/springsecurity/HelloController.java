package com.twoonestudy.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Principal principal) {
        return "Hello," + principal.getName();
    }

    @GetMapping("/foo")
    public String foo(Principal principal) {
        return "Hello," + principal.getName();
    }

    @GetMapping("/bar")
    public String bar(Principal principal) {
        return "Hello";
    }
}
