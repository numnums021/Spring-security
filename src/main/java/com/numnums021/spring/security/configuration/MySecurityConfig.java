package com.numnums021.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder(); // создание логина и пароля в памяти

        auth.inMemoryAuthentication().withUser(userBuilder.username("danya")
                .password("danya")
                .roles("EMPLOYEE"));

        auth.inMemoryAuthentication().withUser(userBuilder.username("anya")
                .password("anya")
                .roles("HR"));

        auth.inMemoryAuthentication().withUser(userBuilder.username("ivan")
                .password("ivan")
                .roles("MANAGER", "HR"));
    }
}