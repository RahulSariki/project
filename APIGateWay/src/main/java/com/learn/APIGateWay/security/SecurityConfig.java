package com.learn.APIGateWay.security;

import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    // Injects the custom filter we created to parse tokens
    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .authorizeExchange(exchange -> exchange

                        .pathMatchers("/auth/register", "/auth/login").permitAll()

                        .pathMatchers("/hotels/**").hasAnyRole("HOTEL_OWNER", "ADMIN")

                        .pathMatchers("/rooms/**").hasAnyRole("HOTEL_OWNER", "ADMIN")

                        .pathMatchers("/availability/**").hasAnyRole("CUSTOMER", "HOTEL_OWNER", "ADMIN")

                        .pathMatchers("/bookings/**").hasAnyRole("CUSTOMER", "ADMIN")

                        .pathMatchers("/payments/**").hasAnyRole("CUSTOMER", "ADMIN")

                        .pathMatchers("/reviews/**").hasAnyRole("CUSTOMER", "ADMIN")

                        .pathMatchers("/notifications/**").hasAnyRole("CUSTOMER", "HOTEL_OWNER", "ADMIN")

                        .anyExchange().authenticated()
                )
                .build();
    }
}