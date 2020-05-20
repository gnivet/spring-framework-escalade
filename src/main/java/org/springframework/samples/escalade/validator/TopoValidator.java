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


import org.springframework.samples.escalade.model.Topo;
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
public class TopoValidator implements Validator {

    private static final String REQUIRED = "required";

    @Override
    public void validate(Object obj, Errors errors) {
        Topo topo = (Topo) obj;
        String name = topo.getName();
        // name validation
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name", REQUIRED, REQUIRED);
        }
        
        // description validation
        String description = topo.getDescription();
        if (!StringUtils.hasLength(description)) {
            errors.rejectValue("description", REQUIRED, REQUIRED);
        }
       
        // type validation
        if (topo.isNew() && topo.getUser() == null) {
            errors.rejectValue("type", REQUIRED, REQUIRED);
        }
        	
        // birth date validation
        if (topo.getDescription() == null) {
            errors.rejectValue("description", REQUIRED, REQUIRED);
        }
       
    }

    /**
     * This Validator validates *just* Topo instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Topo.class.isAssignableFrom(clazz);
    }


}
