/*package org.springframework.samples.escalade.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
			
	@RequestMapping("/")
	public ModelAndView showHome() {
		ModelAndView mav = new ModelAndView("welcome");
	
		return mav;
	}
	
	
}
*/

package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.beanform.UserForm;
import org.springframework.samples.escalade.dao.UserDAO;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class HomeController {

	
	 private UserDAO UserDAO;
	
	
	private final EscaladeService escaladeService = null;
		
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	/*addin */
	
	@Autowired
	   private Validator UserValidator;
	
	
	
	// Set a form validator
	   @InitBinder
	   protected void initBinder(WebDataBinder dataBinder) {
	      // Form target
	      Object target = dataBinder.getTarget();
	      if (target == null) {
	         return;
	      }
	      System.out.println("Target=" + target);
	 
	      if (target.getClass() == UserForm.class) {
	         dataBinder.setValidator(UserValidator);
	      }
	      // ...
	   }
	
	   @RequestMapping("/users/registerSuccessful")
	   public String viewRegisterSuccessful(Model model) {
	 
	      return "/users/registerSuccessful";
	   }
	
	
	// Show Register page.
	   @RequestMapping(value = "/users/register", method = RequestMethod.GET)
	   public String viewRegister(Model model) {
		   
	      UserForm form = new UserForm();	      	 
	      model.addAttribute("userForm", form);
	     	 
	      //return "register";
	      return "/users/createOrUpdateUserForm";
	   }
	
	   // This method is called to save the registration information.
	   // @Validated: To ensure that this Form
	   // has been Validated before this method is invoked.
	   @RequestMapping(value = "/register", method = RequestMethod.POST)
	   public String saveRegister(Model model,  @ModelAttribute("userForm")
	         @Validated UserForm UserForm, 
	         BindingResult result,
	         final RedirectAttributes redirectAttributes) 
	    	{
	 
	      // Validate result
	      
	     
	      
	      
	      User newUser= null;
	      try {
	         newUser = UserDAO.createUser(UserForm);
	      }
	      
	      
	      
	      
	      
	      // Other error!!
	      catch (Exception e) {	         	         
	         model.addAttribute("errorMessage", "Error: " + e.getMessage());
	         return "/users/register";
	      }
	 
	      redirectAttributes.addFlashAttribute("flashUser", newUser);
	       
	      return "redirect:/users/registerSuccessful";
	   }   
	   
	   
	 @RequestMapping("/welcome")  
	 public String welcome()
	 {
		 return "welcome";
				 }
	   
	   
	/*
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");	
	
		return "welcome";
	}
	*/
	/*
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		return "adminPage";
	}
	*/

	@RequestMapping(value = "/users/login", method = RequestMethod.GET)
	public String loginPage1(Model model) {

		return "/users/login";
	}

	
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String loginPage(Model model) {

		return "/users/login";
	}
	
	/*
	@RequestMapping(value= "/user/new", method = RequestMethod.GET)
	
	public String createLoginPage(Model model, Principal principal) {
		
		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		
		return "userInfoPage";
	}
	*/
	
	/*
	 * Login registration
	 */
	
	
	@RequestMapping(value = "/users/registration", method = RequestMethod.GET)
	public String initCreationUserForm(Map<String, Object> model) {
		
		User user = new User();
		model.put("user", user);
		return "/users/registration";
	}
		

	@RequestMapping(value = "/users/registration", method = RequestMethod.POST)
	public String processCreationUserForm(@Valid  User user, BindingResult result) {
		 
		if (result.hasErrors()) {
			return "/users/registration";
		} else {
			this.escaladeService.saveUser(user);
			return "redirect:/users/" + user.getUserName();
			
		}
	}
	
	
	
	
	/*
	 * Logout
	 */
	
	
		
	
	@RequestMapping(value = "/users/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "/users/logoutSuccessful";
	}

	/*
	 * login auth.
	 */
	
	@RequestMapping(value = "/users/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// After user login successfully.
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		//String userInfo = WebUtils.toString(loginedUser);
		//model.addAttribute("userInfo", userInfo);

		return "userInfo";
	}
	
	
	
	 /*
	 * login auth.
	 */
	
	@RequestMapping(value = "/users/userAccountInfo", method = RequestMethod.GET)
	public String userAccountInfo(Model model, Principal principal) {

		// After user login successfully.
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		//String userInfo = WebUtils.toString(loginedUser);
		//model.addAttribute("userInfo", userInfo);

		return "userAccountInfo";
	}
	
	
	/**
	 * Custom handler for displaying an user.
	 *
	 * @param userId the ID of the user to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/users/userAccountInfo")
	public ModelAndView showUser(@PathVariable("userName") String userName) {
		ModelAndView mav = new ModelAndView("userAccountInfo");
		mav.addObject(this.escaladeService.findUserByUserName(userName));
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			//String userInfo = WebUtils.toString(loginedUser);

			//model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "/users/403";
	}

	
	
	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		User user = new User();	
		model.put("user", user);
		
		return  "users/userAccountInfo";
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid User user, BindingResult result) {
		 
		if (result.hasErrors()) {
			return "/users/userAccountInfo";
		} else {
			this.escaladeService.saveUser(user);
			return "redirect:/users/" + user.getUserName();
		}
	}
	
	
	
	
}