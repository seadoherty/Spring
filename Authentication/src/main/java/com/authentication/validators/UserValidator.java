package com.authentication.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.authentication.models.User;
import com.authentication.services.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService uServ;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}

		if (uServ.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("duplicate", "Dupe");
		}

	}

}