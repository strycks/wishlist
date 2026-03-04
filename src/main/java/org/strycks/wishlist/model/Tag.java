package org.strycks.wishlist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Tag.
 */
@Entity
@Table(name = "tags")
public class Tag {
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name = "lorem ipsum";

  @JsonIgnore
  @ManyToMany(mappedBy = "tags")
  private Set<Wish> wishes = new HashSet<>();

  /**
   * Instantiates a new Tag.
   */
  public Tag() {
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
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
  public Set<Wish> getWishes() {
    return wishes;
  }

  /**
   * Sets wishes.
   *
   * @param wishes the wishes
   */
  public void setWishes(Set<Wish> wishes) {
    this.wishes = wishes;
  }
}
