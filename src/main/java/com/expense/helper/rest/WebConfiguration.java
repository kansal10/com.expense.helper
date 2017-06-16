package com.expense.helper.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
// @EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter
{

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        // registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("POST",
        // "PUT", "DELETE")
        // .allowedHeaders("header1", "header2",
        // "header3").exposedHeaders("header1", "header2")
        // .allowCredentials(false).maxAge(3600);
        registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    // registry.addInterceptor(new CorsInterceptor()).addPathPatterns("/**");
    // }
}
