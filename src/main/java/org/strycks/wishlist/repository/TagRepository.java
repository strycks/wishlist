package org.strycks.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.strycks.wishlist.model.Tag;

/**
 * The interface Tag repository.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
