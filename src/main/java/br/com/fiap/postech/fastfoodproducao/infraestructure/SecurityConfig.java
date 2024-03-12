package br.com.fiap.postech.fastfoodproducao.infraestructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.authorizeRequests()
                .requestMatchers(HttpMethod.GET, "/**").permitAll()
                 .and()
                 .csrf().disable();

        http.headers()
                .addHeaderWriter(new StaticHeadersWriter("Content-Security-Policy", "default-src 'self'"))
                .addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "default-src 'self'"))
                .addHeaderWriter(new StaticHeadersWriter("X-WebKit-CSP", "default-src 'self'"))
                .referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN);

        return http.build();
    }
}