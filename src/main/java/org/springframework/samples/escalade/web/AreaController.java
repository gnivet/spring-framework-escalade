 
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
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Guillaume Nivet 
 */
@Controller
public class AreaController {

	private static final String VIEWS_AREA_CREATE_OR_UPDATE_FORM = "areas/createOrUpdateAreaForm";
	private final EscaladeService escaladeService;

	@Autowired
	public AreaController(EscaladeService escaladeService) {
		this.escaladeService = escaladeService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/areas/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		Area area = new Area();
		model.put("area", area);
		return VIEWS_AREA_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/areas/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Area area, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_AREA_CREATE_OR_UPDATE_FORM;
		} else {
			this.escaladeService.saveArea(area);
			return "redirect:/areas/" + area.getId();
		}
	}

	@RequestMapping(value = "/areas/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("area", new Area());
		return "areas/findTopos";
		// return "areas/{areaId}";
	}

//findTopos
	@RequestMapping(value = "/areas", method = RequestMethod.GET)
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
			return "areas/findTopos";
			/*
			 * } else if (results.size() == 1) { // 1 area found area =
			 * results.iterator().next(); return "redirect:/areas/" + area.getId();
			 */
		} else {
			// multiple areas found
			model.put("selections", results);
			return "areas/toposList";
		}
	}

	@RequestMapping(value = "/areas/{areaId}/edit", method = RequestMethod.GET)
	public String initUpdateAreaForm(@PathVariable("areaId") int areaId, Model model) {
		Area area = this.escaladeService.findAreaById(areaId);
		model.addAttribute(area);
		return VIEWS_AREA_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/areas/{areaId}/edit", method = RequestMethod.POST)
	public String processUpdateAreaForm(Area area, BindingResult result, @PathVariable("areaId") Integer areaId) {
		if (result.hasErrors()) {
			return VIEWS_AREA_CREATE_OR_UPDATE_FORM;
		} else {
			area.setId(areaId);
			this.escaladeService.saveArea(area);
			return "redirect:/areas/{areaId}";
		}
	}

	/**
	 * Custom handler for displaying an area.
	 *
	 * @param areaId the ID of the area to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/areas/{areaId}")
	public ModelAndView showArea(@PathVariable("areaId") int areaId) {
		ModelAndView mav = new ModelAndView("areas/areaDetails");
		mav.addObject(this.escaladeService.findAreaById(areaId));
		return mav;
	}

}
