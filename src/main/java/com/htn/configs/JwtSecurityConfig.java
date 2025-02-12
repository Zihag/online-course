/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.configs;

import com.htn.filters.CustomAccessDeniedHandler;
import com.htn.filters.JwtAuthenticationTokenFilter;
import com.htn.filters.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author DELL
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.htn.controllers",
    "com.htn.repository",
    "com.htn.service",
    "com.htn.components"})
@Order(1)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/api/**");
        http.authorizeRequests()
                .antMatchers("/api/login/**").permitAll()
                .antMatchers("/api/courses/**").permitAll()
                .antMatchers("/api/categories/**").permitAll()
                .antMatchers("/api/users/**").permitAll()
                .antMatchers("/api/documents/**").permitAll()
                .antMatchers("/api/lectures/**").permitAll()
                .antMatchers("/api/enrollments/**").permitAll()
                .antMatchers("/api/exercises/**").permitAll()
                .antMatchers("/api/submissions/**").permitAll()
                .antMatchers("/api/current-user").permitAll();
//                .antMatchers("/api/current-user/").authenticated()
        http.antMatcher("/api/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/categories/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT", "ROLE_TEACHER")
                .antMatchers(HttpMethod.GET, "/api/courses/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT", "ROLE_TEACHER")
                .antMatchers(HttpMethod.GET, "/api/exercises/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT", "ROLE_TEACHER")
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT", "ROLE_TEACHER")
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT", "ROLE_TEACHER")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT", "ROLE_TEACHER")
                .antMatchers(HttpMethod.POST, "/api/submissions/exercises/**/submit").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT")
                .antMatchers(HttpMethod.POST, "/api/ratings/add").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT")
                .antMatchers(HttpMethod.PUT, "/api/submissions/**").hasAnyAuthority("ROLE_TEACHER", "ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/api/exercises/add-exercise").hasAnyAuthority("ROLE_TEACHER", "ROLE_ADMIN")
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
    }

}
