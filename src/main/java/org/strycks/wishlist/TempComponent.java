package org.strycks.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.strycks.wishlist.model.Wish;
import org.strycks.wishlist.model.WishMethod;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
    wish.getTags().add("toy");
    wish.getMethods().add(WishMethod.ORDER);
    wish.getMethods().add(WishMethod.ONLINE);
    wish.setQuantity(1);
    wish.setDeadline(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    repository.save(wish);
    Wish wish2 = wish.copy();
    repository.save(wish2);
    System.out.println(wish2.getId());
  }
}
