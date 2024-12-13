package ru.example.numbers.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = NonNullValidator.class)
public @interface NonNullValidation {
    String message() default "{NonNullValidation.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}