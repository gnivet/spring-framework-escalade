package org.springframework.samples.escalade.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteTypeController {

	private static final String VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM = "sitetypes/createOrUpdateSiteTypeForm";
	private final EscaladeService escaladeService;

	@Autowired
	public SiteTypeController(EscaladeService escaladeService) {
		this.escaladeService = escaladeService;
	}
	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
		
	
	@GetMapping(value = "/sitetypes/new")
    public String initCreationForm(Map<String, Object> model) {
        SiteType siteType = new SiteType();
        model.put("sitetype", siteType);
        return VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM;
    }
    @PostMapping(value = "/sitetypes/new")
    public String processCreationForm(@Valid SiteType siteType, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM;
        } else {
           
			
        	siteType = this.escaladeService.saveSiteType(siteType);
			
            return "redirect:/sitetypes/" + siteType.getId();
        }
    }
       
    @RequestMapping(value = "/sitetypes/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("/sitetypes", new SiteType());
		return "sitetypes/find/siteTypes";
		// return "areas/{areaId}";
	}

//findSite
	@RequestMapping(value = "/sitetypes", method = RequestMethod.GET)
	public String processFindForm(SiteType siteType, BindingResult result, Map<String, Object> model) {

		if (siteType.getName() == null) {
			siteType.setName(""); // empty string signifies broadest possible search
		}

		
		
		// find areas by postal code
		Collection<SiteType> results = this.escaladeService.findSiteBySiteType(siteType.getName());
		if (results.isEmpty()) {
			// no areas found
			result.rejectValue("siteType", "notFound", "not found");
			return "siteTypes/findSiteTypes";
			/*
			 * } else if (results.size() == 1) { // 1 area found area =
			 * results.iterator().next(); return "redirect:/areas/" + area.getId();
			 */
		} else {
			// multiple areas found
			model.put("selections", results);
			return "sitetypes/sitesList";
		}
	}

	@RequestMapping(value = "/sitetypes/{siteTypeId}/edit", method = RequestMethod.GET)
	public String initUpdateSiteTypeForm(@PathVariable("siteTypeId") int siteTypeId, Model model) {
		SiteType siteType = this.escaladeService.findSiteTypeById(siteTypeId);
		model.addAttribute(siteType);
		return VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/sitetypes/{siteTypeId}/edit", method = RequestMethod.POST)
	public String processUpdateSiteTypeForm(SiteType siteType, BindingResult result, @PathVariable("siteTypeId") Integer siteTypeId) {
		if (result.hasErrors()) {
			return VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM;
		} else {
			siteType.setId(siteTypeId);
			this.escaladeService.saveSiteType(siteType);
			return "redirect:/siteTypes/{siteTypeId}";
		}
	}

	/**
	 * Custom handler for displaying an area.
	 *
	 * @param areaId the ID of the area to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@GetMapping("/sitetypes/{siteTypeId}")
	public ModelAndView showSiteType(@PathVariable("siteTypeId") int siteTypeId) {
		ModelAndView mav = new ModelAndView("sitetypes/siteTypeDetails");
		mav.addObject("sitetypes",this.escaladeService.findSiteTypeById(siteTypeId));
		return mav;
	}

	
}
