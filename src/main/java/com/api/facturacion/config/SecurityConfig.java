package com.api.facturacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/api/v1/**").permitAll()  // Permitir acceso sin autenticación a estas rutas
//                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Requiere rol ADMIN
//                        .anyRequest().authenticated()  // Requiere autenticación para cualquier otra solicitud
                );
        return http.build();
    }
}