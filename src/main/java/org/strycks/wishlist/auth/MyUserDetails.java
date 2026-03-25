package org.strycks.wishlist.auth;

import java.util.Collection;
import java.util.Collections;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.strycks.wishlist.model.User;

/**
 * The type My user details.
 */
@Getter
@Setter
public class MyUserDetails implements UserDetails {
  private User user;

  /**
   * Instantiates a new My user details.
   *
   * @param user the user
   */
  public MyUserDetails(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public @Nullable String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getName();
  }
}
