package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.escaladeException;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.samples.escalade.repository.TopoBkgRepository;
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
public class TopoBkgController {

	private static final Logger logger = LoggerFactory.getLogger(TopoBkgController.class);
	private static final String VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM = "topoBkgs/createOrUpdateTopoBkgForm";
	private EscaladeService escaladeService;
	private UserRepository userRepository;
	private TopoBkgRepository topoBkgRepository;
	private TopoRepository topoRepository;
	private SiteRepository siteRepository;

	@Autowired
	public TopoBkgController(EscaladeService escaladeService, UserRepository userRepository,
			TopoBkgRepository topoBkgRepository, TopoRepository topoRepository, SiteRepository siteRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
		this.topoBkgRepository = topoBkgRepository;
		this.topoRepository = topoRepository;
		this.siteRepository = siteRepository;

	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
		//dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy/mm/dd"), false));
	}

	@GetMapping(value = "/topos/{topoId}/topoBkgs/new")
	public String initCreationForma(Map<String, Object> model, Principal principal, @PathVariable Integer topoId) {

		if (principal != null ) {
			
			Topo topo = new Topo();
			if (topoId != null) {
			topo = this.escaladeService.findTopoById(topoId);			
			
			TopoBkg topoBkg = new TopoBkg();			
			model.put("topoBkg", topoBkg);
			}else
			{				
				return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
			}
		}

		return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
	}

	/**************************************************************************************
	 * Choose your Topo booking
	 * 
	 * @param Boolean
	 **************************************************************************************/
	// @PostMapping("new")
	// public String newStudent(@ModelAttribute @Valid StudentForm form,
	// BindingResult bindingResult, Model model) {

	@PostMapping(value = "/topos/{topoId}/topoBkgs/new")
	public String processCreationForm(@ModelAttribute("topoBkg") @Valid TopoBkg topoBkg, BindingResult result,
			Model model, Principal principal, @PathVariable Integer topoId) {

		if (principal.getName() != null) {
			String userName = principal.getName();	
			
			
			User user = this.userRepository.findByUserName(userName);
			topoBkg.setUser(user);
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

		Topo topo = this.topoRepository.findTopoById(topoId);
		topoBkg.setTopo(topo);
		System.out.println("--------------------------" + topo.getName()+ "--------------------------");
		
		topo.setAvailable(false);
		logger.warn("A new topo has been booked " + topo.getName());
		if (result.hasErrors()) {
			return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
		} else {

			topoBkg = this.escaladeService.saveTopoBkg(topoBkg);
			if(topoBkg == null)
			{
				return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
			}
			return "redirect:/topoBkgs/" + topoBkg.getId();
		}

	}

	@GetMapping(value = "/topoBkgs/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("topoBkg", new TopoBkg());
		//model.put("topo", new Topo());
		return "/topoBkgs/findTopoBkgs";

	}
	
	@GetMapping(value = "/topoBkgs")
	public String processFindForm(TopoBkg topoBkg, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /areas to return all records
		if (topoBkg.getName() == null) {
			topoBkg.setName(""); // empty string signifies broadest possible search
		}

						
		// find  topoBkgs by name
		Collection<TopoBkg> results = this.escaladeService.findTopoBkgByName(topoBkg.getName());

		if (results.isEmpty()) {
			// no topoBkgs found
			result.rejectValue("name", "notFound", "not found");
			return "/topoBkgs/findTopoBkgs";

		} else {
			// multiple topos found
			model.put("selections", results);
			return "topoBkgs/topoBkgsList";
		}

	}
	
	@GetMapping(value = "/findTopoBkgsByUserName")
	public String findtopoBkgsByUserName (Model model,  TopoBkg topoBkg, BindingResult result, Principal principal ) {
	 String userName = principal.getName();
		
		 System.out.println("username-----------------------------:" + userName);
     User user = userRepository.findByUserName(userName);
    
     System.out.println("userId-----------------------------:"+  user.getId());
     System.out.println("username-----------------------------:"+ userName);
  // allow parameterless GET request for /areas to return all records
  		if (topoBkg.getName() == null) {
  			topoBkg.setName(""); // empty string signifies broadest possible search
  		}
  		System.out.println("username-----------------------------:"+ userName);
  						
  		// find  topoBkgs by name
  		
  		
  		
  		//Collection<TopoBkg> results = this.escaladeService.findTopoBkgByUserName(userName);
  		
  		Collection<TopoBkg> results = this.userRepository.getAllTopoBkgsUserName(userName);

  		if (results.isEmpty()) {
  			// no topoBkgs found
  			result.rejectValue("name", "notFound", "not found");
  			return "/topoBkgs/findTopoBkgs";

  		} else {
  			// multiple topos found
  			model.addAttribute("selections", results);
  			
  			return "topoBkgs/topoBkgsList";
  		}
	}
	
	/*
	
	@GetMapping(value = "/topoBkgs/{topoBkgId}")
	public String initUpdateTopoBkgForm(@NotNull  @PathVariable("topoBkgId") Integer topoBkgId, @NotNull Model model) {
			
		TopoBkg topoBkg = this.escaladeService.findSingleTopoBkgById(topoBkgId);		
		model.addAttribute("topoBkg", new TopoBkg());
		return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
	}
	*/
	
	
	 
	 
	 
	
	
	@PostMapping(value = "/topoBkgs/{topoBkgId}")
	public String processUpdateTopoBkgForm(TopoBkg topoBkg, BindingResult result, 
			@PathVariable("topoBkgId") Integer topoBkgId) throws escaladeException  
			 {
		if (result.hasErrors()) 
			{			
				return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
			}else
		
			{
				TopoBkg topoBkgToModify = this.escaladeService.findSingleTopoBkgById(topoBkgId);
				
				topoBkgToModify.setAccepted(topoBkg.getAccepted());
				topoBkgToModify.setBorrowDate(topoBkg.getBorrowDate());
				topoBkgToModify.setBorrowEndDate(topoBkg.getBorrowEndDate());
				topoBkgToModify.setInProgress(topoBkg.isInProgress());
				topoBkgToModify.setTopo(topoBkg.getTopo());
				//this.escaladeService.updateTopoBkg(topoBkgToModify);
				
								
				/*
				 * Check if topo already exits in topoBkg 
				 * If topo not exists the create operation will be done
				 */
				
				
				//List<TopoBkg> listTopoBkgs = this.topoBkgRepository.findByIdinIgnoreCaseIn(topoBkg.getTopo());
				@SuppressWarnings("unused")
				boolean boolean_flag = false;
				boolean_flag = this.topoBkgRepository.checkToposBookedByID(topoBkgId);
				
				System.out.println("--------------------------boolean_flag-----------------------");
				
				if (boolean_flag = true)
				{	
				this.escaladeService.updateTopoBkg(topoBkgToModify);
				}
				//user.addTopoBkg(topoBkg);
				//this.escaladeService.saveTopoBkg(topoBkg);
			
				
				
				
				
			return "redirect:/topoBkgs/{topoBkgId}";
			}
	}
	
	
	
	
	/**
	 * Custom handler for displaying an topo booking.
	 *
	 * @param topoId the ID of the topo to display
	 * @return a ModelMap with the model attributes for the view
	 */

	@RequestMapping("/topoBkgs/{topoBkgId}")
	public ModelAndView showtopoBkg(@PathVariable("topoBkgId") Integer topoBkgId) {
		ModelAndView mav = new ModelAndView("topoBkgs/topoBkgDetails");		
		mav.addObject(this.topoBkgRepository.getAllTopoBkgById(topoBkgId));
		return mav;
	}

	
	// http://localhost:8080/updtateTopoBkg?topoBkgId=18302
	//http://localhost:8080/topoBkgs/18302/?accepted=true
	
	@GetMapping("/topoBkgs/{topoBkgId}/{accepted}")
	public String Init(@PathVariable Integer topoBkgId, @PathVariable Boolean accepted, ServletRequest req) {
		req.setAttribute("topoBkg", escaladeService.findSingleTopoBkgById(topoBkgId));
		//req.setAttribute("topoBkg", topoBkgRepository.findOne(topoBkgId));
		String strAccepted = Boolean.toString(accepted);
		 req.setAttribute("strAccepted", strAccepted);
		
		//return "redirect:/topoBkgs/{topoBkgId}";
		return "topoBkgs/topoBkgsList";
	}
	
	
	@PostMapping("/topoBkgs/{topoBkgId}/{accepted}")
	public String Process(@PathVariable Integer topoBkgId, @PathVariable Boolean accepted, ServletRequest req) {
		req.setAttribute("topoBkg", escaladeService.findSingleTopoBkgById(topoBkgId));
		
		String strAccepted = Boolean.toString(accepted);
		req.getAttribute(strAccepted);
		
		//return "redirect:/topoBkgs/{topoBkgId}";
		return "topoBkgs/topoBkgsList";
	}
	
	
	/*
	 * http://localhost:8080/topoBkgs/18302/topos/18253/true
	 */
	
	

	@GetMapping(value = "/topoBkgs/{topoBkgId}/detail")
	public String initUpdateTopoBkgsForm(@NotNull @PathVariable("topoBkgId") Integer   topoBkgId, @NotNull Model model) {
		TopoBkg topoBkg = this.escaladeService.findSingleTopoBkgById(topoBkgId);
		model.addAttribute(topoBkg);
		return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
		//return "topoBkgs/topoBkgsList";
	}
		
	
	
	
	/*
	 * To book a topo
	 */
	
	//@GetMapping(value = "/topoBkgs/{topoBkgId}/topos/{topoId}/{accepted}")
	@GetMapping(value = "/tobook/topos/{topoId}")
    public String InitTopoBooked(  Model model,  Principal principal, @PathVariable Integer topoId ) {
		TopoBkg topoBkg = new TopoBkg();
				
		Topo topoTarget = this.topoRepository.findTopoById(topoId);	
		model.addAttribute("topoBkg" , topoBkg);
		model.addAttribute("topo", topoTarget);
		
        if (!topoTarget.isAvailable()){
            return "error";
        }
       
        //return "topoBkgs/topoBkgs";
        return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
    }
	
	

	
	//@PostMapping(value = "/topoBkgs/{topoBkgId}/topos/{topoId}/{accepted}")
	@PostMapping(value = "/tobook/topos/{topoId}")
    public String toBookTopo(@ModelAttribute TopoBkg topoBkg, Principal principal,  @PathVariable Integer topoId ) {
		
		
		/* if (result.hasErrors()) 
		{			
			return VIEWS_TOPOBKG_CREATE_OR_UPDATE_FORM;
		}else
	
		*/
		 String userName = principal.getName();
	     User user = userRepository.findByUserName(userName);
         topoBkg.setUser(user);
         Topo topo = topoRepository.findTopoById(topoId); 
         /*
         topo.setAvailable(true);
         topo.setCommentDate(topo.getCommentDate());
         topo.setDescription(topo.getDescription());
         topo.setId(topo.getId());
         topo.setName(topo.getName());
         */         
         this.escaladeService.saveTopo(topo);
        topoBkg.setTopo(topo);
        topoBkg.setBorrowDate(new Date());
        // the topo is booked by somenone 
		topoBkg.setInProgress(true);
		
		//topoBkg.setAccepted(accepted);
		
        
        this.escaladeService.saveTopoBkg(topoBkg);
       
		logger.warn("A new topo has been booked by " + user.getUserName() + " for topo " + topo.getName() );
		return "/welcome" ;
		
        //return "topoBkgs/topoBkgs";
    }
	
	
	
	
}
