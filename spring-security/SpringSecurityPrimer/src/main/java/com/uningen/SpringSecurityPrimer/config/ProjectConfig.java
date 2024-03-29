package com.uningen.SpringSecurityPrimer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsService =
                new InMemoryUserDetailsManager();
        UserDetails user =
                User.withUsername("john")
                        .password("123456")
                        .authorities("read")
                        .build();
        userDetailsService.createUser(user);


        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().permitAll()
//                        .authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }




}
