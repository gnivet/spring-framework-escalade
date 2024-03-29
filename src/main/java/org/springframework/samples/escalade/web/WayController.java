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
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Guillaume Nivet
 */
@Controller
@Transactional
public class WayController {

	private static final String VIEWS_WAY_CREATE_OR_UPDATE_FORM = "ways/createOrUpdateWayForm";
	private final EscaladeService escaladeService;
	private UserRepository userRepository;

	@Autowired
	public WayController(EscaladeService escaladeService , UserRepository userRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
	}



	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}


	@GetMapping("/zones/{zoneId}/ways/new")
	public String initCreationForm(Map<String, Object> model, Principal principal   ) {


		String userName = principal.getName();

		@SuppressWarnings("unused")
		User user = this.userRepository.findByUserName(userName);


		Way way = new Way();
		model.put("way", way);
		return VIEWS_WAY_CREATE_OR_UPDATE_FORM;
	}
	/*
	@RequestMapping(value = "/zones/{zoneId}/ways/new", method = RequestMethod.POST)
	public String processCreationForm(Principal principal, @Valid Way way, Integer zoneId, BindingResult result, Model model, Zone zone ) {

		if (result.hasErrors()) {
			return VIEWS_WAY_CREATE_OR_UPDATE_FORM;
		} else {

			model.addAttribute("zone", zone.getId() );
			way = this.escaladeService.saveway(way);
			return "redirect:/zones/{zoneId}/ways/new";
		}
	}

	@RequestMapping(value = "/ways/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("way", new Way());
		return "ways/findWays";
		// return "ways/{wayId}";
	}
	*/
	
	@PostMapping("/sites/{siteId}/ways/new")
	public String processCreationForm2(Principal principal, @Valid Way way, Integer zoneId, BindingResult result, Model model, Site site ) {

		if (result.hasErrors()) {
			return VIEWS_WAY_CREATE_OR_UPDATE_FORM;
		} else {

			model.addAttribute("site", site.getId() );
			way = this.escaladeService.saveway(way);
			return "redirect:/sites/{siteId}/ways/new";
		}
	}

	@GetMapping("/ways/find")
	public String initFindForm2(Map<String, Object> model) {
		model.put("way", new Way());
		return "ways/findWays";
		// return "ways/{wayId}";
	}
	
	
	
//findTopos
	@GetMapping("/ways")
	public String processFindForm(Way way, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /ways to return all records
		if (way.getName() == null) {
			way.setName(""); // empty string signifies broadest possible search
		}

		// find ways by postal code
		Collection<Way> results = this.escaladeService.findWayByName(way.getName());
		if (results.isEmpty()) {
			// no ways found
			result.rejectValue("name", "notFound", "not found");
			return "ways/findWays";
			/*
			 * } else if (results.size() == 1) { // 1 way found way =
			 * results.iterator().next(); return "redirect:/ways/" + way.getId();
			 */
		} else {
			// multiple ways found
			model.put("selections", results);
			return "ways/waysList";
		}
	}

	@GetMapping("/ways/{wayId}")
	public String initUpdatewayForm(@PathVariable("wayId")
	Integer wayId, ModelMap model) {
		Way way = this.escaladeService.findWayById(wayId);
		model.put("way", way);
		return VIEWS_WAY_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/ways/{wayId}")
	public String processUpdatewayForm(Way way, BindingResult result, @PathVariable("wayId")
	Integer wayId, Length length ,ModelMap model ) {
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
	@RequestMapping(value = "/ways/{wayId}")
	public ModelAndView showway(@PathVariable("wayId") Integer wayId) {
		ModelAndView mav = new ModelAndView("ways/wayDetails");
		mav.addObject(this.escaladeService.findWayById(wayId));
		return mav;
	}

}
