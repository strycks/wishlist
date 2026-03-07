package org.strycks.wishlist.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The type Web security config.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
  private final JwtFilter jwtFilter;

  /**
   * Instantiates a new Web security config.
   *
   * @param jwtFilter the jwt filter
   */
  public WebSecurityConfig(JwtFilter jwtFilter) {
    this.jwtFilter = jwtFilter;
  }

  /**
   * Security filter chain security filter chain.
   *
   * @param httpSecurity the http security
   * @return the security filter chain
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
    httpSecurity.csrf(csrf -> csrf.disable())
        .cors(cors -> Customizer.withDefaults())
        .authorizeHttpRequests(
            auth -> auth
                // .requestMatchers("/api/wishlist").permitAll()
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated())
        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    return httpSecurity.build();
  }

  /**
   * Password encoder password encoder.
   *
   * @return the password encoder
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * Authentication manager authentication manager.
   *
   * @param config the config
   * @return the authentication manager
   */
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
    return config.getAuthenticationManager();
  }
}
