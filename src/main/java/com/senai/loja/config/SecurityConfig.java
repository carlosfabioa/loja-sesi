package com.senai.loja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(authorize -> authorize
	            	.requestMatchers("/h2-console/**").permitAll()
	                .requestMatchers("/usuarios/login","usuarios/**", "/css/**", "/js/**").permitAll()
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .requestMatchers("/produtos", "/carrinho/**", "/home").hasAnyRole("USER", "ADMIN")
	                .anyRequest().authenticated()
	            )
	            .formLogin(form -> form
	                .loginPage("/usuarios/login")
	                .defaultSuccessUrl("/home", true)
	                .permitAll()
	            )
	            .logout(logout -> logout
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/login?logout")
	                .permitAll()
	            );
	        
	     // Configuração adicional para o H2 Console
	        http.headers().frameOptions().disable(); // Permitir que o H2 Console seja exibido no navegador
	        http.csrf().ignoringRequestMatchers("/h2-console/**"); // Desabilitar CSRF para o H2 Console

	        return http.build();
	    }
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    

}
