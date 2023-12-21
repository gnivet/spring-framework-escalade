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
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Way;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Guillaume Nivet 
 */

@Controller
@Transactional
public class LengthController {

	private static final String VIEWS_LENGTH_CREATE_OR_UPDATE_FORM = "lengths/createOrUpdateLengthForm";
	private final EscaladeService escaladeService;

	private UserRepository userRepository;

	@Autowired
	public LengthController(EscaladeService escaladeService , UserRepository userRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
	}

	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	

	@RequestMapping(value = "/ways/{wayId}/lengths/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model , Principal principal  ) {
		
		String userName = principal.getName();
		
		@SuppressWarnings("unused")
		User user = this.userRepository.findByUserName(userName);
		 
		
		Length length = new Length();
		model.put("length", length);
		return VIEWS_LENGTH_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/ways/{wayId}/lengths/new", method = RequestMethod.POST)
	public String processCreationForm(Principal principal, @Valid Length length, Integer wayId, BindingResult result , Model model, Way way) {
		
		if (result.hasErrors()) {
			return VIEWS_LENGTH_CREATE_OR_UPDATE_FORM;
		} else {
			
			model.addAttribute("length",way.getId())		;
		
		    length = this.escaladeService.saveLength(length);
			return "redirect:/ways/{wayId}/lengths/new" ;
		}
	}

	@RequestMapping(value = "/lengths/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("length", new Length());
		return "lengths/findLengths";
		// return "lengths/{lengthId}";
	}

//findTopos
	@RequestMapping(value = "/lengths", method = RequestMethod.GET)
	public String processFindForm(Length length, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /lengths to return all records
		if (length.getName() == null) {
			length.setName(""); // empty string signifies broadest possible search
		}

		// find lengths by postal code
		Collection<Length> results = this.escaladeService.findLengthByName(length.getName());
		if (results.isEmpty()) {
			// no lengths found
			result.rejectValue("name", "notFound", "not found");
			return "lengths/findLengths";
			/*
			 * } else if (results.size() == 1) { // 1 length found length =
			 * results.iterator().next(); return "redirect:/lengths/" + length.getId();
			 */
		} else {
			// multiple lengths found
			model.put("selections", results);
			return "lengths/lengthsList";
			
		}
	}

	@GetMapping(value = "/lengths/{lengthId}")
	public String initUpdatelengthForm(@PathVariable("lengthId") Integer lengthId, Model model) {
		Length length = this.escaladeService.findLengthById(lengthId);
		model.addAttribute(length);
		return VIEWS_LENGTH_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/lengths/{lengthId}")
	public String processUpdatelengthForm(Length length, BindingResult result, @PathVariable("lengthId") Integer lengthId) {
		if (result.hasErrors()) {
			return VIEWS_LENGTH_CREATE_OR_UPDATE_FORM;
		} else {			
			length.setId(lengthId);
			this.escaladeService.saveLength(length);
			return "redirect:/lengths/{lengthId}";
		}
	}

	/*
	@GetMapping(value = "/lengths/{lengthId}/points/new")
	public String initUpdatelengthForm2(@PathVariable("lengthId") Integer lengthId, Model model) {
		Length length = this.escaladeService.findLengthById(lengthId);
		model.addAttribute(length);
		return VIEWS_LENGTH_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/lengths/{lengthId}/points/new")
	public String processUpdatelengthForm2(Length length, BindingResult result, @PathVariable("lengthId") Integer lengthId) {
		if (result.hasErrors()) {
			return VIEWS_LENGTH_CREATE_OR_UPDATE_FORM;
		} else {			
			length.setId(lengthId);
			this.escaladeService.saveLength(length);
			return "redirect:/lengths/{lengthId}/points";
		}
	}
	*/
	
	
	/**
	 * Custom handler for displaying an length.
	 *
	 * @param lengthId the ID of the length to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/lengths/{lengthId}")
	public ModelAndView showlength(@PathVariable("lengthId") Integer lengthId) {
		ModelAndView mav = new ModelAndView("lengths/lengthDetails");
		mav.addObject(this.escaladeService.findLengthById(lengthId));
		return mav;
	}

}

