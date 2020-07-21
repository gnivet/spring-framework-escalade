package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.TopoBkgRepository;
import org.springframework.samples.escalade.repository.TopoRepository;
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
	private TopoRepository topoRepository;
	private TopoBkgRepository topoBkgRepository;
	private String userName;
	private Principal principal;
	

	@Autowired
	public MainController(EscaladeService escaladeService , UserRepository userRepository, TopoRepository topoRepository, TopoBkgRepository topoBkgRepository) {
		
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
		this.topoRepository = topoRepository;
		this.topoBkgRepository = topoBkgRepository;
		
	}	


		@GetMapping(value = {"/", "/welcome"})
	    public String welcome(Model model, Principal principal)
	  
   	 	    
	    {
			
			 if (principal != null)
			 {
			 String userName = principal.getName();
			 
			 User user = this.userRepository.findByUserName(userName);
			 model.addAttribute("firstName" , user.getFirstName());
	    	 
			 }
			 return "/welcome" ;
	    }
	    
		
		
    	



		@GetMapping(value= "/dashboards/dashboard")
		public String dashboard( Model model, Comment comment,Topo topo, String commentaryNb, String userName, BindingResult result, Principal principal) {
			
	        	userName = principal.getName();
	        	
	        	
	        	
	        	/*--------------------------------------------------------------/
	        	 * Get topo list owned by a user
	        	 *--------------------------------------------------------------/
	        	
	        	/*
	        	 * Get the user_id 
	        	 */
	        	User user = this.userRepository.findByUserName(userName);	 
	        	
	        	/*
	        	 * Get topo list from user_id
	        	 */
	        	
	        	List<Topo> topoList = escaladeService.findTopoByUserId(user.getId());
	        	model.addAttribute("topoList", topoList);
	        	
	        	
	        	/*
	        	 * Get the topo booking list for one user
	        	 */
	        	
	        	
	        	List<TopoBkg> topoBkgList = this.topoBkgRepository.findTopoBkgById(topo.getId());
	        	model.addAttribute("topoBkgList", topoBkgList);
	        		        	     	 	
	        	
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
	        	 * Topo's user
	        	 */
	        	
	        	List<Topo> topoListByUserName = this.escaladeService.findTopoByUserName(userName);    
	        	
	        	model.addAttribute("topoListByUserName", topoListByUserName);
	        	 
	        	
	        	/*
	        	 * My topos
	        	 */
	        	
	        	String url = " <a href=\"topos/\">";
	        	model.addAttribute(url);
	        	
	        	return "/dashboards/dashboard" ;
	      
			
	        	
	        	
	        	
		}
		
 
	    
	   
}
