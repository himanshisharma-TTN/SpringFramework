package com.spring_security;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/public").permitAll()
                .anyRequest().authenticated();
    }
}