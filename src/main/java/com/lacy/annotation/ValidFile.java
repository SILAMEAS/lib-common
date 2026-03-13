package com.lacy.annotation;

import com.lacy.annotation.constraint.FileValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import org.springframework.http.MediaType;

@Documented
@Constraint(validatedBy = FileValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFile {
  String message() default "Invalid file";

  long maxSize() default 2 * 1024 * 1024; // 2MB

  String[] allowedTypes() default {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE};

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
