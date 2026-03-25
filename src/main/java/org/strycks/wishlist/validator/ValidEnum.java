package org.strycks.wishlist.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** The interface Valid enum. */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
public @interface ValidEnum {
  /**
   * Enum class.
   *
   * @return the class
   */
  Class<? extends Enum<?>> enumClass();

  /**
   * Default message.
   *
   * @return the string
   */
  String message() default "Invalid value";

  /**
   * Groups.
   *
   * @return the class [ ]
   */
  Class<?>[] groups() default {};

  /**
   * Payload.
   *
   * @return the class [ ]
   */
  Class<? extends Payload>[] payload() default {};
}
