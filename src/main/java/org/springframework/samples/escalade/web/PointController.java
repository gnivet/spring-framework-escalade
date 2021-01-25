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
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.LengthRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Guillaume Nivet 
 */
@Controller
public class PointController {

	private static final String VIEWS_POINT_CREATE_OR_UPDATE_FORM = "points/createOrUpdatePointForm";
	private final EscaladeService escaladeService;
	private UserRepository userRepository;
	@Autowired
	public PointController(EscaladeService escaladeService , UserRepository userRepository, LengthRepository lengthRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
	}

	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	
	
	@GetMapping(value = "/lengths/{lengthId}/points/new")
	public String initCreationForm(Map<String, Object> 
	model ,  Principal principal, @PathVariable("lengthId") Integer lengthId)   {
	
		String userName = principal.getName();
	
	
		User user = this.userRepository.findByUserName(userName);
		
		
		Point point = new Point();
		model.put("point", point);
		return VIEWS_POINT_CREATE_OR_UPDATE_FORM;
	}

	
	
	
	
	@PostMapping(value = "/lengths/{lengthId}/points/new")
	public String processCreationForm(Principal principal, @Valid Point point , 
			@PathVariable("lengthId") Integer lengthId, BindingResult result ,  
	Model model, Length length )
	{
		
		
		String userName = principal.getName();

		/**
		 * Retrieve a <code>User</code> from the data store by id.
		 *
		 * @param userName the userName to search for
		 * @return the <code>User</code> if found
		 * @throws org.springframework.dao.DataRetrievalFailureException if not found
		 */

		User user = this.userRepository.findByUserName(userName);
		
		
		
		if (result.hasErrors()) {
			return VIEWS_POINT_CREATE_OR_UPDATE_FORM;
		} else {
			
			
			
			model.addAttribute("point",length.getId());
			point = this.escaladeService.savePoint(point);
			
			
			
			//this.escaladeService.updatePoint(point);
			return "redirect:/lengths/{lengthId}/points/new" ;
		}
	}

	
	
	@GetMapping(value = "/points/find")
	public String initFindForm(Map<String, Object> model ) {
		model.put("point", new Point());
		return "points/findPoints";
		// return "points/{pointId}";
	}

//findTopos
	@RequestMapping(value = "/points", method = RequestMethod.GET)
	public String processFindForm(Point point, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /points to return all records
		if (point.getName() == null) {
			point.setName(""); // empty string signifies broadest possible search
		}

		// find points by postal code
		Collection<Point> results = this.escaladeService.findPointByName(point.getName());
		if (results.isEmpty()) {
			// no points found
			result.rejectValue("name", "notFound", "not found");
			return "points/findPoints";
			/*
			 * } else if (results.size() == 1) { // 1 point found point =
			 * results.iterator().next(); return "redirect:/points/" + point.getId();
			 */
		} else {
			// multiple points found
			model.put("selections", results);
			return "points/pointsList";
		}
	}

	@GetMapping(value = "/points/{pointId}")
	public String initUpdatepointForm(@PathVariable("pointId") Integer pointId, Model model) {
		Point point = this.escaladeService.findPointById(pointId);
		model.addAttribute(point);
		return VIEWS_POINT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/points/{pointId}")
	public String processUpdatepointForm(Point point, BindingResult result, @PathVariable("pointId") Integer pointId, ModelMap model) {
		if (result.hasErrors()) {
			return VIEWS_POINT_CREATE_OR_UPDATE_FORM;
		} else {			
			point.setId(pointId);
			this.escaladeService.savePoint(point);
			return "redirect:/points/{pointId}";
		}
	}

	
	
	
	/**
	 * Custom handler for displaying an point.
	 *
	 * @param pointId the ID of the point to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/points/{pointId}")
	public ModelAndView showpoint(@PathVariable("pointId") Integer pointId) {
		ModelAndView mav = new ModelAndView("points/pointDetails");
		mav.addObject(this.escaladeService.findPointById(pointId));
		return mav;
	}

}
