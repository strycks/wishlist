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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

  public Wish() {
  }

  /**
   * Deep copy.
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Integer getMeter() {
    return meter;
  }

  public void setMeter(Integer meter) {
    this.meter = meter;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public List<WishCondition> getConditions() {
    return conditions;
  }

  public void setConditions(List<WishCondition> conditions) {
    this.conditions = conditions;
  }

  public List<String> getUrls() {
    return urls;
  }

  public void setUrls(List<String> urls) {
    this.urls = urls;
  }

  public List<String> getRetailers() {
    return retailers;
  }

  public void setRetailers(List<String> retailer) {
    this.retailers = retailer;
  }

  public List<WishMethod> getMethods() {
    return methods;
  }

  public void setMethods(List<WishMethod> methods) {
    this.methods = methods;
  }

  public LocalDateTime getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
  }
}
