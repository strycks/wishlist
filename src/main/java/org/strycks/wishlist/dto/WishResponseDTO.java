package org.strycks.wishlist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/** The type Wish dto. */
@Getter
@Setter
public class WishResponseDTO {
  @NotNull private Long id;
  @NotBlank private String name;
  @NotNull private Long price;
  private String note;
  @NotNull private Integer meter;
  @NotNull private Integer quantity;
  private String about;
  @NotBlank private String status;
  private LocalDateTime deadline;
  @NotNull private LocalDateTime creationDate;
  private List<String> tags = new ArrayList<>();
  private List<String> conditions = new ArrayList<>();
  private List<String> urls = new ArrayList<>();
  private List<String> retailers = new ArrayList<>();
  private List<String> methods = new ArrayList<>();
}
