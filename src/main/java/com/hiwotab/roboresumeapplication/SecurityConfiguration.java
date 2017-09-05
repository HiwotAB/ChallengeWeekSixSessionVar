package com.hiwotab.roboresumeapplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws  Exception{
        auth.inMemoryAuthentication().
                withUser("newuser").password("newuserpa$$").roles("USER")
                .and()
                .withUser("hiwi").password("alex").roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http)throws  Exception{

          http
                .authorizeRequests()
                 // .antMatchers("/")
                  //.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                  //.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                  .antMatchers("/","/css/**","/js/**","/img/**","/font-awesome/**").permitAll()
                  .anyRequest().authenticated()
                  .and()
                  .formLogin().loginPage("/login").permitAll()
                  .and()
                  .httpBasic();

    }

}
