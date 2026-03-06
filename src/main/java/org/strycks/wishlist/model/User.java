package org.strycks.wishlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "users", orphanRemoval = true, cascade = CascadeType.MERGE)
  private Set<Wish> wishes = new HashSet<>();

  public User() {
  }

  public void addWish(Wish wish) {
    this.wishes.add(wish);
    wish.setUser(this);
  }

  public void removeWish(Wish wish) {
    this.wishes.remove(wish);
    wish.setUser(null);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Wish> getWishes() {
    return wishes;
  }

  public void setWishes(Set<Wish> wishes) {
    this.wishes = wishes;
  }
}
