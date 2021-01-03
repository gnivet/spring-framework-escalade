package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
public class TopoController {

	private static final String VIEWS_TOPO_CREATE_OR_UPDATE_FORM = "topos/createOrUpdateTopoForm";
	private EscaladeService escaladeService;
	private UserRepository userRepository;

	private TopoRepository topoRepository;

	@Autowired
	public TopoController(EscaladeService escaladeService, UserRepository userRepository,
			TopoRepository topoRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
		this.topoRepository = topoRepository;

	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	// Publish a topo

	@GetMapping(value = "/topos/new")
	public String initCreationForma(Map<String, Object> model, Principal principal) {

		if (principal != null) {
			Topo topo = new Topo();
			model.put("topo", topo);
			return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
		}
		return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/topos/new")
	public String processCreationForm(@ModelAttribute("topo") @Valid Topo topo, BindingResult result, Integer topoId,
			Model model, Principal principal) {
		if (principal.getName() != null) {
			String userName = principal.getName();
			User user = this.userRepository.findByUserName(userName);
			topo.setUser(user);
		} else {
			return "redirect:/users/login/";
		}
		/**
		 * Retrieve a <code>User</code> from the data store by id.
		 *
		 * @param userName the userName to search for
		 * @return the <code>User</code> if found
		 * @throws org.springframework.dao.DataRetrievalFailureException if not found
		 */

		if (result.hasErrors()) {
			return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
		} else {
			topo = this.escaladeService.saveTopo(topo);
			if (topo == null) {
				return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
			}

		}
		return "redirect:/topos/" + topo.getId();
	}

	@GetMapping(value = "/topos/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("topo", new Topo());
		return "/topos/findTopos";

	}

	@GetMapping(value = "/topos")
	public String processFindForm(Topo topo, User  user ,BindingResult result, Map<String, Object> model , Principal principal) {

		
		if (principal.getName() != null) {
			String userName = principal.getName();
			user = this.userRepository.findByUserName(userName);
			
			
			Collection<Topo> results = this.escaladeService.findTopoByUserId(user.getId());

			if (results.isEmpty()) {
				// no topos found
				//result.rejectValue("name", "notFound", "not found");
				//return "/topos/findTopos";
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

	@GetMapping(value = "/topolist")
	public String processFindForm(Topo topo, User  user , String name, BindingResult result, Map<String, Object> model , Principal principal) {

		
		if (principal.getName() != null) {
			String userName = principal.getName();
			user = this.userRepository.findByUserName(userName);
			
			
			Collection<Topo> results = this.escaladeService.findTopos();

			if (results.isEmpty()) {
				// no topos found
				//result.rejectValue("name", "notFound", "not found");
				return "/topos/findTopos";

			} else {
				// multiple topos found
				model.put("selections", results);
				return "topos/toposList";
			}
			
			
		} else {
			return "redirect:/users/login/";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping(value = "/toposAvailable")
	public String processFindToposAvailable(Topo topo, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /areas to return all records
		if (topo.getName() == null) {
			topo.setName(""); // empty string signifies broadest possible search
		}

		Collection<Topo> results = this.escaladeService.findTopoAvailableByName(topo.getName());
		if (results.isEmpty()) {
			// no areas found
			result.rejectValue("name", "notFound", "not found");
			return "/topos/findTopos";

		} else {
			// multiple topos found
			model.put("selections", results);
			return "topos/toposList";
		}
	}
	/*
	 * Topo update
	 * 
	 */

	@GetMapping(value = "/topos/{topoId}")
	public String initUpdatetopoForm(@NotNull @PathVariable("topoId") Integer topoId, @NotNull Model model, User user,
			Principal principal) {
		Topo topo = this.escaladeService.findTopoById(topoId);
		model.addAttribute(topo);
		String userName = principal.getName();
		user = this.userRepository.findByUserName(userName);

		// User user = this.userRepository.findByUsername(userName);
		// topo.setUser(user.);
		model.addAttribute("users", user);

		return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/topos/{topoId}")
	public String processUpdatetopoForm(Topo topo, BindingResult result, @PathVariable("topoId") Integer topoId,
			User user, Principal principal) {

		if (result.hasErrors()) {
			return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
		} else {

			Topo topoToModify = this.escaladeService.findTopoById(topoId);
			String userName = principal.getName();
			user = this.userRepository.findByUserName(userName);
			topoToModify.setUser(topo.getUser());
			topoToModify.setName(topo.getName());
			topoToModify.setAvailable(topo.isAvailable());
			topoToModify.setDescription(topo.getDescription());
			this.escaladeService.updateTopo(topoToModify);
			return "redirect:/topos/{topoId}";
		}
	}

	/**
	 * Custom handler for displaying an topo.
	 *
	 * @param topoId the ID of the topo to display
	 * @return a ModelMap with the model attributes for the view
	 */

	@RequestMapping("/topos/{topoId}/topoBkgs/{topoBkgId}/topoDetails")
	public ModelAndView showtopo(@PathVariable("topoId") Integer topoId, @PathVariable("topoBkgId") Integer topoBkgId) {
		ModelAndView mav = new ModelAndView("topos/topoDetails");
		mav.addObject(this.escaladeService.findTopoById(topoId));
		return mav;
	}
	
	@GetMapping(value = "/FindtoposByUserName")
	public String processtoposByUserName(Topo topo, BindingResult result, Map<String, Object> model, User user, Principal principal) {

		// allow parameterless GET request for /areas to return all records
		if (topo.getName() == null) {
			topo.setName(""); // empty string signifies broadest possible search
		}
		String userName = principal.getName();
		List<Topo> results = this.escaladeService.findTopoByUserName(userName);
		
		if (results.isEmpty()) {
			// no areas found
			result.rejectValue("name", "notFound", "not found");
			return "/topos/findTopos";

		} else {
			// multiple topos found
			model.put("selections", results);
			return "topos/toposList";
		}
	}
	
}
