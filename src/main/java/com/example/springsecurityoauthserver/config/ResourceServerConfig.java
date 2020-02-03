package com.example.springsecurityoauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  AuthenticationManager authenticationManager;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.requestMatchers().antMatchers("/login","/oauth/authorize").and().authorizeRequests()
        .anyRequest().authenticated().and().formLogin().permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.parentAuthenticationManager(authenticationManager).inMemoryAuthentication()
        .withUser("Animesh")
        .password("Animesh")
        .roles("Admin");
  }
}