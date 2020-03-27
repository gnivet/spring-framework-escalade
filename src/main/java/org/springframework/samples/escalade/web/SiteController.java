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
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.samples.escalade.repository.SiteTypeRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Guillaume Nivet
*/
@Controller
@Transactional
public class SiteController {

    private static final String VIEWS_SITES_CREATE_OR_UPDATE_FORM = "sites/createOrUpdateSiteForm";
  
    private final EscaladeService escaladeService;
    

    
    private AreaRepository areaRepository;
	private UserRepository userRepository;
	private SiteTypeRepository siteTypeRepository;
	private SiteRepository siteRepository;

	private Integer siteId;

	private Integer areaId;
	
	private Integer siteTypeId;

	private String name;
	
	
	@Autowired
    public SiteController(EscaladeService escaladeService, UserRepository userRepository, AreaRepository areaRepository, SiteTypeRepository syteTypeRepository, SiteRepository siteRepository) {
        this.escaladeService = escaladeService;
        this.userRepository = userRepository;
        this.areaRepository = areaRepository;
        this.siteTypeRepository = syteTypeRepository;
        
    }
	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	
	
	@GetMapping(value = "/sites/new")
	public String initCreationForm(  Map<String, Object> model) {
		Site site = new Site();
        model.put("site", site);
        
        // area's list
        List<Area> areas= this.areaRepository.findAll();
        model.put("areas",areas);
        //  Site type's list
        List<SiteType> sitetypes= this.siteTypeRepository.findAll();
        model.put("sitetypes",sitetypes);
        
        
		
        
        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }
	
	
	
	 	@PostMapping(value = "/sites/new")
	    public String processCreationForm(  Principal principal,   Area area, Site site, BindingResult result){
				 
	 		String userName = principal.getName();
	 		
			User user = this.userRepository.findByUsername(userName);
			 
			site  = this.siteRepository.findSiteOwnedByUser(userName, site);
			 
			 area = this.areaRepository.findAreaById(areaId);
			
			SiteType sitetype = this.siteTypeRepository.findSiteTypeById(siteTypeId);
			
			
	        if (result.hasErrors()) {	        	        	
	            return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
	        } else       
	        {	        
	        	site.setId(site.id); 
	        	site.setUser(user);
	        	site.setArea(area);
	            site.setSitetype(sitetype);				
	        	site = this.escaladeService.saveSite(site);
	        	
	            return "redirect:/sites/" + site.getId() ;
	        }
	    }
	 	
	 	
	 	
	 		
	 	@GetMapping(value = "/sites/find")
		public String initFindForm(Map<String, Object> model) {
			model.put("site", new Site());
			return "/sites/findSites";
			
		}
    
	 	 
	 

    @GetMapping(value = "/sites/{siteId}/edit")
    public String initUpdateForm(@PathVariable("siteId") int siteId, ModelMap model) {
        Site site = this.escaladeService.findSiteById(siteId);
        model.put("site", site);
        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/sites/{siteId}/edit")
    public String processUpdateForm(@PathVariable("siteId") int siteId, @Valid Site site, BindingResult result, User user, ModelMap model) {
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
