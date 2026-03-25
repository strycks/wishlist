package org.strycks.wishlist.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * The type Jwt token provider.
 */
@Component
public class JwtTokenProvider {
  private final String JWT_SECRET = "tXHzZyrglpWqIgfONgcI+gsoCnXKhFFRsFsLtfx0JqU=";
  private final long JWT_EXPIRATION = 60L * 60 * 24 * 1000 * 1000;

  private Key getSigningKey() {
    return Keys.hmacShaKeyFor(JWT_SECRET.getBytes());
  }

  /**
   * Generate token string.
   *
   * @param username the username
   * @return the string
   */
  public String generateToken(String username) {
    return Jwts.builder()
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  /**
   * Extract username string.
   *
   * @param token the token
   * @return the string
   */
  public String extractUsername(String token) {
    return Jwts.parser().setSigningKey(getSigningKey()).build()
        .parseSignedClaims(token).getPayload().getSubject();
  }

  /**
   * Validate token boolean.
   *
   * @param token the token
   * @return the boolean
   */
  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(getSigningKey()).build().parseSignedClaims(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
