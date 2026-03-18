package org.strycks.wishlist.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Stream;

/**
 * The type Enum validator.
 */
public class EnumValidator implements ConstraintValidator<ValidEnum, String> {
  private List<String> validValues;

  @Override
  public void initialize(ValidEnum constraintAnnotation) {
    validValues = Stream.of(constraintAnnotation.enumClass().getEnumConstants()).map(Enum::name).toList();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null || value.isBlank()) {
      return true;
    }
    return validValues.contains(value);
  }
}
