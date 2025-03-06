package com.practice.spring_security_6.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping(path = "/welcome")
    public String welcome(){
        return "welcome";
    }
    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest req){
return (CsrfToken) req.getAttribute("_csrf");
    }

}
