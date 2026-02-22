package org.strycks.wishlist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.strycks.wishlist.model.Wish;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
  private final WishlistRepository repository;

  public WishlistController(WishlistRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Wish> getAllWishes() {
    return repository.findAll();
  }

  @PostMapping
  public Wish addWish(@RequestBody Wish wish) {
    return repository.save(wish);
  }
}
