/*
* Copyright 2002-2013 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.springframework.samples.escalade.web;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.SiteTypeRepository;
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


@Controller
@Transactional
public class SiteTypeController {

	private static final String VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM = "sitetypes/createOrUpdateSiteTypeForm";
	private final EscaladeService escaladeService;	
	private UserRepository userRepository;
	private SiteTypeRepository siteTypeRepository;

	@Autowired
	public SiteTypeController(EscaladeService escaladeService , UserRepository userRepository, SiteTypeRepository siteTypeRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
		this.siteTypeRepository = siteTypeRepository;
	}
	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	 
	
	@GetMapping(value = "/sitetypes/new")
    public String initCreationForm(Map<String, Object> model) {
        SiteType siteType = new SiteType();
        model.put("siteType", siteType);
        return VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM;
    }
	
	
    @PostMapping(value = "/sitetypes/new")
    public String processCreationForm( @Valid SiteType siteType, BindingResult result,  Principal principal) {
    	
    	String userName = principal.getName();
		
		
		/**
		 * Retrieve a <code>User</code> from the data store by id.
		 *
		 * @param userName the userName to search for
		 * @return the <code>User</code> if found
		 * @throws org.springframework.dao.DataRetrievalFailureException if not found
		 */

		
		User user = this.userRepository.findByUsername(userName);
		
    			     	
    	//siteType = this.siteTypeRepository.findSiteTypeById(siteTypeId);
        if (result.hasErrors()) {
            return VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM;
        } else {
           
        	
			
		
        	siteType = this.escaladeService.saveSiteType(siteType);
			
            return "redirect:/sitetypes/" + siteType.getId();
        }
    }
       
    @GetMapping(value = "/sitetypes/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("siteType", new SiteType());		
		 return "/sitetypes/findSiteTypes";
	}

      
//findSite
	@GetMapping(value = "/sitetypes")
	public String processFindForm(SiteType siteType, BindingResult result, Map<String, Object> model) {

		if (siteType.getName() == null) {
			siteType.setName(""); // empty string signifies broadest possible search
		}

		
		
		// find areas by postal code
		//Collection<SiteType> results = this.escaladeService.findSiteTypeByName(siteType.getName());
		Collection<SiteType> results = this.escaladeService.findSiteTypes();
		
		if (results.isEmpty()) {
			// no areas found
			result.rejectValue("name", "notFound", "not found");
			return "sitetypes/findSiteTypes";
			
		} else {
			// multiple areas found
			model.put("selections", results);
			return "sitetypes/siteTypesList";
		}
	}

	@GetMapping(value = "/sitetypes/{siteTypeId}")
	public String initUpdateSiteTypeForm(@PathVariable("siteTypeId") Integer siteTypeId, Model model) {
		SiteType siteType = this.escaladeService.findSiteTypeById(siteTypeId);
		model.addAttribute(siteType);
		return VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/sitetypes/{siteTypeId}")
	public String processUpdateSiteTypeForm(SiteType sitetype, BindingResult result, @PathVariable("siteTypeId") Integer siteTypeId) {
		if (result.hasErrors()) {
			return VIEWS_SITETYPE_CREATE_OR_UPDATE_FORM;
		} else {
			SiteType siteTypeToModify = this.escaladeService.findSiteTypeById(siteTypeId);
			siteTypeToModify.setName(sitetype.getName());
			sitetype.setId(siteTypeId);
			this.escaladeService.saveSiteType(sitetype);
			return "redirect:/siteTypes/{siteTypeId}";
		}
	}
	
	/**
	 * Custom handler for displaying an site type.
	 *
	 * @param areaId the ID of the area to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/sitetypes/{siteTypeId}")
	public ModelAndView showSiteType(@PathVariable("siteTypeId") Integer siteTypeId) {
		ModelAndView mav = new ModelAndView("sitetypes/siteTypeDetails");
		mav.addObject(this.escaladeService.findSiteTypeById(siteTypeId));
		return mav;
	}

	
}