package com.numnums021.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ROLE_EMPLOYEE = "EMPLOYEE";
    private static final String ROLE_MANAGER = "MANAGER";
    private static final String ROLE_HR = "HR";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        UserBuilder userBuilder = User.withDefaultPasswordEncoder(); // создание логина и пароля в памяти

        auth.inMemoryAuthentication().withUser(userBuilder.username("danya")
                .password("danya")
                .roles(ROLE_EMPLOYEE));

        auth.inMemoryAuthentication().withUser(userBuilder.username("anya")
                .password("anya")
                .roles(ROLE_HR));

        auth.inMemoryAuthentication().withUser(userBuilder.username("ivan")
                .password("ivan")
                .roles(ROLE_MANAGER, ROLE_HR));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasAnyRole(ROLE_EMPLOYEE, ROLE_HR, ROLE_MANAGER)
                .antMatchers("/hr_info").hasRole(ROLE_HR)
                .antMatchers("/manager_info/**").hasRole(ROLE_MANAGER)
                .and().formLogin().permitAll();
    }
}
