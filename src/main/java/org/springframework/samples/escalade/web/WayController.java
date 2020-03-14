 
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
import org.springframework.samples.escalade.model.Way;
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
public class WayController {

	private static final String VIEWS_WAY_CREATE_OR_UPDATE_FORM = "ways/createOrUpdateWayForm";
	private final EscaladeService escaladeService;

	@Autowired
	public WayController(EscaladeService escaladeService) {
		this.escaladeService = escaladeService;
	}

	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	
	
	

	@RequestMapping(value = "/ways/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model   ) {
		
		Way way = new Way();
		model.put("way", way);
		return VIEWS_WAY_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/ways/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Way way, BindingResult result ) {
		
		if (result.hasErrors()) {
			return VIEWS_WAY_CREATE_OR_UPDATE_FORM;
		} else {
			way = this.escaladeService.saveway(way);
			return "redirect:/ways/" +  way.getId();
		}
	}

	@RequestMapping(value = "/ways/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("way", new Way());
		return "ways/findSites";
		// return "ways/{wayId}";
	}

//findTopos
	@RequestMapping(value = "/ways", method = RequestMethod.GET)
	public String processFindForm(Way way, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /ways to return all records
		if (way.getName() == null) {
			way.setName(""); // empty string signifies broadest possible search
		}

		// find ways by postal code
		Collection<Way> results = this.escaladeService.findWayByName(way.getName());
		if (results.isEmpty()) {
			// no ways found
			result.rejectValue("postalcode", "notFound", "not found");
			return "ways/findways";
			/*
			 * } else if (results.size() == 1) { // 1 way found way =
			 * results.iterator().next(); return "redirect:/ways/" + way.getId();
			 */
		} else {
			// multiple ways found
			model.put("selections", results);
			return "ways/sitesList";
		}
	}

	@RequestMapping(value = "/ways/{wayId}/edit", method = RequestMethod.GET)
	public String initUpdatewayForm(@PathVariable("id") int id, Model model) {
		Way way = this.escaladeService.findWayById(id);
		model.addAttribute(way);
		return VIEWS_WAY_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/ways/{wayId}/edit", method = RequestMethod.POST)
	public String processUpdatewayForm(Way way, BindingResult result, @PathVariable("wayId") Integer wayId) {
		if (result.hasErrors()) {
			return VIEWS_WAY_CREATE_OR_UPDATE_FORM;
		} else {
			way.setId(wayId);
			this.escaladeService.saveway(way);
			return "redirect:/ways/{wayId}";
		}
	}

	/**
	 * Custom handler for displaying an way.
	 *
	 * @param wayId the ID of the way to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/ways/{wayId}")
	public ModelAndView showway(@PathVariable("wayId") int wayId) {
		ModelAndView mav = new ModelAndView("ways/wayDetails");
		mav.addObject(this.escaladeService.findWayById(wayId));
		return mav;
	}

}
