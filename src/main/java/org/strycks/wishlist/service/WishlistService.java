package org.strycks.wishlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.strycks.wishlist.repository.WishRepository;

@Service
public class WishlistService {
  @Autowired
  private WishRepository wishRepository;

  public void setWishRepository(WishRepository wishRepository) {
    this.wishRepository = wishRepository;
  }
}
