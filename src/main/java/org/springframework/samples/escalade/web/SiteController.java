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
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Guillaume Nivet
 * @param <getUserId>
  */
@Controller
public class SiteController {

    private static final String VIEWS_SITES_CREATE_OR_UPDATE_FORM = "sites/createOrUpdateSiteForm";
    private final EscaladeService escaladeService;
    
    private AreaRepository areaRepository;
	private UserRepository userRepository;
	
	
	@Autowired
    public SiteController(EscaladeService escaladeService, UserRepository userRepository, AreaRepository areaRepository) {
        this.escaladeService = escaladeService;
        this.userRepository = userRepository;
        this.areaRepository = areaRepository;
        
    }
	 
	
    @GetMapping(value = "/sites/{userId}/new")
    public String initCreationForm(Map<String, Object> model, @PathVariable(value="userId") int userId 
    		) {
    	System.out.println(userId);
        Site site = new Site();
        List<Area> areas= this.areaRepository.findAll();
       
       
        model.put("areas",areas);
        
        model.put("site",site);
        
        
      
		
       
		
      //model.put("sitetype",this.escaladeService.findSiteTypesList());
       
        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }
    // A se souvenir Principal    
    
    
    
    @PostMapping(value = "/sites/{userId}/new")
    public String processCreationForm(Principal principal,  Site site, Area  area ,BindingResult result, ModelMap model ,@PathVariable(value="userId") int userId ) {
    	
    	User user = userRepository.findByUsername(principal.getName());
    	/*
        if (StringUtils.hasLength(site.getName()) && site.isNew() && user.getSite(site.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        */
        user.addSite(site);
        //area.getCity();
        this.escaladeService.saveSite(site);
        return "redirect:/users/{userId}";
    	
    	
       /* if (result.hasErrors()) {
            model.put("site", site);
            /*
             * GNI BEG
             * /
            model.put("area",area);
            //model.put("user", user);
            /*
             * GNI END
             * / 
            
            return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
        } else {
        
        } */
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
