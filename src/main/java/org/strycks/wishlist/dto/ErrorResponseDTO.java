package org.strycks.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** The type Error response dto. */
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseDTO {
  private String message;
  private int status;
}
