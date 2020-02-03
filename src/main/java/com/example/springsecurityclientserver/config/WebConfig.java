package com.example.springsecurityclientserver.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@Component
public class WebConfig implements WebMvcConfigurer {

 /* @Override
 public void configureDefaultSerServletHandling(DefaultServletHandlerConfigurer configurer)
  {
    configurer.enable();
  }*/

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {

    registry.addViewController("/")
        .setViewName(":/");
    registry.addViewController("/index");
    registry.addViewController("/secure");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resource");
  }

  @Bean
  public  static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
  {
    return  new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public RequestContextListener requestContextListener()
  {
    return new RequestContextListener();
  }
}
