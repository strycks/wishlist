package org.strycks.wishlist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.strycks.wishlist.model.Wish;

@Repository
public interface WishlistRepository extends JpaRepository<Wish, Long> {
  List<Wish> findByStatus(String status);
}
