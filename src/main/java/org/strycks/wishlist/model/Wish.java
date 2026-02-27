package org.strycks.wishlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Wish.
 */
@Entity
@Table(name = "wish")
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

  // multivalued attribute, create an immediate table named "wish_tag"
  // has two columns, "wish_id" referencing "id" and "tag".
  @ElementCollection
  @CollectionTable(
      name = "wish_tag",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "tag")
  private List<String> tags = new ArrayList<>();

  @ElementCollection
  @Enumerated(EnumType.STRING)
  @CollectionTable(
      name = "wish_condition",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "condition")
  private List<WishCondition> conditions = new ArrayList<>(List.of(WishCondition.NEW));

  @ElementCollection
  @CollectionTable(
      name = "wish_url",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "url")
  private List<String> urls = new ArrayList<>();

  @ElementCollection
  @CollectionTable(
      name = "wish_retailer",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "retailer")
  private List<String> retailers = new ArrayList<>();

  @ElementCollection
  @Enumerated(EnumType.STRING)
  @CollectionTable(
      name = "wish_method",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "method")
  private List<WishMethod> methods = new ArrayList<>(List.of(WishMethod.ONLINE));

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
    wish.setTags(new ArrayList<>(tags));
    wish.setConditions(new ArrayList<>(conditions));
    wish.setUrls(new ArrayList<>(urls));
    wish.setRetailers(new ArrayList<>(retailers));
    wish.setMethods(new ArrayList<>(methods));
    return wish;
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
  public List<String> getTags() {
    return tags;
  }

  /**
   * Sets tags.
   *
   * @param tags the tags
   */
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * Gets conditions.
   *
   * @return the conditions
   */
  public List<WishCondition> getConditions() {
    return conditions;
  }

  /**
   * Sets conditions.
   *
   * @param conditions the conditions
   */
  public void setConditions(List<WishCondition> conditions) {
    this.conditions = conditions;
  }

  /**
   * Gets urls.
   *
   * @return the urls
   */
  public List<String> getUrls() {
    return urls;
  }

  /**
   * Sets urls.
   *
   * @param urls the urls
   */
  public void setUrls(List<String> urls) {
    this.urls = urls;
  }

  /**
   * Gets retailers.
   *
   * @return the retailers
   */
  public List<String> getRetailers() {
    return retailers;
  }

  /**
   * Sets retailers.
   *
   * @param retailer the retailer
   */
  public void setRetailers(List<String> retailer) {
    this.retailers = retailer;
  }

  /**
   * Gets methods.
   *
   * @return the methods
   */
  public List<WishMethod> getMethods() {
    return methods;
  }

  /**
   * Sets methods.
   *
   * @param methods the methods
   */
  public void setMethods(List<WishMethod> methods) {
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
}
