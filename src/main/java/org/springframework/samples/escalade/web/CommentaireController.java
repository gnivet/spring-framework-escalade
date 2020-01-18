 
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
import org.springframework.samples.escalade.model.Commentaire;
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
public class CommentaireController {

	private static final String VIEWS_COMMENTAIRE_CREATE_OR_UPDATE_FORM = "commentaires/createOrUpdateCommentaireForm";
	private final EscaladeService escaladeService;

	@Autowired
	public CommentaireController(EscaladeService escaladeService) {
		this.escaladeService = escaladeService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/commentaires/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		Commentaire commentaire = new Commentaire();
		model.put("commentaire", commentaire);
		return VIEWS_COMMENTAIRE_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/commentaires/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Commentaire commentaire, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_COMMENTAIRE_CREATE_OR_UPDATE_FORM;
		} else {
			this.escaladeService.saveCommentaire(commentaire);
			return "redirect:/commentaires/" + commentaire.getId();
		}
	}

	@RequestMapping(value = "/commentaires/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("commentaire", new Commentaire());
		return "commentaires/findTopos";
		// return "commentaires/{commentaireId}";
	}

//findTopos
	@RequestMapping(value = "/commentaires", method = RequestMethod.GET)
	public String processFindForm(String commentaire, BindingResult result, Map<String, Object> model) {
		
		// allow parameterless GET request for /commentaires to return all records
		/*
		if (commentaire.getCommentaire() == null) {
			commentaire.setCommentaire(""); // empty string signifies broadest possible search
			
		}
		*/
		
		
		// find commentaires by postal code
		Collection<Commentaire> results = this.escaladeService.findSiteByName(commentaire);
		if (results.isEmpty()) {
			// no commentaires found
			result.rejectValue("postalcode", "notFound", "not found");
			return "commentaires/findTopos";
			/*
			 * } else if (results.size() == 1) { // 1 commentaire found commentaire =
			 * results.iterator().next(); return "redirect:/commentaires/" + commentaire.getId();
			 */
		} else {
			// multiple commentaires found
			model.put("selections", results);
			return "commentaires/toposList";
		}
	}

	@RequestMapping(value = "/commentaires/{commentaireId}/edit", method = RequestMethod.GET)
	public String initUpdatecommentaireForm(@PathVariable("commentaireId") Long commentaireId, Model model) {
		Commentaire commentaire = this.escaladeService.findCommentaireById(commentaireId);
		model.addAttribute(commentaire);
		return VIEWS_COMMENTAIRE_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/commentaires/{commentaireId}/edit", method = RequestMethod.POST)
	public String processUpdatecommentaireForm(@Valid Commentaire commentaire, BindingResult result, @PathVariable("commentaireId") long commentaireId) {
		if (result.hasErrors()) {
			return VIEWS_COMMENTAIRE_CREATE_OR_UPDATE_FORM;
		} else {
			commentaire.setId(commentaireId);
			this.escaladeService.saveCommentaire(commentaire);
			return "redirect:/commentaires/{commentaireId}";
		}
	}

	/**
	 * Custom handler for displaying an commentaire.
	 *
	 * @param commentaireId the ID of the commentaire to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/commentaires/{commentaireId}")
	public ModelAndView showcommentaire(@PathVariable("commentaireId") int commentaireId) {
		ModelAndView mav = new ModelAndView("commentaires/commentaireDetails");
		mav.addObject(this.escaladeService.findCommentaireById(commentaireId));
		return mav;
	}

}

