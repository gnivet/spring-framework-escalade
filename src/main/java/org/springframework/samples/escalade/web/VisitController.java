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

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Topo;
//import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Visit;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Guillaume Nivet
 * @author Guillaume Nivet
 * @author Guillaume Nivet
 * @author Guillaume Nivet
 */
@Controller
public class VisitController {

	private final EscaladeService EscaladeService;

	@Autowired
	public VisitController(EscaladeService EscaladeService) {
		this.EscaladeService = EscaladeService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/**
	 * Called before each and every @RequestMapping annotated method. 2 goals: -
	 * Make sure we always have fresh data - Since we do not use the session scope,
	 * make sure that topo object always has an id (Even though id is not part of
	 * the form fields)
	 *
	 * @param topoId
	 * @return topo
	 */
	@ModelAttribute("visit")
	public Visit loadtopoWithVisit(@PathVariable("topoId") int topoId) {
		Topo topo = this.EscaladeService.findTopoById(topoId);
		Visit visit = new Visit();
		topo.addVisit(visit);
		return visit;
	}

	// Spring MVC calls method loadaoWithVisit(...) before initNewVisitForm is
	// called
	@RequestMapping(value = "/users/*/topos/{topoId}/visits/new", method = RequestMethod.GET)
	public String initNewVisitForm(@PathVariable("topoId") int topoId, Map<String, Object> model) {
		return "topos/createOrUpdateVisitForm";
	}

	// Spring MVC calls method loadtopoWithVisit(...) before processNewVisitForm is
	// called
	@RequestMapping(value = "/users/{userId}/topos/{topoId}/visits/new", method = RequestMethod.POST)
	public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
		if (result.hasErrors()) {
			return "topos/createOrUpdateVisitForm";
		} else {
			this.EscaladeService.saveVisit(visit);
			return "redirect:/users/{userId}";
		}
	}

	@RequestMapping(value = "/users/*/topos/{topoId}/visits", method = RequestMethod.GET)
	public String showVisits(@PathVariable int topoId, Map<String, Object> model) {
		model.put("visits", this.EscaladeService.findTopoById(topoId).getVisits());
		return "visitList";
	}

	/**
	 * Called before each and every @RequestMapping annotated method. 2 goals: -
	 * Make sure we always have fresh data - Since we do not use the session scope,
	 * make sure that area object always has an id (Even though id is not part of
	 * the form fields)
	 *
	 * @param areaId
	 * @return area
	 */

	// /users/100/topos/101/visits/new
	/*
	 * 
	 */
	// @ModelAttribute("visit")
	// public Visit loadareaWithVisit(@PathVariable("areaId") int areaId) {
	// Area area = this.EscaladeService.findAreaById(areaId);
	// Visit visit = new Visit();
	// area.addVisit(visit);
	// return visit;
	// }

	// Spring MVC calls method loadtopoWithVisit(...) before initNewVisitForm is
	// called
	@RequestMapping(value = "/users/*/areas/{areaId}/visits/new", method = RequestMethod.GET)
	public String initNewVisitForm1(@PathVariable("areaId") int areaId, Map<String, Object> model) {
		return "areas/createOrUpdateVisitForm";
	}

	// Spring MVC calls method loadtopoWithVisit(...) before processNewVisitForm is
	// called
	@RequestMapping(value = "/users/{userId}/areas/{areaId}/visits/new", method = RequestMethod.POST)
	public String processNewVisitForm1(@Valid Visit visit, BindingResult result) {
		if (result.hasErrors()) {
			return "areas/createOrUpdateVisitForm";
		} else {
			this.EscaladeService.saveVisit(visit);
			return "redirect:/users/{userId}";
		}
	}

	@RequestMapping(value = "/users/*/areas/{areaId}/visits", method = RequestMethod.GET)
	public String showVisits1(@PathVariable int areaId, Map<String, Object> model) {
		model.put("visits", this.EscaladeService.findTopoById(areaId).getVisits());
		return "visitList";
	}

}
