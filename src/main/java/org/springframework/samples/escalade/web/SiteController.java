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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Guillaume Nivet
  */
@Controller
public class SiteController {

    private static final String VIEWS_SITES_CREATE_OR_UPDATE_FORM = "sites/createOrUpdateSiteForm";
    private final EscaladeService escaladeService;
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    public SiteController(EscaladeService escaladeService) {
        this.escaladeService = escaladeService;
    }
        
    
    @GetMapping(value = "/sites/new")
    public String initCreationForm(  ModelMap model) {
        Site site = new Site();
       
        model.put("site",site);
        model.put("sitetype",this.escaladeService.findSiteTypes());
       
        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }
    // A se souvenir Principal    
    
    @PostMapping(value = "/sites/new")
    public String processCreationForm(Principal principal, @Valid Site site, BindingResult result, ModelMap model) {
    	User user = userRepository.findByUsername(principal.getName());
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

    @GetMapping(value = "/sites/{siteId}/edit")
    public String initUpdateForm(@PathVariable("siteId") int siteId, ModelMap model) {
        Site site = this.escaladeService.findSiteById(siteId);
        model.put("site", site);
        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/sites/{siteId}/edit")
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
    
    
    
    
}
