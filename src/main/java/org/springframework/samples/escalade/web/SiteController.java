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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Collection;
import java.util.Map;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
@RequestMapping("/users/{userId}")
public class SiteController {

    private static final String VIEWS_SITES_CREATE_OR_UPDATE_FORM = "topos/createOrUpdateTopoForm";
    private final EscaladeService escaladeService;

    @Autowired
    public SiteController(EscaladeService escaladeService) {
        this.escaladeService = escaladeService;
    }

    @ModelAttribute("sitetype")
    public Collection<SiteType> populateSiteTypes() {
        return this.escaladeService.findSiteTypes();
    }

    @ModelAttribute("user")
    public User finduser(@PathVariable("userId") int userId) {
        return this.escaladeService.findUserByID(userId);
    }

    @InitBinder("user")
    public void initUserBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    /*
    @InitBinder("site")
    public void initSiteBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new SiteValidator());
    }
	*/
    @RequestMapping(value = "/users/new", method = RequestMethod.GET)
    public String initCreationForm(User user, ModelMap model) {
        Site site = new Site();
        user.addSite(site);
        model.put("site",site);
        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }
        
    
    @RequestMapping(value = "/sites/new", method = RequestMethod.POST)
    public String processCreationForm(User user, @Valid Site site, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(site.getName()) && site.isNew() && user.getSite(site.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        if (result.hasErrors()) {
            model.put("site", site);
            return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
        } else {
            user.addSite(site);
            this.escaladeService.saveSite(site);
            return "redirect:/users/{userId}";
        }
    }

    @RequestMapping(value = "/sites/{siteId}/edit", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable("siteId") int siteId, ModelMap model) {
        Site site = this.escaladeService.findSiteById(siteId);
        model.put("site", site);
        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }

    @RequestMapping(value = "/sites/{siteId}/edit", method = RequestMethod.POST)
    public String processUpdateForm(@Valid Site site, BindingResult result, User user, ModelMap model) {
        if (result.hasErrors()) {
            model.put("site", site);
            return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
        } else {
            user.addSite(site);
            this.escaladeService.saveSite(site);
            return "redirect:/users/{userId}";
        }
    }
    
    //@SuppressWarnings("null")
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
        return "areas/areas";    } else if (results.size() == 1) {
        // 1 user found
        area = results.iterator().next();
        return "redirect:/areas/" + area.getId();
    } else {
        // multiple users found
        model.put("selections", results);
        return "areas/sitesList";
    }
    
    }
    
    
}
