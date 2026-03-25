package org.strycks.wishlist.dto;

/** The type Error response dto. */
public class ErrorResponseDTO {
  private String message;
  private int status;

  /**
   * Instantiates a new Error response dto.
   *
   * @param message the message
   * @param status the status
   */
  public ErrorResponseDTO(String message, int status) {
    this.message = message;
    this.status = status;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets message.
   *
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(int status) {
    this.status = status;
  }
}
