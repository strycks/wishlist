package org.strycks.wishlist.repository;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.strycks.wishlist.model.Tag;

/** The interface Tag repository. */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
  /**
   * Find by name in list.
   *
   * @param names the names
   * @return the list
   */
  List<Tag> findByNameIn(Set<String> names);
}
