package org.strycks.wishlist.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.strycks.wishlist.model.Wish;

/** The interface Wishlist repository. */
@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {
  /**
   * Find by status list.
   *
   * @param status the status
   * @return the list
   */
  List<Wish> findByStatus(String status);

  /**
   * Find all list.
   *
   * @param pageable the pageable
   * @return the list
   */
  Page<Wish> findAll(Pageable pageable);
}
