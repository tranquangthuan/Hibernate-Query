package com.thuan.hibernate.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ConsistentDateParametersValidator.class)
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConsistentDateParameters {
	String message() default "{ConsistentDateParameters.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
