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
import org.springframework.samples.escalade.beanform.AppUserForm;
import org.springframework.samples.escalade.dao.AppUserDAO;
import org.springframework.samples.escalade.model.AppUser;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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

	 @Autowired
	   private AppUserDAO appUserDAO;
	
	
	private final EscaladeService escaladeService = null;
		
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	/*addin */
	
	@Autowired
	   private Validator appUserValidator;
	
	
	
	// Set a form validator
	   @InitBinder
	   protected void initBinder(WebDataBinder dataBinder) {
	      // Form target
	      Object target = dataBinder.getTarget();
	      if (target == null) {
	         return;
	      }
	      System.out.println("Target=" + target);
	 
	      if (target.getClass() == AppUserForm.class) {
	         dataBinder.setValidator(appUserValidator);
	      }
	      // ...
	   }
	
	   @RequestMapping("/registerSuccessful")
	   public String viewRegisterSuccessful(Model model) {
	 
	      return "registerSuccessfulPage";
	   }
	
	
	// Show Register page.
	   @RequestMapping(value = "/register", method = RequestMethod.GET)
	   public String viewRegister(Model model) {
		   
	      AppUserForm form = new AppUserForm();	      	 
	      model.addAttribute("userForm", form);
	     	 
	      return "register";
	   }
	
	   // This method is called to save the registration information.
	   // @Validated: To ensure that this Form
	   // has been Validated before this method is invoked.
	   @RequestMapping(value = "/register", method = RequestMethod.POST)
	   public String saveRegister(Model model,  @ModelAttribute("userForm")
	         @Validated AppUserForm appUserForm, 
	         BindingResult result,
	         final RedirectAttributes redirectAttributes) 
	    	{
	 
	      // Validate result
	      
	     
	      
	      
	      AppUser newUser= null;
	      try {
	         newUser = appUserDAO.createAppUser(appUserForm);
	      }
	      
	      
	      
	      
	      
	      // Other error!!
	      catch (Exception e) {	         	         
	         model.addAttribute("errorMessage", "Error: " + e.getMessage());
	         return "registerPage";
	      }
	 
	      redirectAttributes.addFlashAttribute("flashUser", newUser);
	       
	      return "redirect:/registerSuccessful";
	   }   
	   
	   
	   
	   
	   
	
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");	
	
		return "welcomePage";
	}

	/*
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		return "adminPage";
	}
	*/

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "loginPage";
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
	
	
	@RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
	public String initCreationUserForm(Map<String, Object> model) {
		
		AppUser appuser = new AppUser();
		model.put("appuser", appuser);
		return "registrationPage";
	}
		

	@RequestMapping(value = "/registrationPage", method = RequestMethod.POST)
	public String processCreationUserForm(@Valid  AppUser appuser, BindingResult result) {
		 
		if (result.hasErrors()) {
			return "registrationPage";
		} else {
			this.escaladeService.saveAppUser(appuser);
			return "redirect:/" + appuser.getUserName();
			
		}
	}
	
	
	
	
	/*
	 * Logout
	 */
	
	
		
	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	/*
	 * login auth.
	 */
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// After user login successfully.
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		//String userInfo = WebUtils.toString(loginedUser);
		//model.addAttribute("userInfo", userInfo);

		return "userInfoPage";
	}
	
	
	
	 /*
	 * login auth.
	 */
	
	@RequestMapping(value = "/userAccountInfo", method = RequestMethod.GET)
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
	@RequestMapping("/userAccountInfo")
	public ModelAndView showUser(@PathVariable("userName") String userName) {
		ModelAndView mav = new ModelAndView("userAccountInfo");
		mav.addObject(this.escaladeService.findAppUserByUserName(userName));
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

		return "403Page";
	}

}