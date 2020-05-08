package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.TopoBkgRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
public class TopoBkgController {

	

	private static final String VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM = "topoBkgs/createOrUpdateTopoBkgForm";
	private EscaladeService escaladeService;
	private UserRepository userRepository;	
	private TopoBkgRepository topoBkgRepository;
	
	
	
	@Autowired
	public TopoBkgController(EscaladeService escaladeService, UserRepository userRepository
			,TopoBkgRepository topoBkgRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;		
		this.topoBkgRepository = topoBkgRepository;
		
	}
	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	// Publish a topo
	
			@GetMapping(value = "/topoBkgs/new")
			public String initCreationForma(Map<String, Object> model ) {
			
				TopoBkg topoBkg = new TopoBkg();
				model.put("topoBkg", topoBkg);
				return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
			}

			@PostMapping(value = "/topoBkgs/new")
			public String processCreationForm(Principal principal, @Valid TopoBkg topoBkg,  Integer userId, BindingResult result, Integer topoBkgId, Map<String, Object> model) {
				
				String userName = principal.getName();
				
				
				/**
				 * Retrieve a <code>User</code> from the data store by id.
				 *
				 * @param userName the userName to search for
				 * @return the <code>User</code> if found
				 * @throws org.springframework.dao.DataRetrievalFailureException if not found
				 */
			
				User user = this.userRepository.findByUsername(userName);
				
					
				
				if (result.hasErrors()) {
					return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
				} else {
						
							
								
					//topo.setUser(user);
					model.put("topoBkg", topoBkg);
					topoBkg = this.escaladeService.saveTopoBkg(topoBkg);
					return "redirect:/topoBkgs/" +  topoBkg.getId() ;
				}
			}
			
			
			@GetMapping(value = "/topoBkgs/find")
			public String initFindForm(Map<String, Object> model) {
				model.put("topoBkg", new TopoBkg());
				return "/topoBkgs/findTopoBkgs";

			}
			

			@GetMapping(value = "/topoBkgs")
			public String processFindForm(TopoBkg topoBkg, BindingResult result, Map<String, Object> model) {

				// allow parameterless GET request for /areas to return all records
				if (topoBkg.getName() == null) {
					topoBkg.setName(""); // empty string signifies broadest possible search
				}

				// find areas by name
				Collection<TopoBkg> results = this.escaladeService.findTopoBkgByName(topoBkg.getName());

				if (results.isEmpty()) {
					// no areas found
					result.rejectValue("name", "notFound", "not found");
					return "/topoBkgs/findTopoBkgs";			

				} else {
					// multiple topos found
					model.put("selections", results);			
				 return "topoBkgs/topoBkgsList";
				}

			}

			
			
			
			
				
			@GetMapping(value = "/topoBkgs/{topoBkgId}/")
			public String initUpdatetopoBkgForm(@NotNull @PathVariable("topoBkgId") Integer topoBkgId, @NotNull Model model) {
				TopoBkg topoBkg = this.escaladeService.findTopoBkgById(topoBkgId);
				model.addAttribute(topoBkg);
				
				
				
				
				return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
			}

			
			@PostMapping(value = "/topoBkgs/{topoBkgId}/")
			public String processUpdatetopoBkgForm(TopoBkg topoBkg, BindingResult result, @PathVariable("topoBkgId")  Integer topoBkgId  ) {
				if (result.hasErrors()) {
					return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
				} else {

					TopoBkg topoBkgToModify = this.escaladeService.findTopoBkgById(topoBkgId);			
					topoBkgToModify.setName(topoBkg.getName());
					topoBkgToModify.setAccepted(topoBkg.getAccepted());
								
					this.escaladeService.updateTopoBkg(topoBkgToModify);			
					return "redirect:/topoBkgs/{topoBkgId}/";
				}
			}

			/**
			 * Custom handler for displaying an topo.
			 *
			 * @param topoId the ID of the topo to display
			 * @return a ModelMap with the model attributes for the view
			 */
			
			@RequestMapping("/topoBkgs/{topoBkgId}")
			public ModelAndView showtopo(@PathVariable("topoBkgId") Integer topoBkgId) {
				ModelAndView mav = new ModelAndView("topoBkgs/topoBkgDetails");
				mav.addObject(this.escaladeService.findTopoBkgById(topoBkgId));		
				return mav;
			}
			/*
			@GetMapping(value="/topos/" )
			public String findAvailableTopo(Topo topo, BindingResult result, Map<String, Object> model) {
				Collection<Topo> results = this.escaladeService.findTopoAvailableByName(topo.getName()) ;
				
				
				if (results.isEmpty()) {
					// no topos found
					result.rejectValue("name", "notFound", "not found");
					return "/topos/findTopos";			

				} else {
					// multiple topos found
					model.put("selections", results);			
				 return "topos/toposList";
				}
				
			}
				*/

			

			
}

