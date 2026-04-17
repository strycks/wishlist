package org.strycks.wishlist.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.strycks.wishlist.dto.WishRequestDTO;
import org.strycks.wishlist.dto.WishResponseDTO;
import org.strycks.wishlist.service.WishlistService;

/** The type Wishlist controller. */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/wishlist")
@AllArgsConstructor
public class WishlistController {
  private final WishlistService wishlistService;

  /**
   * Gets all wishes.
   *
   * @return the all wishes
   */
  @GetMapping
  public ResponseEntity<List<WishResponseDTO>> getAllWishes(
      @PageableDefault(page = 0, size = 10) Pageable pageable) {
    return ResponseEntity.ok(wishlistService.getAllWishes(pageable));
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
    return ResponseEntity.status(HttpStatus.CREATED).body(wishlistService.createWish(request));
  }

  /**
   * Delete wish response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteWish(@PathVariable Long id) {
    wishlistService.deleteWish(id);
    return ResponseEntity.noContent().build();
  }

  /**
   * Replace wish response entity.
   *
   * @param id the id
   * @param request the request
   * @return the response entity
   */
  @PutMapping("/{id}")
  public ResponseEntity<WishResponseDTO> replaceWish(
      @PathVariable Long id, @RequestBody @Valid WishRequestDTO request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(wishlistService.replaceWish(id, request));
  }
}
