package org.springframework.samples.escalade.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.User;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.samples.escalade.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	private static final String REQUIRED = "required";

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		User user = (User) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!user.getPassword().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");

			String name = user.getUsername();
			// name validation
			if (!StringUtils.hasLength(name)) {
				errors.rejectValue("name", REQUIRED, REQUIRED);

				String password = user.getPassword();

				if (!StringUtils.hasLength(password)) {
					errors.rejectValue("password", REQUIRED, REQUIRED);

				}
			}
		}
	}
}