package com.parishapp.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() } // disable CSRF for dev
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers(
                        "/hello",
                        "/users/register",
                    ).permitAll() // public endpoint
                    .anyRequest().authenticated() // everything else still secured
            }
            .httpBasic { } // keep basic auth for others
        return http.build()
    }
}
