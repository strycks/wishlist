package org.strycks.wishlist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Wish request dto.
 */
public class WishRequestDTO {
  @NotBlank
  private String name;
  @NotNull
  private Long price;
  private String note;
  @NotNull
  private Integer meter;
  @NotNull
  private Integer quantity;
  private String about;
  @NotBlank
  private String status;
  private LocalDateTime deadline;
  private Set<String> tags = new HashSet<>();
  private Set<String> conditions = new HashSet<>();
  private Set<String> urls = new HashSet<>();
  private Set<String> retailers = new HashSet<>();
  private Set<String> methods = new HashSet<>();

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
   * Gets tags.
   *
   * @return the tags
   */
  public Set<String> getTags() {
    return tags;
  }

  /**
   * Sets tags.
   *
   * @param tags the tags
   */
  public void setTags(Set<String> tags) {
    this.tags = tags;
  }

  /**
   * Gets conditions.
   *
   * @return the conditions
   */
  public Set<String> getConditions() {
    return conditions;
  }

  /**
   * Sets conditions.
   *
   * @param conditions the conditions
   */
  public void setConditions(Set<String> conditions) {
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
   * @param retailers the retailers
   */
  public void setRetailers(Set<String> retailers) {
    this.retailers = retailers;
  }

  /**
   * Gets methods.
   *
   * @return the methods
   */
  public Set<String> getMethods() {
    return methods;
  }

  /**
   * Sets methods.
   *
   * @param methods the methods
   */
  public void setMethods(Set<String> methods) {
    this.methods = methods;
  }
}
