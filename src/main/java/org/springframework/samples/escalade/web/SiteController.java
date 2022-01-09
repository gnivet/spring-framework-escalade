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
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.SiteTypeRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.repository.WayRepository;
import org.springframework.samples.escalade.repository.ZoneRepository;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	private SiteTypeRepository siteTypeRepository;
	private UserRepository userRepository;
	@Autowired
    public SiteController(EscaladeService escaladeService,
    	AreaRepository areaRepository, SiteTypeRepository siteTypeRepository, UserRepository userRepository , WayRepository wayRepository, ZoneRepository zoneRepository) {
        this.escaladeService = escaladeService;
        this.userRepository = userRepository;
        this.areaRepository = areaRepository;
        this.siteTypeRepository = siteTypeRepository;




    }


	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}





	@SuppressWarnings("unlikely-arg-type")
	@GetMapping(value = "/areas/{areaId}/sites/new")
	public String initCreationForm(  ModelMap model, Principal principal, @PathVariable("areaId") Integer areaId ) {





		if (principal.getName() != null) {
			String userName = principal.getName();


			User user = this.userRepository.findByUserName(userName);
			 model.addAttribute("firstName" , user.getFirstName() );
		} else {
			return "redirect:/users/login/";
		}







		Site site = new Site();
		model.put("site", site);


		// Input Area
		 Area area = this.areaRepository.findAreaById(areaId);
		 if (area == null || area.equals(" ") )
	        {
	        	System.out.println("area est null" + model + area);
	        }
		model.put("area", area);



		List<SiteType> sitetype= this.siteTypeRepository.findAll();
        if (sitetype == null || sitetype.isEmpty())
        {
        	System.out.println("le type est null" + model + sitetype);
        }

        model.put("sitetype",sitetype);




        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }


	@GetMapping(value = "/sites/{sites}/sitetypes/{siteTypeId}")
	public String processFindForm(SiteType siteType, BindingResult result, Map<String, Object> model, @PathVariable("siteId") Integer siteId, @PathVariable("siteTypeId") Integer siteTypeId) {

		if (siteType.getName() == null) {
			siteType.setName(""); // empty string signifies broadest possible search
		}



		// find areas by postal code
		//Collection<SiteType> results = this.escaladeService.findSiteTypeByName(siteType.getName());
		Collection<SiteType> results = this.escaladeService.findSiteTypes();

		if (results.isEmpty()) {
			// no areas found
			result.rejectValue("name", "notFound", "not found");
			return "sitetypes/findSiteTypes";

		} else {
			// multiple areas found
			model.put("selections", results);
			return "sitetypes/siteTypeList1";
		}
	}


	 	@PostMapping(value = "/areas/{areaId}/sites/new")
	    public String processCreationForm( ModelMap model, Principal principal, @PathVariable Integer areaId, SiteType siteType, Site site, BindingResult result, Area aera, User user){

	 		 if (siteType == null )
	         {
	         	System.out.println("le type est null" + model + siteType);
	         }



	 		if (principal.getName() != null)
	 		{
	 			String userName = principal.getName();
	 			user = this.userRepository.findByUserName(userName);
	 			
				
				
	 			
	 		}else
	 		{
	 			 return "redirect:welcome";
	 		}

	 		


	        if (result.hasErrors()) {
	            return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
	        } else

	        {
	        	

			@SuppressWarnings("unused")
			Area area = this.areaRepository.findAreaById(areaId);

			System.out.println(model);
			
			// Save site 
			model.put("site", site);
			site.setUser(user);
 			site.getBirthDate();
 			site.getType();
 			aera.setSite(site);
 			site.getName();
 		
			
			
			site = this.escaladeService.saveSite(site);
			
			     



			Collection<SiteType> results = this.escaladeService.findSiteTypes();


			if (results.isEmpty()) {
				// no areas found
				result.rejectValue("name", "notFound", "not found");
				return "sitetypes/findSiteTypes";

			} else {
				// multiple areas found
				model.put("selections", results);
				return "sitetypes/siteTypesList";
			}
	        }

	    }






	 	@GetMapping(value = "/sites/find")
		public String initFindForm(Map<String, Object> model) {
			model.put("site", new Site());
			return "/sites/findSites";

		}



	 	@GetMapping(value = "/sites")
		public String processFindForm(Area  area, User user, Site site, Zone zone, BindingResult result, Map<String, Object> model) {

			// allow parameterless GET request for /areas to return all records
			if (site.getName() == null) {
				site.setName(""); // empty string signifies broadest possible search
			}

			if (zone.getName() == null) {
				zone.setName(""); // empty string signifies broadest possible search
			}

			// find sites by name
			Collection<Site> results = this.escaladeService.findSiteByName(site.getName());
			//Collection<Zone> result2s = this.escaladeService.findZoneBySiteName(site.getName());

			if (results.isEmpty()) {
				// no sites found
				result.rejectValue("name", "notFound", "not found");
				return "/sites/findSites";

			} else {
				// multiple sites found
				model.put("selections", results);
			 return "sites/sitesList";
			}
	 	}
		@GetMapping(value= "zone")
		public String processFindForm2(Zone zone, Site site, BindingResult result,  Map<String, Object> model) {

			// allow parameterless GET request for /areas to return all records
			if (zone.getName() == null) {
				zone.setName(""); // empty string signifies broadest possible search
			}

			// find sites by name
			Collection<Zone> result2s = this.escaladeService.findZoneBySiteName(site.getName());



			if (result2s.isEmpty()) {
				// no sites found
				result.rejectValue("name", "notFound", "not found");
				return "/zones/findZones";

			} else {
				// multiple sites found
				model.put("selection2s", result2s);
			 return "zones/zonesList";
			}




		}



    @GetMapping(value = "/sites/{siteId}")
    public String initUpdateForm(@PathVariable("siteId") int siteId, ModelMap model) {

    	Site site = this.escaladeService.findSiteById(siteId);
    	Area area = site.getArea();
    	model.put("area", area);

    	/*
    	 * Site Valid
    	 */
    	if (site.isValid())
    	{
        site.isValid();

        /*
         * Not valid
         */
    	}else {if (!site.isValid())
    	{
    		site.isValid();
    	}
    	}


        model.put("site", site);

        SiteType siteType = site.getType();
        model.put("siteType", siteType);



        return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/sites/{siteId}")
    public String processUpdateForm(@PathVariable("siteId") int siteId, @Valid Site site, BindingResult result, User user, ModelMap model) {

        if (result.hasErrors()) {
            model.put("site", site);
            return VIEWS_SITES_CREATE_OR_UPDATE_FORM;
        } else {
            user.addSite(site);


        	Site siteToModify = this.escaladeService.findSiteById(siteId);
        	siteToModify.setType(site.getType());
        	//siteToModify.setUser(user.getuserName());
        	siteToModify.setName(site.getName());
        	siteToModify.setBirthDate(site.getBirthDate());
            this.escaladeService.updateSite(siteToModify);
            return "redirect:/sites/{siteId}";
        }
    }







}