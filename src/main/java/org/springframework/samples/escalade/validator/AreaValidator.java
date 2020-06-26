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

import org.springframework.samples.escalade.model.Area;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * <code>Validator</code> for <code>Topo</code> forms.
 * <p>
 * We're not using Bean Validation annotations here because it is easier to
 * define such validation rule in Java.
 * </p>
 *
 * @author Guillaume Nivet
 */
public class AreaValidator implements Validator {

	private static final String REQUIRED = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		Area area = (Area) obj;
		String name = area.getName();
		// name validation
		if (!StringUtils.hasLength(name)) {
			errors.rejectValue("name", REQUIRED, REQUIRED);
		}

		String street = area.getStreet();
		if (!StringUtils.hasLength(street)) {
			errors.rejectValue("street", REQUIRED, REQUIRED);
		}

		String postalcode = area.getPostalcode();
		if (!StringUtils.hasLength(postalcode)) {
			errors.rejectValue("postalcode", REQUIRED, REQUIRED);
		}

		String city = area.getCity();
		if (!StringUtils.hasLength(city)) {
			errors.rejectValue("city", REQUIRED, REQUIRED);
		}

		String country = area.getCountry();
		if (!StringUtils.hasLength(country)) {
			errors.rejectValue("country", REQUIRED, REQUIRED);
		}

		String gpscoordinate = area.getGpscoordinate();
		if (!StringUtils.hasLength(gpscoordinate)) {
			errors.rejectValue("gpscoordinate", REQUIRED, REQUIRED);
		}
	}

	/**
	 * This Validator validates *just* Topo instances
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Area.class.isAssignableFrom(clazz);
	}

}
