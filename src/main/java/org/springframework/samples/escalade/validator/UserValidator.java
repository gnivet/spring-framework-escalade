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
				
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("userName", "Size.user.userName");
		}
		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("userName", "Duplicate.user.userName");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.user.password");
		}

		if (!user.getPassword().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");

			String name = user.getUsername();
			// name validation
			if (!StringUtils.hasLength(name)) {
				errors.rejectValue("name", REQUIRED, REQUIRED);

				String password = user.getPassword();

				if (!StringUtils.hasLength(password)) {
					errors.rejectValue("password", REQUIRED, REQUIRED);

				}
				
				
				
			}
			
			
			
			String firstName = user.getFirstName();
			if (StringUtils.hasLength(firstName)) {
				errors.rejectValue("firstName", REQUIRED, REQUIRED);

			}
			String lastName = user.getLastName();
			if (!StringUtils.hasLength(lastName)) {
				errors.rejectValue("lastName", REQUIRED, REQUIRED);

			}
			
			String address = user.getAddress();
			if (!StringUtils.hasLength(address)) {
				errors.rejectValue("address", REQUIRED, REQUIRED);

			}
			
			String postalCode = user.getPostalCode();
			if (!StringUtils.hasLength(postalCode)) {
				errors.rejectValue("postalCode", REQUIRED, REQUIRED);

			}
			String city = user.getCity();
			if (!StringUtils.hasLength(city)) {
				errors.rejectValue("city", REQUIRED, REQUIRED);

			}
			
			String email = user.getEmail();
			if (!StringUtils.hasLength(email)) {
				errors.rejectValue("email", REQUIRED, REQUIRED);

			}
			
			String telephone  = user.getTelephone();
			if (!StringUtils.hasLength(telephone)) {
				errors.rejectValue("telephone", REQUIRED, REQUIRED);

			}
			
		}
	}
}