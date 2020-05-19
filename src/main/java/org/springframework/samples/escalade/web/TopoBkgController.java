package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.samples.escalade.repository.TopoBkgRepository;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
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
	private TopoRepository topoRepository;
	private SiteRepository siteRepository;
	
	
	
	@Autowired
	public TopoBkgController(EscaladeService escaladeService, UserRepository userRepository
			,TopoBkgRepository topoBkgRepository , TopoRepository topoRepository, SiteRepository siteRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;		
		this.topoBkgRepository = topoBkgRepository;
		this.topoRepository = topoRepository;
		this.siteRepository = siteRepository;
		
	}
	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	
			@GetMapping(value = "/topos/{topoId}/topoBkgs/new")
			public String initCreationForma(ModelMap model, Principal principal, @PathVariable Integer topoId  ) {
			
				if (principal != null)
				 {
				 String username = principal.getName();
				 
				 User user = this.userRepository.findByUsername(username);
				 model.addAttribute("firstName" , user.getFirstName() );
				 
				 }
				
				TopoBkg topoBkg = new TopoBkg();
				model.put("topoBkg", topoBkg);
				
				//Input topo
				
				Topo topo = this.topoRepository.findTopoById(topoId);
				if (topo == null || topo.equals(" ") )
		        {
		        	System.out.println("topo est null" + model + topo);
		        }
			model.put("topo", topo);
				
				
				return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
			}

			/**************************************************************************************
			 * Choose your Topo booking
			 * @param Boolean 
			 **************************************************************************************/
			
			
			@PostMapping(value = "/topos/{topoId}/topoBkgs/new")
			public String processCreationForm( ModelMap model, Principal principal, @PathVariable Integer topoId,  TopoBkg topoBkg, Site site, BindingResult result, Boolean bool_flag) {
				

		 		if (principal.getName() != null)
		 		{
		 			String userName = principal.getName();
		 			User user = this.userRepository.findByUsername(userName);
		 			site.setUser(user);
		 			
		 		}else
		 		{	
		 			 return "redirect:/users/login/";
		 		}
				
				/**
				 * Retrieve a <code>User</code> from the data store by id.
				 *
				 * @param userName the userName to search for
				 * @return the <code>User</code> if found
				 * @throws org.springframework.dao.DataRetrievalFailureException if not found
				 */
			
			
		 		Topo topo = this.topoRepository.findTopoById(topoId);
		 		
				
				
				if (result.hasErrors()) {
					return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
				} else {
						
					System.out.println(topo.getId());	
					
					this.topoBkgRepository.checkToposBookedByID(topo.getId(), bool_flag);
					
					
					
					topoBkg.setTopo(topo);	
					
					
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

			
				
			@GetMapping(value = "/topos/{topoId}/topoBkgs/{topoBkgId}")
			public String initUpdatetopoBkgForm(@NotNull @PathVariable("topoBkgId") Integer topoBkgId, @PathVariable("topoId") Integer topoId,  @NotNull ModelMap model) {
				TopoBkg topoBkg = this.escaladeService.findTopoBkgById(topoBkgId);
				model.put("topoBkg" , topoBkg);
				return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
			}

			
			@PostMapping(value = "/topos/{topoId}/topoBkgs/{topoBkgId}")
			public String processUpdatetopoBkgForm(TopoBkg topoBkg, BindingResult result, @PathVariable("topoBkgId")  Integer topoBkgId, @PathVariable("topoId") Integer topoId, ModelMap model, User user ) {
				if (result.hasErrors()) {
					model.put("topoBkg", topoBkg);
					return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
				} else {

					/*
					 * user.addSite(site);
            			this.escaladeService.saveSite(site);
            	return "redirect:/sites/{siteId}";
					 */
					
					user.addTopoBkg(topoBkg);
					this.escaladeService.saveTopoBkg(topoBkg);
					
					
					//TopoBkg topoBkgToModify = this.escaladeService.findTopoBkgById(topoBkgId);			
					//topoBkgToModify.setName(topoBkg.getName());
					//topoBkgToModify.setAccepted(topoBkg.getAccepted());
								
					//this.escaladeService.updateTopoBkg(topoBkgToModify);			
					return "redirect:/topoBkgs/{topoBkgId}";
				}
			}

			/**
			 * Custom handler for displaying an topo.
			 *
			 * @param topoId the ID of the topo to display
			 * @return a ModelMap with the model attributes for the view
			 */
			
			@RequestMapping("/topoBkgs/{topoBkgId}")
			public ModelAndView showtopoBkg(@PathVariable("topoBkgId") Integer topoBkgId) {
				ModelAndView mav = new ModelAndView("topoBkgs/topoBkgDetails");
				mav.addObject(this.escaladeService.findTopoBkgById(topoBkgId));		
				return mav;
			}
			
			
					
			
			

			
}

