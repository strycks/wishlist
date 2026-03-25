package org.strycks.wishlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Wish.
 */
@Entity
@Table(name = "wishes")
@NoArgsConstructor
@Getter
@Setter
public class Wish {
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name = "lorem ipsum";

  @Column(nullable = false)
  private Long price = -1L;

  private String note;

  @Column(nullable = false)
  private Integer meter = 0;

  @Column(nullable = false)
  private Integer quantity = 1;

  private String about;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private WishStatus status = WishStatus.PENDING;

  private LocalDateTime deadline;

  private LocalDateTime creationDate = LocalDateTime.now();

  // @ManyToOne
  // @JoinColumn(name = "user", nullable = true)
  // private User user;

  @ManyToMany(cascade = {CascadeType.MERGE})
  @JoinTable(
      name = "wish_tags",
      joinColumns = @JoinColumn(name = "wish_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private Set<Tag> tags = new HashSet<>();

  @ElementCollection
  @Enumerated(EnumType.STRING)
  @CollectionTable(
      name = "wish_conditions",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "`condition`")
  private Set<WishCondition> conditions = new HashSet<>(List.of(WishCondition.NEW));

  // multivalued attribute, create an immediate table named "wish_urls"
  // has two columns, "wish_id" referencing "id" and "url".
  @ElementCollection
  @CollectionTable(
      name = "wish_urls",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "url", columnDefinition = "TEXT")
  private Set<String> urls = new HashSet<>();

  @ElementCollection
  @CollectionTable(
      name = "wish_retailers",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "retailer")
  private Set<String> retailers = new HashSet<>();

  @ElementCollection
  @Enumerated(EnumType.STRING)
  @CollectionTable(
      name = "wish_methods",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "method")
  private Set<WishMethod> methods = new HashSet<>(List.of(WishMethod.ONLINE));

  /**
   * Deep copy.
   *
   * @return the wish
   */
  public Wish copy() {
    Wish wish = new Wish();
    wish.setName(name);
    wish.setPrice(price);
    wish.setNote(note);
    wish.setMeter(meter);
    wish.setQuantity(quantity);
    wish.setStatus(status);
    wish.setAbout(about);
    wish.setDeadline(deadline);
    for (Tag tag : tags) {
      wish.addTag(tag);
    }
    wish.setConditions(new HashSet<>(conditions));
    wish.setUrls(new HashSet<>(urls));
    wish.setRetailers(new HashSet<>(retailers));
    wish.setMethods(new HashSet<>(methods));
    return wish;
  }

  /**
   * Remove a tag from the current wish.
   *
   * @param tag the tag
   */
  public void removeTag(Tag tag) {
    this.tags.remove(tag);
    tag.getWishes().remove(this);
    // System.err.println(tag.getWishes().size() + " " + tags.size());
  }

  /**
   * Add a tag to the current wish.
   *
   * @param tag the tag
   */
  public void addTag(Tag tag) {
    this.tags.add(tag);
    tag.getWishes().add(this);
    // System.err.println(tag.getWishes().size() + " " + tags.size());
  }
}
