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
import org.springframework.samples.escalade.model.Comment;
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
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 */
@Controller
public class CommentController {

	private static final String VIEWS_COMMENT_CREATE_OR_UPDATE_FORM = "comments/createOrUpdateCommentForm";
	private final EscaladeService escaladeService;

	@Autowired
	public CommentController(EscaladeService escaladeService) {
		this.escaladeService = escaladeService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/comments/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		Comment comment = new Comment();
		model.put("comment", comment);
		return VIEWS_COMMENT_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/comments/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Comment comment, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_COMMENT_CREATE_OR_UPDATE_FORM;
		} else {
			this.escaladeService.saveComment(comment);
			return "redirect:/comments/" + comment.getId();
		}
	}

	@RequestMapping(value = "/comments/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("comment", new Comment());
		return "comments/findTopos";
		// return "comments/{commentId}";
	}

//findTopos
	@RequestMapping(value = "/comments", method = RequestMethod.GET)
	public String processFindForm(Comment comment, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /comments to return all records
		if (comment.getName() == null) {
			comment.setName(""); // empty string signifies broadest possible search
		}

		// find comments by postal code
		Collection<Comment> results = this.escaladeService.findCommentByName(comment.getName());
		if (results.isEmpty()) {
			// no comments found
			result.rejectValue("postalcode", "notFound", "not found");
			return "comments/findTopos";
			/*
			 * } else if (results.size() == 1) { // 1 comment found comment =
			 * results.iterator().next(); return "redirect:/comments/" + comment.getId();
			 */
		} else {
			// multiple comments found
			model.put("selections", results);
			return "comments/toposList";
		}
	}

	@RequestMapping(value = "/comments/{commentId}/edit", method = RequestMethod.GET)
	public String initUpdateCommentForm(@PathVariable("commentId") int commentId, Model model) {
		Comment comment = this.escaladeService.findCommentById(commentId);
		model.addAttribute(comment);
		return VIEWS_COMMENT_CREATE_OR_UPDATE_FORM;
	}

	@RequestMapping(value = "/comments/{commentId}/edit", method = RequestMethod.POST)
	public String processUpdateCommentForm(@Valid Comment comment, BindingResult result, @PathVariable("commentId") Long commentId) {
		if (result.hasErrors()) {
			return VIEWS_COMMENT_CREATE_OR_UPDATE_FORM;
		} else {
			comment.setId(commentId);
			this.escaladeService.saveComment(comment);
			return "redirect:/comments/{commentId}";
		}
	}

	/**
	 * Custom handler for displaying an comment.
	 *
	 * @param commentId the ID of the comment to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/comments/{commentId}")
	public ModelAndView showComment(@PathVariable("commentId") int commentId) {
		ModelAndView mav = new ModelAndView("comments/commentDetails");
		mav.addObject(this.escaladeService.findCommentById(commentId));
		return mav;
	}

}