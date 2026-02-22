package org.strycks.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.strycks.wishlist.model.Wish;

@Component
public class TempComponent implements ApplicationRunner {

  private WishlistRepository repository;

  @Autowired
  public void setRepository(WishlistRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Wish wish = new Wish();
    wish.setName("Sylvanian");
    wish.setMeter(1);
    wish.setPrice(125000L);
    wish.getTags().add("sylvanian");
    wish.setQuantity(1);
    repository.save(wish);
  }
}
