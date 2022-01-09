package org.springframework.samples.escalade.service;

import org.springframework.samples.escalade.model.ApplicationMessage;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {

	public ApplicationMessage getApplicationMessage() {
		ApplicationMessage am = new ApplicationMessage();
		return am;
	}
}
