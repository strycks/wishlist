package org.strycks.wishlist.auth;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.strycks.wishlist.model.User;
import org.strycks.wishlist.repository.UserRepository;

/** The type My user details service. */
@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByName(username);
    if (user.isPresent()) {
      return new MyUserDetails(user.get());
    } else {
      throw new UsernameNotFoundException(username);
    }
  }
}
