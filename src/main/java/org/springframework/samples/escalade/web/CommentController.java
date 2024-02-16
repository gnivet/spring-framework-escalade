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

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Guillaume Nivet
 */
@Controller
@Transactional
public class CommentController {

	private static final String VIEWS_COMMENT_CREATE_OR_UPDATE_FORM = "comments/createOrUpdateCommentForm";
	private final EscaladeService escaladeService;
	private UserRepository userRepository;
	private Site site;

	@Autowired
	public CommentController(EscaladeService escaladeService , UserRepository userRepository, SiteRepository siteRepository) {
		this.escaladeService = escaladeService;
		this.userRepository = userRepository;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping("/sites/{siteId}/comments/new")
	public String initCreationForm(Map<String, Object> model , @PathVariable("siteId") Integer site, Principal principal ) {
		Site sites = new Site();
		Comment comment = new Comment();
		String userName = principal.getName();
		@SuppressWarnings("unused")
		User user = this.userRepository.findByUserName(userName);
		model.put("comment", comment);
		return VIEWS_COMMENT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/sites/{siteId}/comments/new")
	public String processCreationForm(Comment comment, BindingResult result, @PathVariable("siteId") Integer siteId,   Map<String, Object> model, Principal principal, User user) {
		
		if (principal != null)
		 {
		String userName = principal.getName();
		
		/**
		 * Retrieve a <code>User</code> from the data store by id.
		 *
		 * @param userName the userName to search for
		 * @return the <code>User</code> if found
		 * @throws org.springframework.dao.DataRetrievalFailureException if not found
		 */

		user = this.userRepository.findByUserName(userName);
		 }


		/**
		 * Retrieve a <code>Site</code> from the data store by id.
		 *
		 * @param userName the userName to search for
		 * @return the <code>Site</code> if found
		 * @throws org.springframework.dao.DataRetrievalFailureException if not found
		 */


		if (result.hasErrors()) {
			return VIEWS_COMMENT_CREATE_OR_UPDATE_FORM;
		} else {

			model.put("comment", comment);


		
			/**
			 * Retrieve a <code>User</code> from the data store by id.
			 *
			 * @param userName the userName to search for
			 * @return the <code>User</code> if found
			 * @throws org.springframework.dao.DataRetrievalFailureException if not found
			 */
			user.getUserName();
			site = this.escaladeService.findSiteById(siteId);
			comment.setUser(user);
			
			comment.setSite(site);
			if (siteId != null)
			{
				comment.setId(siteId);
			}
			 this.escaladeService.updateComment(comment);
			return "redirect:/sites/{siteId}/comments/new";
		}
	}

	@GetMapping("/comments/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("comment", new Comment());
		return "comments/findComments";
	}

//findSites
	@GetMapping("/comments")
	public String processFindForm(Comment comment, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /comments to return all records
		if (comment.getName() == null) {
			comment.setName(""); // empty string signifies broadest possible search
		}

		// find comments by postal code
		Collection<Comment> results = this.escaladeService.findCommentByName(comment.getName());
		if (results.isEmpty()) {
			// no comments found
			result.rejectValue("name", "notFound", "not found");
			return "comments/findComments";
			/*
			 * } else if (results.size() == 1) { // 1 comment found comment =
			 * results.iterator().next(); return "redirect:/comments/" + comment.getId();
			 */
		} else {
			// multiple comments found
			model.put("selections", results);
			return "comments/commentsList";
		}
	}

	@GetMapping("/comments/{commentId}")
	public String initUpdateCommentForm(@PathVariable("commentId") Integer commentId, Model model) {
		Comment comment = this.escaladeService.findCommentById(commentId);
		model.addAttribute(comment);
		return VIEWS_COMMENT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/comments/{commentId}")
	public String processUpdateCommentForm(@Valid Comment comment, BindingResult result, @PathVariable("commentId") Integer commentId) {
		if (result.hasErrors()) {
			return VIEWS_COMMENT_CREATE_OR_UPDATE_FORM;
		} else {

			Comment commentToModify = this.escaladeService.findCommentById(commentId);
			if (comment.getComment() != null) {
				commentToModify.setComment(comment.getComment());
			}
			commentToModify.setName(comment.getName());
			if (comment.getSite()!= null)
			{
				commentToModify.setSite(comment.getSite());
			}
			if(comment.getDate() != null) {
				commentToModify.setDate(comment.getDate());
			}
			this.escaladeService.saveComment(commentToModify);
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
	public ModelAndView showComment(@PathVariable("commentId") Integer commentId) {
		ModelAndView mav = new ModelAndView("comments/commentDetails");
		mav.addObject(this.escaladeService.findCommentById(commentId));
		return mav;
	}

}