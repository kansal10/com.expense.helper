package com.expense.helper.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = { ErrorMvcAutoConfiguration.class })
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class ExpenseHelperSpringBootWebApplication extends SpringBootServletInitializer
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(ExpenseHelperSpringBootWebApplication.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(ExpenseHelperSpringBootWebApplication.class, args);
    }
}
