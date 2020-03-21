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
import org.springframework.samples.escalade.model.NamedEntity;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Guillaume Nivet
 * @param <getUserId>
  */

//@Transactional
//@RequestMapping("/users")
//@SessionAttributes("user")
@Controller
@Transactional
public class SiteController {

    private static final String VIEWS_SITES_CREATE_OR_UPDATE_FORM = "sites/createOrUpdateSiteForm";
  
    private final EscaladeService escaladeService;
    

    
    private AreaRepository areaRepository;
	private UserRepository userRepository;
	private SiteTypeRepository siteTypeRepository;
	private SiteRepository siteRepository;
	
	
	@Autowired
    public SiteController(EscaladeService escaladeService, UserRepository userRepository, AreaRepository areaRepository, SiteTypeRepository syteTypeRepository, SiteRepository siteRepository) {
        this.escaladeService = escaladeService;
        this.userRepository = userRepository;
        this.areaRepository = areaRepository;
        this.siteTypeRepository = syteTypeRepository;
        
    }
	
	/*
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	*/
	
	
	@GetMapping(value = "/sites/new")
	public String initCreationForm(  Map<String, Object> model) {
		Site site = new Site();
        model.put("site", site);
        
        // area's list
        List<Area> areas= this.areaRepository.findAll();
        model.put("areas",areas);
        // 
        List<SiteType> sitetypes= this.siteTypeRepository.findAll();
        model.put("sitetypes",sitetypes);
        
        
		
        
        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }
	
	
	
	 	@PostMapping(value = "/sites/new")
	    public String processCreationForm(@ModelAttribute Site site, @ModelAttribute  Principal principal,  @ModelAttribute  NamedEntity area, SiteType siteType,  BindingResult result, Model model, Integer siteId, Integer areaId){
				 
		 String userName = principal.getName();
			User user = this.userRepository.findByUsername(userName);
			System.out.println(siteId); 
			Site sites = this.siteRepository.findSiteById(siteId);
			System.out.println(areaId); 
			NamedEntity areas = this.areaRepository.findAreaById(areaId);
		 
		 
	        if (result.hasErrors()) {
	            return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
	        } else {
	        	
	        	site = this.escaladeService.saveSite(site);		
	        	model.addAttribute("site",site.getName());
	        	model.addAttribute("userId",site.getId());
	        	
	            return "redirect:/sites/" + site.getId() ;
	        }
	    }
	
    /*
	 
	 private Map<Long, Employee> employeeMap = new HashMap<>();

	    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	    public String submit(
	      @ModelAttribute("employee") Employee employee,
	      BindingResult result, ModelMap model) {
	        if (result.hasErrors()) {
	            return "error";
	        }
	        model.addAttribute("name", employee.getName());
	        model.addAttribute("id", employee.getId());

	        employeeMap.put(employee.getId(), employee);

	        return "employeeView";
	    }

	    @ModelAttribute
	    public void addAttributes(Model model) {
	        model.addAttribute("msg", "Welcome to the Netherlands!");
	    }
	}
	 
	 */
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

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
