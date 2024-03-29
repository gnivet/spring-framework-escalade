package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Way;
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
	private TopoBkgRepository topoBkgRepository;
	//@SuppressWarnings("unused")
	//private String userName;
	//@SuppressWarnings("unused")
	//private Principal principal;

	public MainController(EscaladeService escaladeService, UserRepository userRepository, TopoRepository topoRepository,
			TopoBkgRepository topoBkgRepository) {

		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
		this.topoBkgRepository = topoBkgRepository;

	}

	@GetMapping(value = { "/", "/welcome" })
	public String welcome(Model model, Principal principal)

	{

		if (principal != null) {
			String userName = principal.getName();

			User user = this.userRepository.findByUserName(userName);
			model.addAttribute("firstName", user.getFirstName());

		}
		return "/welcome";
	}

	@GetMapping(value = "/dashboards/mains")
	public String processFindForm(Topo topo, User user, BindingResult result, Map<String, Object> model,
			Principal principal) {

		if (principal.getName() != null) {
			String userName = principal.getName();
			user = this.userRepository.findByUserName(userName);

			Collection<Topo> results = this.escaladeService.findTopoByUserId(user.getId());

			if (results.isEmpty()) {
				// no topos found
				// result.rejectValue("name", "notFound", "not found");
				// return "/topos/findTopos";
				System.out.println("Your topo list is empty");
				return "/dashboards/dashboard";

			} else {
				// multiple topos found
				model.put("selections", results);
				return "topos/toposList";
			}

		} else {
			return "redirect:/users/login/";
		}

	}

	@GetMapping(value = "/dashboards/dashboards")
	public String dashboard(Model model, Comment comment, Topo topo, String commentaryNb, String userName, String name,
			BindingResult result, Principal principal) {
		if (principal.getName() == null) {
			return "/welcome";

		} else {
			userName = principal.getName();
		}

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
				
		  Integer cNb = this.escaladeService.findCountNumberCommentByUsername(userName);  
	
		  if (cNb != null) 
		  {
		   String strcNb = cNb.toString();
		   model.addAttribute("strcNb", strcNb); 
			}

		/*
		 * Number Site's owner:
		 */
		Integer sNb = this.escaladeService.findCountSiteOwnedByUsername(userName);
		if (sNb != null) 
		{
			String strsNb = sNb.toString();
			model.addAttribute("strsNb", strsNb);
		}
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
		 * Topo list
		 */
		
		Collection<Topo> topoListByName = this.escaladeService.findTopoByUserName(userName);

		model.addAttribute("topoListByName", topoListByName);

		/*
		 * Topo list
		 */

		Collection<Way> wayListByName = this.escaladeService.findWayByUserName(userName);

		model.addAttribute("wayListByName", wayListByName);

		/*
		 * My topos
		 */

		String url = " <a href=\"topos/\">";
		model.addAttribute(url);

		return "/dashboards/dashboard";

	}

}
