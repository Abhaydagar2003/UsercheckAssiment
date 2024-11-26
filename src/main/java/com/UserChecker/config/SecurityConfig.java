package com.UserChecker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf)->csrf.disable())
            .cors(cors->cors.disable()) 
            .authorizeHttpRequests((authorizeHttpRequests) ->authorizeHttpRequests
		        		.requestMatchers("/swagger-ui/**","/v3/api-docs/**")
		        		.permitAll()
		        		.anyRequest()
		        		.authenticated()
		        		)  
		              .httpBasic(Customizer.withDefaults());
		        return http.build();
		        }
}
