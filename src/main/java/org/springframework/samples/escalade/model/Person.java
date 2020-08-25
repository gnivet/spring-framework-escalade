package org.springframework.samples.escalade.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.MappedSuperclass;

/**
 * Simple JavaBean domain object representing an person.
 *
 * @author Guillaume Nivet
 */
@MappedSuperclass
public class Person extends BaseEntity {

	// private final @Id Long id;
	private final String firstname, lastname;
	private final LocalDate birthday;
	private final int age;

	static Person of(String firstname, String lastname, LocalDate birthday) {

		return new Person(null, firstname, lastname, birthday, Period.between(birthday, LocalDate.now()).getYears());
	}

	Person(Integer id, String firstname, String lastname, LocalDate birthday, int age) {

		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.age = age;

	}

	Person withId(Integer id) {
		return new Person(id, this.firstname, this.lastname, this.birthday, this.age);
	}

	void setRemarks(String remarks) {
	}
}
