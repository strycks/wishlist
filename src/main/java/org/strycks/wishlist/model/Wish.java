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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Wish.
 */
@Entity
@Table(name = "wishes")
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
  private String status = "PENDING";

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
  @Column(name = "url")
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
   * Instantiates a new Wish.
   */
  public Wish() {
  }

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
    System.err.println(tag.getWishes().size() + " " + tags.size());
  }

  /**
   * Add a tag to the current wish.
   *
   * @param tag the tag
   */
  public void addTag(Tag tag) {
    this.tags.add(tag);
    tag.getWishes().add(this);
    System.err.println(tag.getWishes().size() + " " + tags.size());
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
   * Gets status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public Long getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(Long price) {
    this.price = price;
  }

  /**
   * Gets note.
   *
   * @return the note
   */
  public String getNote() {
    return note;
  }

  /**
   * Sets note.
   *
   * @param note the note
   */
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * Gets meter.
   *
   * @return the meter
   */
  public Integer getMeter() {
    return meter;
  }

  /**
   * Sets meter.
   *
   * @param meter the meter
   */
  public void setMeter(Integer meter) {
    this.meter = meter;
  }

  /**
   * Gets quantity.
   *
   * @return the quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * Sets quantity.
   *
   * @param quantity the quantity
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  /**
   * Gets about.
   *
   * @return the about
   */
  public String getAbout() {
    return about;
  }

  /**
   * Sets about.
   *
   * @param about the about
   */
  public void setAbout(String about) {
    this.about = about;
  }

  /**
   * Gets tags.
   *
   * @return the tags
   */
  public Set<Tag> getTags() {
    return tags;
  }

  /**
   * Sets tags.
   *
   * @param tags the tags
   */
  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  /**
   * Gets conditions.
   *
   * @return the conditions
   */
  public Set<WishCondition> getConditions() {
    return conditions;
  }

  /**
   * Sets conditions.
   *
   * @param conditions the conditions
   */
  public void setConditions(Set<WishCondition> conditions) {
    this.conditions = conditions;
  }

  /**
   * Gets urls.
   *
   * @return the urls
   */
  public Set<String> getUrls() {
    return urls;
  }

  /**
   * Sets urls.
   *
   * @param urls the urls
   */
  public void setUrls(Set<String> urls) {
    this.urls = urls;
  }

  /**
   * Gets retailers.
   *
   * @return the retailers
   */
  public Set<String> getRetailers() {
    return retailers;
  }

  /**
   * Sets retailers.
   *
   * @param retailer the retailer
   */
  public void setRetailers(Set<String> retailer) {
    this.retailers = retailer;
  }

  /**
   * Gets methods.
   *
   * @return the methods
   */
  public Set<WishMethod> getMethods() {
    return methods;
  }

  /**
   * Sets methods.
   *
   * @param methods the methods
   */
  public void setMethods(Set<WishMethod> methods) {
    this.methods = methods;
  }

  /**
   * Gets deadline.
   *
   * @return the deadline
   */
  public LocalDateTime getDeadline() {
    return deadline;
  }

  /**
   * Sets deadline.
   *
   * @param deadline the deadline
   */
  public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
  }

  /**
   * Gets creation date.
   *
   * @return the creation date
   */
  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  /**
   * Sets creation date.
   *
   * @param creationDate the creation date
   */
  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  // /**
  //  * Gets user.
  //  *
  //  * @return the user
  //  */
  // public User getUser() {
  //   return user;
  // }
  //
  // /**
  //  * Sets user.
  //  *
  //  * @param user the user
  //  */
  // public void setUser(User user) {
  //   this.user = user;
  // }
}
