package ch.hsr.intTe.ui.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.service.UserService;

public class UserDoesntExistValidator implements ConstraintValidator<UserDoesntExist, String>
{
	
	private UserService userService;

	@Override
	public void initialize(UserDoesntExist constraintAnnotation) {
		userService = ServiceLocator.getInstance().locate(UserService.class);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !userService.getByUsername(value).isPresent();
	}

}
