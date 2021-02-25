package com.casadocodigo.casadocodigo.validador;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(value = { ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValuesValidator.class)
public @interface UniqueValues {

	Class<?> domainClass();

	String[] fields();

	String[] aliases();

	String message() default "Error unique values";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}