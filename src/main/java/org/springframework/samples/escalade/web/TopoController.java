package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;
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
	public TopoController(EscaladeService escaladeService, UserRepository userRepository, TopoRepository topoRepository
			) {
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
			public String initCreationForma(Map<String, Object> model ) {
			
				Topo topo = new Topo();
				model.put("topo", topo);
				return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
			}

			@PostMapping(value = "/topos/new")
			public String processCreationForm(Principal principal, @Valid Topo topo,  Integer userId, BindingResult result, Integer topoId, Map<String, Object> model) {
				
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
					return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
				} else {
						
							
								
					//topo.setUser(user);
					model.put("topos", topo);
					topo = this.escaladeService.saveTopo(topo);
					return "redirect:/topos/" +  topo.getId() ;
				}
			}
			
			
			@GetMapping(value = "/topos/find")
			public String initFindForm(Map<String, Object> model) {
				model.put("topo", new Topo());
				return "/topos/findTopos";

			}
			

			@GetMapping(value = "/topos")
			public String processFindForm(Topo topo, BindingResult result, Map<String, Object> model) {

				// allow parameterless GET request for /areas to return all records
				if (topo.getName() == null) {
					topo.setName(""); // empty string signifies broadest possible search
				}

				// find areas by name
				Collection<Topo> results = this.escaladeService.findTopoByName(topo.getName());

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

			
			
			
			
				
			@GetMapping(value = "/topos/{topoId}")
			public String initUpdatetopoForm(@NotNull @PathVariable("topoId") Integer   topoId, @NotNull Model model) {
				Topo topo = this.escaladeService.findTopoById(topoId);
				model.addAttribute(topo);
				
				
				
				
				return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
			}

			
			@PostMapping(value = "/topos/{topoId}")
			public String processUpdatetopoForm(Topo topo, BindingResult result, @PathVariable("topoId")  Integer topoId  ) {
				if (result.hasErrors()) {
					return VIEWS_TOPO_CREATE_OR_UPDATE_FORM;
				} else {

					Topo topoToModify = this.escaladeService.findTopoById(topoId);			
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
			
			@RequestMapping("/topos/{topoId}/sites/{siteId}")
			public ModelAndView showtopo(@PathVariable("topoId") Integer topoId) {
				ModelAndView mav = new ModelAndView("topos/topoDetails");
				mav.addObject(this.escaladeService.findTopoById(topoId));		
				return mav;
			}
			
			
			
			
			
}
