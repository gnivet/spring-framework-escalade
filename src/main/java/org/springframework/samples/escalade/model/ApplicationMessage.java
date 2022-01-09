package org.springframework.samples.escalade.model;

public class ApplicationMessage {
	String value = "# # # P6 Spring Boot Escalade is starting... # # # ";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
