package org.strycks.wishlist.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.strycks.wishlist.dto.WishRequestDTO;
import org.strycks.wishlist.dto.WishResponseDTO;
import org.strycks.wishlist.model.Wish;
import org.strycks.wishlist.repository.UserRepository;
import org.strycks.wishlist.repository.WishRepository;
import org.strycks.wishlist.service.WishlistService;

/**
 * The type Wishlist controller.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
  private final WishlistService wishlistService;

  /**
   * Instantiates a new Wishlist controller.
   *
   * @param wishlistService the wishlist service
   */
  public WishlistController(WishlistService wishlistService) {
    this.wishlistService = wishlistService;
  }

  /**
   * Gets all wishes.
   *
   * @return the all wishes
   */
  @GetMapping
  public ResponseEntity<List<WishResponseDTO>> getAllWishes() {
    return ResponseEntity.ok(wishlistService.getAllWishes());
  }

  /**
   * Gets wish.
   *
   * @param id the id
   * @return the wish
   */
  @GetMapping("/{id}")
  public ResponseEntity<WishResponseDTO> getWish(@PathVariable Long id) {
    return ResponseEntity.ok(wishlistService.getWish(id));
  }


  /**
   * Add wish.
   *
   * @param request the request
   * @return the wish response dto
   */
  @PostMapping
  public ResponseEntity<WishResponseDTO> addWish(@RequestBody @Valid WishRequestDTO request) {
    return ResponseEntity.ok(wishlistService.createWish(request));
  }
}
