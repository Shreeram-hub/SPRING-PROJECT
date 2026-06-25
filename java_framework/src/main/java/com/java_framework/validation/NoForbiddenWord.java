package com.java_framework.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = NoForbiddenWordValidator.class) // ロジッククラスと紐づける！
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)


public @interface NoForbiddenWord {
	
    String message() default "禁止ワードが含まれています";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
