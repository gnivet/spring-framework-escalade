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
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.SiteRepository;
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


/**
 * @author Guillaume Nivet
 */
@Controller
@Transactional
public class AreaController {

	private static final String VIEWS_AREA_CREATE_OR_UPDATE_FORM = "areas/createOrUpdateAreaForm";
	private final EscaladeService escaladeService;
	
	private UserRepository userRepository;
	private AreaRepository areaRepository;
	private SiteRepository siteRepository;

	@Autowired
	public AreaController(EscaladeService escaladeService, UserRepository userRepository, AreaRepository areaRepository,
			SiteRepository siteRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
		this.areaRepository = areaRepository;
		this.siteRepository = siteRepository;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping(value = "/areas/new")
	public String initCreationForm(Map<String, Object> model) {

		Area area = new Area();
		model.put("area", area);
		return VIEWS_AREA_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/areas/new")
	public String processCreationForm( @ModelAttribute("area") @Valid Area area,  BindingResult result, Integer areaId, Map<String, Object> model ,Principal principal,  Integer siteId) {
		
		
		//public String processCreationForm(@ModelAttribute("topoBkg") @Valid TopoBkg topoBkg, BindingResult result,
		//		Model model, Principal principal, @PathVariable Integer topoId) {	
		
		
		
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
			return VIEWS_AREA_CREATE_OR_UPDATE_FORM;
		} else {
				
			model.put("area", area);				
			area.setUser(user);
			area = this.escaladeService.saveArea(area);			
			return "redirect:/areas/" +  area.getId() ;
			
		}
	}
	

	
	

	@GetMapping(value = "/areas/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("area", new Area());
		return "/areas/findAreas";

	}
	
	

	

	
	@GetMapping(value = "/areas")
	public String processFindForm(Area area, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /areas to return all records
		if (area.getPostalcode() == null) {
			area.setPostalcode(""); // empty string signifies broadest possible search
		}

		// find areas by postal code
		Collection<Area> results = this.escaladeService.findSiteByPostalCode(area.getPostalcode());

		if (results.isEmpty()) {
			// no areas found
			result.rejectValue("postalcode", "notFound", "not found");
			return "/areas/findAreas";			

		} else {
			// multiple areas found
			model.put("selections", results);			
		 return "areas/areasList";
		}

	}

	
	@GetMapping(value = "/areas/{areaId}")
	public String initUpdateAreaForm(@NotNull @PathVariable("areaId") Integer   areaId, @NotNull Model model) {
		Area area = this.escaladeService.findAreaById(areaId);
		model.addAttribute(area);
		
		
		
		
		return VIEWS_AREA_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/areas/{areaId}")
	public String processUpdateAreaForm(Area area, BindingResult result, @PathVariable("areaId")  Integer areaId  ) {
		if (result.hasErrors()) {
			return VIEWS_AREA_CREATE_OR_UPDATE_FORM;
		} else {

			Area areaToModify = this.escaladeService.findAreaById(areaId);			
			areaToModify.setCity(area.getCity());
			areaToModify.setCountry(area.getCountry());
			areaToModify.setGpscoordinate(area.getGpscoordinate());
			areaToModify.setPostalcode(area.getPostalcode());
			areaToModify.setStreet(area.getStreet());
			areaToModify.setName(area.getName());				
			this.escaladeService.updateArea(areaToModify);			
			return "redirect:/areas/{areaId}";
		}
	}

	/**
	 * Custom handler for displaying an area.
	 *
	 * @param areaId the ID of the area to display
	 * @return a ModelMap with the model attributes for the view
	 */
	
	@RequestMapping("/areas/{areaId}/sites/{siteId}")
	public ModelAndView showArea(@PathVariable("areaId") Integer areaId) {
		ModelAndView mav = new ModelAndView("areas/areaDetails");
		mav.addObject(this.escaladeService.findAreaById(areaId));		
		return mav;
	}
	
}
