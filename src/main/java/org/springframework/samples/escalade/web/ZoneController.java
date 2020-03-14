 
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


import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Guillaume Nivet 
 */
@Controller
public class ZoneController {

	private static final String VIEWS_ZONE_CREATE_OR_UPDATE_FORM = "zones/createOrUpdateZoneForm";
	private final EscaladeService escaladeService;

	@Autowired
	public ZoneController(EscaladeService escaladeService) {
		this.escaladeService = escaladeService;
	}

	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	
	
	

	@RequestMapping(value = "/zones/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model   ) {
		
		Zone zone = new Zone();
		model.put("zone", zone);
		return VIEWS_ZONE_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/zones/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Zone zone, BindingResult result ) {
		
		if (result.hasErrors()) {
			return VIEWS_ZONE_CREATE_OR_UPDATE_FORM;
		} else {
			zone = this.escaladeService.saveZone(zone);
			return "redirect:/zones/" +  zone.getId();
		}
	}

	@RequestMapping(value = "/zones/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("zone", new Zone());
		return "zones/findSites";
		// return "zones/{zoneId}";
	}

//findTopos
	@RequestMapping(value = "/zones", method = RequestMethod.GET)
	public String processFindForm(Zone zone, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /zones to return all records
		if (zone.getName() == null) {
			zone.setName(""); // empty string signifies broadest possible search
		}

		// find zones by postal code
		Collection<Zone> results = this.escaladeService.findZoneByName(zone.getName());
		if (results.isEmpty()) {
			// no zones found
			result.rejectValue("postalcode", "notFound", "not found");
			return "zones/findZones";
			/*
			 * } else if (results.size() == 1) { // 1 zone found zone =
			 * results.iterator().next(); return "redirect:/zones/" + zone.getId();
			 */
		} else {
			// multiple zones found
			model.put("selections", results);
			return "zones/sitesList";
		}
	}

	@RequestMapping(value = "/zones/{zoneId}/edit", method = RequestMethod.GET)
	public String initUpdatezoneForm(@PathVariable("id") int id, Model model) {
		Zone zone = this.escaladeService.findZoneById(id);
		model.addAttribute(zone);
		return VIEWS_ZONE_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/zones/{zoneId}/edit", method = RequestMethod.POST)
	public String processUpdatezoneForm(Zone zone, BindingResult result, @PathVariable("zoneId") Integer zoneId) {
		if (result.hasErrors()) {
			return VIEWS_ZONE_CREATE_OR_UPDATE_FORM;
		} else {
			zone.setId(zoneId);
			this.escaladeService.saveZone(zone);
			return "redirect:/zones/{zoneId}";
		}
	}

	/**
	 * Custom handler for displaying an zone.
	 *
	 * @param zoneId the ID of the zone to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/zones/{zoneId}")
	public ModelAndView showzone(@PathVariable("zoneId") int zoneId) {
		ModelAndView mav = new ModelAndView("zones/zoneDetails");
		mav.addObject(this.escaladeService.findZoneById(zoneId));
		return mav;
	}

}
