package ch.hsr.intTe.ui.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=UserDoesntExistValidator.class)
public @interface UserDoesntExist {
	String message() default "{ch.hsr.intte.constraints.userExists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
