package com.learnwithiftekhar.auditing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req.anyRequest().authenticated()
                ).formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager users() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}password")
                .roles("USER")
                .build();



        UserDetails jane = User.builder()
                .username("jane")
                .password("{noop}password")
                .roles("USER")
                .build();



        return new InMemoryUserDetailsManager(
                john, jane
        );
    }


    @Bean
    public AuditorAware<String> auditorAware() {
        return new ApplicationAuditAware();
    }

}
