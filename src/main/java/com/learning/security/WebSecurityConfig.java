package com.learning.security;

import com.learning.service.impl.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/enroll/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/student/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/course/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/enroll/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/student/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/course/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/user/auth/add");  //lets assume this is the registration login page to add new users
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userAuthService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authProvider;
    }
}
