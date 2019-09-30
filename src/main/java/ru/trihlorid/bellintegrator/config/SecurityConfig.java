package ru.trihlorid.bellintegrator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ru.trihlorid.bellintegrator.controller.StoreController;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(StoreController.FIND_PRODUCT).hasAnyRole("USER", "ADMIN")
                .antMatchers(StoreController.FIND_HEELS).hasAnyRole("USER", "ADMIN")
                .antMatchers(StoreController.ADD_PRODUCT).hasRole("ADMIN")
                .antMatchers(StoreController.DELETE_PRODUCT).hasRole("ADMIN")
                .antMatchers(StoreController.REWRITE_PRODUCT).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}