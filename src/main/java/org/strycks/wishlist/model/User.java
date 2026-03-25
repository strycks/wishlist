package org.strycks.wishlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The type User.
 */
@Entity
@Table(name = "users")
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

  /**
   * Instantiates a new User.
   */
  public User() {
  }

  // /**
  //  * Add wish.
  //  *
  //  * @param wish the wish
  //  */
  // public void addWish(Wish wish) {
  //   this.wishes.add(wish);
  //   wish.setUser(this);
  // }

  // public void removeWish(Wish wish) {
  //   this.wishes.remove(wish);
  //   wish.setUser(null);
  // }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets wishes.
   *
   * @return the wishes
   */
  // public Set<Wish> getWishes() {
  //   return wishes;
  // }
  //
  // /**
  //  * Sets wishes.
  //  *
  //  * @param wishes the wishes
  //  */
  // public void setWishes(Set<Wish> wishes) {
  //   this.wishes = wishes;
  // }

  /**
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
