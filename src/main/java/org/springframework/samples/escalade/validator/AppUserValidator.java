package org.springframework.samples.escalade.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.beanform.AppUserForm;
import org.springframework.samples.escalade.dao.AppUserDAO;
import org.springframework.samples.escalade.model.AppUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class AppUserValidator implements Validator {
 
    // common-validator library.
    //private EmailValidator emailValidator = EmailValidator.getInstance();
 
    @Autowired
    private AppUserDAO appUserDAO;
 
    // The classes are supported by this validator.
    public boolean supports(Class<?> clazz) {
        return clazz == AppUserForm.class;
    }
 
    public void validate(Object target, Errors errors) {
        AppUserForm appUserForm = (AppUserForm) target;
 
        // Check the fields of AppUserForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.appUserForm.userName");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.appUserForm.firstName");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.appUserForm.lastName");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.appUserForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.appUserForm.gender");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "NotEmpty.appUserForm.countryCode");
        
        
        /*
        if (!this.emailValidator.isValid(appUserForm.getEmail())) {
            // Invalid email.
            errors.rejectValue("email", "Pattern.appUserForm.email");
        } else if (appUserForm.getUserId() == null) {
            AppUser dbUser = appUserDAO.findAppUserByEmail(appUserForm.getEmail());
            if (dbUser != null) {
                // Email has been used by another account.
                errors.rejectValue("email", "Duplicate.appUserForm.email");
            }
        }
 		*/
        if (!errors.hasFieldErrors("userName")) {
            AppUser dbUser = appUserDAO.findAppUserByUserName(appUserForm.getUserName());
            if (dbUser != null) {
                // Username is not available.
                errors.rejectValue("userName", "Duplicate.appUserForm.userName");
            }
        }
 
        if (!errors.hasErrors()) {
            if (!appUserForm.getPassword().equals(appUserForm.getPassword())) {
                errors.rejectValue("password", "Match.appUserForm.password");
            }
        }
    }
 
}
