package org.strycks.wishlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type User.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private String password;

  // @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
  // private Set<Wish> wishes = new HashSet<>();

  // public void addWish(Wish wish) {
  //   this.wishes.add(wish);
  //   wish.setUser(this);
  // }

  // public void removeWish(Wish wish) {
  //   this.wishes.remove(wish);
  //   wish.setUser(null);
  // }
}
