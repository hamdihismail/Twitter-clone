package org.ac.cst8277.ismail.hamdi.ums.config;

import org.ac.cst8277.ismail.hamdi.ums.filter.JwtAuthenticationFilter;
import org.ac.cst8277.ismail.hamdi.ums.model.User;
import org.ac.cst8277.ismail.hamdi.ums.repository.UserRepository;
import org.ac.cst8277.ismail.hamdi.ums.service.JwtTokenService;
import org.ac.cst8277.ismail.hamdi.ums.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final UserDetailsServiceImp userDetailsServiceImp;
	@Autowired
	private UserRepository userRepository;
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	private final JwtTokenService jwtTokenService;

	public SecurityConfig(UserDetailsServiceImp userDetailsServiceImp, JwtAuthenticationFilter jwtAuthenticationFilter, JwtTokenService jwtTokenService) {
		this.userDetailsServiceImp = userDetailsServiceImp;
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.jwtTokenService = jwtTokenService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.oauth2Login(oauth2 -> oauth2
                        .successHandler(authenticationSuccessHandler())
                )
				.authorizeHttpRequests(
							req->req.requestMatchers("/login/**","/register/**","/home**")
							.permitAll()
							.requestMatchers("/api/users/**").hasAuthority("ADMIN")
							.anyRequest()
							.authenticated()
				)
				.userDetailsService(userDetailsServiceImp)
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
				.build()
				;
		
	}
	
	@Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, java.io.IOException {
                // Generate JWT Token
            	User user = userRepository.findByUsername("TesterPro").orElseThrow();
                String jwtToken = jwtTokenService.generateToken(user);
                System.out.println("JWT Token: " + jwtToken);

                // Set the JWT token in the response header (Optional)
                response.setHeader("Authorization", "Bearer " + jwtToken);

                // Redirect to a specific page or return a JSON response
                response.sendRedirect("http://localhost:8090/home"); 
                System.out.println("JWT Token: " + jwtToken);
            }
        };
    }
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
}
