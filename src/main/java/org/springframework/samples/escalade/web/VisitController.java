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

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.Visit;
import org.springframework.samples.escalade.service.EscaladeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Guillaume Nivet 
 */
@Controller
public class VisitController {

    private final EscaladeService EscaladeService;


    @Autowired
    public VisitController(EscaladeService EscaladeService) {
        this.EscaladeService = EscaladeService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Called before each and every @GetMapping or @PostMapping annotated method.
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that site object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param siteId
     * @return site
     */
    @ModelAttribute("visit")
    public Visit loadsiteWithVisit(@PathVariable("siteId") int siteId) {
        Site site = this.EscaladeService.findSiteById(siteId);
        Visit visit = new Visit();
        site.addVisit(visit);
        return visit;
    }

    // Spring MVC calls method loadsiteWithVisit(...) before initNewVisitForm is called
    @GetMapping(value = "/users/*/sites/{siteId}/visits/new")
    public String initNewVisitForm(@PathVariable("siteId") int siteId, Map<String, Object> model) {
        return "sites/createOrUpdateVisitForm";
    }

    // Spring MVC calls method loadsiteWithVisit(...) before processNewVisitForm is called
    @PostMapping(value = "/users/{userId}/sites/{siteId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "sites/createOrUpdateVisitForm";
        } else {
            this.EscaladeService.saveVisit(visit);
            return "redirect:/users/{userId}";
        }
    }

    @GetMapping(value = "/users/*/sites/{siteId}/visits")
    public String showVisits(@PathVariable int siteId, Map<String, Object> model) {
        model.put("visits", this.EscaladeService.findSiteById(siteId).getVisits());
        return "visitList";
    }

}
