package org.strycks.wishlist.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private final JwtTokenProvider jwtTokenProvider;

  /**
   * Instantiates a new Auth controller.
   *
   * @param authenticationManager the authentication manager
   * @param jwtTokenProvider      the jwt token provider
   */
  public AuthController(
      AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider
  ) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  /**
   * Login response entity.
   *
   * @param request the request
   * @return the response entity
   */
  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody AuthRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.username, request.password));
    String token = jwtTokenProvider.generateToken(request.username);
    return ResponseEntity.ok(token);
  }

  /**
   * The type Auth request.
   */
  public static class AuthRequest {
    /**
     * The Username.
     */
    public String username;
    /**
     * The Password.
     */
    public String password;
  }
}
