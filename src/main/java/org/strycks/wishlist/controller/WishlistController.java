package org.strycks.wishlist.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.strycks.wishlist.model.Wish;
import org.strycks.wishlist.repository.WishRepository;

/**
 * The type Wishlist controller.
 */
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
  private final WishRepository repository;

  /**
   * Instantiates a new Wishlist controller.
   *
   * @param repository the repository
   */
  public WishlistController(WishRepository repository) {
    this.repository = repository;
  }

  /**
   * Gets all wishes.
   *
   * @return the all wishes
   */
  @GetMapping
  public List<Wish> getAllWishes() {
    return repository.findAll();
  }

  /**
   * Gets wish.
   *
   * @param id the id
   * @return the wish
   */
  @GetMapping("/{id}")
  public Optional<Wish> getWish(@PathVariable Long id) {
    return repository.findById(id);
  }

  /**
   * Add wish wish.
   *
   * @param wish the wish
   * @return the wish
   */
  @PostMapping
  public Wish addWish(@RequestBody Wish wish) {
    return repository.save(wish);
  }
}
