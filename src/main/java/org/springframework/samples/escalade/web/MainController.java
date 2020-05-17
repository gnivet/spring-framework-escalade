package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

	
	@Controller
	public class MainController {

	
	private EscaladeService escaladeService;
	private UserRepository userRepository;


	@Autowired
	public MainController(EscaladeService escaladeService , UserRepository userRepository) {
		
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
	}	


		@GetMapping(value = {"/", "/welcome"})
	    public String welcome(Model model, Principal principal)
	  
   	 	    
	    {
			
			 if (principal != null)
			 {
			 String username = principal.getName();
			 
			 User user = this.userRepository.findByUsername(username);
			 model.addAttribute("firstName" , user.getFirstName());
	    	 
			 }
			 return "/welcome" ;
	    }
	    
		
		@GetMapping(value= "/dashboards/dashboard")
		public String dashboard( Model model, Comment comment, String commentaryNb, String userName, BindingResult result, Principal principal) {
			
	        	userName = principal.getName();
	        	
	        	/*
	        	 * Comment's user number
	        	 */
	        	Long cNb = this.escaladeService.findByUsername(userName);
	        	String strcNb = cNb.toString();
	        	model.addAttribute("strcNb", strcNb);
	        	
	        	/*
	        	 * Number Site's owner:
	        	 */
	        	Long sNb = this.escaladeService.findSiteOwnedByUsername(userName);
	        	String strsNb = sNb.toString();
	        	model.addAttribute("strsNb", strsNb);
	        	
	        	/*
	        	 * Number of borrowed topos:
	        	 */
	        	
	        	/*
	        	 * My last commentaries:
	        	 */
	        	Collection<Comment> results = this.escaladeService.findCommentByUsername(userName);
	        	model.addAttribute("results", results);
	        	
	        	
	        	/*
	        	 * My topos
	        	 */
	        	
	        	String url = " <a href=\"topos/\">";
	        	model.addAttribute(url);
	        	
	        	return "/dashboards/dashboard" ;
	      
			
		}
		
 
	    
	   
}
