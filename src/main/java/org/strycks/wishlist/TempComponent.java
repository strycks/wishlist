package org.strycks.wishlist;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Set;
import javax.swing.text.html.HTML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.strycks.wishlist.controller.WishlistController;
import org.strycks.wishlist.model.Tag;
import org.strycks.wishlist.model.User;
import org.strycks.wishlist.model.Wish;
import org.strycks.wishlist.model.WishMethod;
import org.strycks.wishlist.repository.TagRepository;
import org.strycks.wishlist.repository.UserRepository;
import org.strycks.wishlist.repository.WishRepository;

/**
 * The type Temp component.
 */
@Component
public class TempComponent implements ApplicationRunner {

  private WishRepository repository;
  private TagRepository tagRepository;
  private UserRepository userRepository;

  /**
   * Sets repository.
   *
   * @param repository the repository
   */
  @Autowired
  public void setRepository(WishRepository repository) {
    this.repository = repository;
  }

  /**
   * Sets tag repository.
   *
   * @param tagRepository the tag repository
   */
  @Autowired
  public void setTagRepository(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  /**
   * Sets user repository.
   *
   * @param userRepository the user repository
   */
  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Wish wish = new Wish();
    wish.setName("Sylvanian");
    wish.setMeter(1);
    wish.setPrice(125000L);
    Tag tag = new Tag();
    tag.setName("Sylvanian");
    Tag tag2 = new Tag();
    tag2.setName("toy");
    wish.addTag(tag);
    wish.addTag(tag2);
    wish.getMethods().add(WishMethod.ORDER);
    wish.getMethods().add(WishMethod.ONLINE);
    wish.setQuantity(1);
    wish.setDeadline(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    Wish wish2 = wish.copy();
    wish2.removeTag(tag2);
    tagRepository.save(tag);
    tagRepository.save(tag2);
    repository.save(wish2);
    repository.save(wish);
    User user = new User();
    user.setName("a");
    user.setPassword("$2a$12$cbwjBUZlQf0IojmsmeLUKuZ2C4KCtnPD4m6bVO6vgZaJKeYy97giy");
    userRepository.save(user);
    User user2 = new User();
    user2.setName("b");
    user2.setPassword("$2a$12$W0Upi/SZQGC0RjBVqa6G.er1Xl8UmGAB8Dbn8vDodjk8gl8RMpmBO");
    userRepository.save(user2);

    for (Wish x : repository.findAll()) {
      System.out.println(x.getName());
    }
  }
}
