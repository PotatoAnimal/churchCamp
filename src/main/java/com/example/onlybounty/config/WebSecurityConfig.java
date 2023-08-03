package com.example.onlybounty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("vlad")
                .password("1")
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("1")
                .roles("KID");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/kids", "/kids/viewKid", "/kids/addNewKid", "/kids/saveKid").hasAnyRole("ADMIN", "KID") // Allow admins and kids to access these endpoints
                .antMatchers("/kids/updateInfo", "/kids/deleteKid", "/createKid").hasRole("ADMIN") // Allow admins to access these endpoints
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}