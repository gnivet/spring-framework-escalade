package org.springframework.samples.escalade.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.samples.escalade.service.SecurityService;
import org.springframework.samples.escalade.service.UserService;
import org.springframework.samples.escalade.validator.UserValidator;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
	
	
	private static final String VIEWS_USER_CREATE_OR_UPDATE_FORM = "users/createOrUpdateUserForm";
	private UserService userService;
	private UserValidator userValidator;
	private SecurityService securityService;
	
	@Autowired
	public UserController(EscaladeService escaladeService, UserService userService, UserValidator userValidator, SecurityService securityService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.securityService = securityService;
	}	
   

    @GetMapping(value = "/users/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "/users/registration";
    }

    @PostMapping(value = "/users/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
      //  userValidator.validate(userForm, bindingResult);
    	/*
        if (bindingResult.hasErrors()) {
            return "/users/registration";
        }
		*/
        userService.save(userForm);

        //securityService.autologin(userForm.getUsername(), userForm.getPassword());
        
        return "redirect:/welcome";
    }
    
    @PostMapping(value="/users/login")
    public String loginUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
       // userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/users/registration";
        }
        try {
        	securityService.autologin(userForm.getUsername(), userForm.getPassword());
		} catch (AuthenticationException  e) {
			// TODO: handle exception
			model.addAttribute("error", "Your authentifaction is not correct");
			return "redirect:/users/login";
		}
        
        
        return "redirect:/welcome";
    }

    @GetMapping(value = "/users/login")
    public String login(Model model, String error, String logout) {
    	   model.addAttribute("userForm", new User());

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "/users/login";
    }

   
    @GetMapping(value = "/users/new")
    public String initCreationForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return VIEWS_USER_CREATE_OR_UPDATE_FORM;
    }
    @PostMapping(value = "/users/new")
    public String processCreationForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_USER_CREATE_OR_UPDATE_FORM;
        } else {
            this.userService.save(user);
            return "redirect:/users/" + user.getId();
        }
    }
       
    
    
    
    @GetMapping(value = {"/", "/welcome"})
    public String welcome(Model model) {
        return "/welcome";
    }

	public UserValidator getUserValidator() {
		return userValidator;
	}

	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	/*
	 @GetMapping(value = "/users/logout")
		public String logoutSuccessfulPage(Model model) {
			model.addAttribute("title", "Logout");
			return "/users/logout";
		}
	*/



}