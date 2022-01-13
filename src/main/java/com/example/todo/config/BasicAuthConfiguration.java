//package com.example.todo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableWebSecurity
////public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {
////
////    @Autowired
////    private DataSource dataSource;
////
////    @Autowired
////    private UserDetailsService userDetailsService;
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        try {
////            auth.userDetailsService(userDetailsService);
////        } catch (Exception e) {
////            e.printStackTrace();
////            throw e;
////        }
////    }
////
////    @Override
////    public void configure(HttpSecurity http) throws Exception{
////        http.authorizeRequests().anyRequest()
////                .authenticated()
////                .and()
////                .httpBasic();
////    }
////
////    @Override
////    public UserDetailsService userDetailsService() {
////        return userDetailsService;
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder(){
////        return new BCryptPasswordEncoder();
////    }
////}