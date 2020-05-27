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
package org.springframework.samples.escalade.validator;


import java.util.Date;

import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * <code>Validator</code> for <code>Topo</code> forms.
 * <p>
 * We're not using Bean Validation annotations here because it is easier to define such validation rule in Java.
 * </p>
 *
 * @author Guillaume Nivet 
 */
public class TopoBkgValidator implements Validator {

    private static final String REQUIRED = "required";

    @Override
    public void validate(Object obj, Errors errors) {
        TopoBkg topoBkg = (TopoBkg) obj;
        
        String name = topoBkg.getName();              
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name", REQUIRED, REQUIRED);
        }
        
        
                
        Date borrowDate = topoBkg.getBorrowDate();
        if (!StringUtils.hasLength((CharSequence) borrowDate)) {
            errors.rejectValue("borrowDate", REQUIRED, REQUIRED);
        }
        
        Date borrowEndDate = topoBkg.getBorrowEndDate();
        if (!StringUtils.hasLength((CharSequence) borrowEndDate)) {
            errors.rejectValue("borrowEndDate", REQUIRED, REQUIRED);
        }
        
           
               	
        @SuppressWarnings("unused")
		Boolean accepted = topoBkg.getAccepted();
        if (topoBkg.getAccepted() == null) {
            errors.rejectValue("accepted", REQUIRED, REQUIRED);
        }
      
    }

    /**
     * This Validator validates *just* Topo instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return TopoBkg.class.isAssignableFrom(clazz);
    }


}
