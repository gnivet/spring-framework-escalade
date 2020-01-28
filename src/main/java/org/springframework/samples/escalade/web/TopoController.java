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
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Guillaume Nivet 
 */
@Controller
@RequestMapping("/users/{userId}")
public class TopoController {

	private static final String VIEWS_TOPOS_CREATE_OR_UPDATE_FORM = "topos/createOrUpdateTopoForm";
	private final EscaladeService escaladeService;

	@Autowired
	public TopoController(EscaladeService escaladeService) {
		this.escaladeService = escaladeService;
	}

	@ModelAttribute("types")
	public Collection<TopoType> populatetopoTypes() {
		return this.escaladeService.findTopoTypes();
	}

	@ModelAttribute("user")
	public User findUser(@PathVariable("userId") int userId) {
		return this.escaladeService.findUserById(userId);
	}

	@InitBinder("user")
	public void inituserBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@InitBinder("topo")
	public void inittopoBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new TopoValidator());
	}

	@RequestMapping(value = "/topos/new", method = RequestMethod.GET)
	public String initCreationForm(User user, ModelMap model) {
		Topo topo = new Topo();
		user.addTopo(topo);
		model.put("topo", topo);
		return VIEWS_TOPOS_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/topos/new", method = RequestMethod.POST)
	public String processCreationForm(User user, @Valid Topo topo, BindingResult result, ModelMap model) {
		if (StringUtils.hasLength(topo.getName()) && topo.isNew() && user.getTopo(topo.getName(), true) != null) {
			result.rejectValue("name", "duplicate", "already exists");
		}
		if (result.hasErrors()) {
			model.put("topo", topo);
			return VIEWS_TOPOS_CREATE_OR_UPDATE_FORM;
		} else {
			user.addTopo(topo);
			this.escaladeService.saveTopo(topo);
			return "redirect:/users/{userId}";
		}
	}

	@RequestMapping(value = "/topos/{topoId}/edit", method = RequestMethod.GET)
	public String initUpdateForm(@PathVariable("topoId") int topoId, ModelMap model) {
		Topo topo = this.escaladeService.findTopoById(topoId);
		model.put("topo", topo);
		return VIEWS_TOPOS_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/topos/{topoId}/edit", method = RequestMethod.POST)
	public String processUpdateForm(@Valid Topo topo, BindingResult result, User user, ModelMap model) {
		if (result.hasErrors()) {
			model.put("topo", topo);
			return VIEWS_TOPOS_CREATE_OR_UPDATE_FORM;
		} else {
			user.addTopo(topo);
			this.escaladeService.saveTopo(topo);
			return "redirect:/users/{userId}";
		}
	}

	// @SuppressWarnings("null")
	@RequestMapping(value = "/areas", method = RequestMethod.GET)
	public String processFindForm(Area area, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /users to return all records

		if (area.getPostalcode() == null) {
			area.setPostalcode(""); // empty string signifies broadest possible search
		}

		// find topos by postal code
		Collection<Area> results = this.escaladeService.findSiteByPostalCode(area.getPostalcode());
		if (results.isEmpty()) {
			// no users found
			result.rejectValue("postalcode", "notFound", "not found");
			return "areas/areas";
		} else if (results.size() == 1) {
			// 1 user found
			area = results.iterator().next();
			return "redirect:/areas/" + area.getId();
		} else {
			// multiple users found
			model.put("selections", results);
			return "areas/toposList";
		}

	}

}