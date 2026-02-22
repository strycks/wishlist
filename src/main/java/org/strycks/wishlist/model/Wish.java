package org.strycks.wishlist.model;

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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wish")
public class Wish {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Long price;

  private String note;

  @Column(nullable = false)
  private Integer meter;

  @Column(nullable = false)
  private Integer quantity;

  private String about;

  @Column(nullable = false)
  private String status = "PENDING";

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
  private List<WishCondition> conditions = new ArrayList<>();

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
  private List<String> retailer = new ArrayList<>();

  @ElementCollection
  @Enumerated(EnumType.STRING)
  @CollectionTable(
      name = "wish_method",
      joinColumns = @JoinColumn(name = "wish_id")
  )
  @Column(name = "method")
  private List<WishMethod> methods = new ArrayList<>();

  public Wish() {
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

  public List<String> getRetailer() {
    return retailer;
  }

  public void setRetailer(List<String> retailer) {
    this.retailer = retailer;
  }

  public List<WishMethod> getMethods() {
    return methods;
  }

  public void setMethods(List<WishMethod> methods) {
    this.methods = methods;
  }
}
