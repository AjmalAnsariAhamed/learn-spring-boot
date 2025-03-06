package com.practice.spring_security_6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf->csrf.disable()).authorizeHttpRequests(
                req -> req.anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();

    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails luffy= User.withUsername("luffy")
                .password("pasword")
                .roles("USER")
                .build();
        UserDetails zoro= User.withUsername("zoro")
                .password("three-swords")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(luffy,zoro);
    }

}
