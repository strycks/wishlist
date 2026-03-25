package org.strycks.wishlist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.strycks.wishlist.model.WishCondition;
import org.strycks.wishlist.model.WishMethod;
import org.strycks.wishlist.model.WishStatus;
import org.strycks.wishlist.validator.ValidEnum;

/** The type Wish request dto. */
@Getter
@Setter
public class WishRequestDTO {
  @NotBlank private String name;
  @NotNull private Long price;
  private String note;
  @NotNull private Integer meter;
  @NotNull private Integer quantity;
  private String about;

  @NotBlank
  @ValidEnum(
      enumClass = WishStatus.class,
      message = "Status must be PENDING, PROCESSING or COMPLETED")
  private String status;

  private LocalDateTime deadline;
  private Set<String> tags = new HashSet<>();
  private Set<
          @ValidEnum(
              enumClass = WishCondition.class,
              message = "Method must be NEW, USED, UNUSED or REFURBISHED")
          String>
      conditions = new HashSet<>();
  private Set<String> urls = new HashSet<>();
  private Set<String> retailers = new HashSet<>();
  private Set<
          @ValidEnum(
              enumClass = WishMethod.class,
              message = "Method must be ONLINE, OFFLINE or ORDER")
          String>
      methods = new HashSet<>();
}
