package org.strycks.wishlist.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.strycks.wishlist.model.User;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  /**
   * Find by name optional.
   *
   * @param name the name
   * @return the optional
   */
  Optional<User> findByName(String name);
}
