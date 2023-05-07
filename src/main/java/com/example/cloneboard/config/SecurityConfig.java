package com.example.cloneboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/board", "/loginUser/true").hasRole("USER") // 접근 허용된 사용자만 접근 가능
                .antMatchers( "/user/**", "/loginUser").permitAll() // 모든 사용자 접근 허용
                //.antMatchers("/", "/board").authenticated()
                .and()
                .formLogin().disable()
                    // 로그인 페이지를 제공하는 URL을 설정함
//                    .loginPage("/loginUser")
                    //.defaultSuccessUrl("/login/true")
                .logout()
                    .permitAll()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/access-denied") // 권한이 없는 경우 이동할 URL
                .and()
                    .httpBasic();
    }
}