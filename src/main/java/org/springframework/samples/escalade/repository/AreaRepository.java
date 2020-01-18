package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.samples.escalade.model.Area;

public interface AreaRepository {

	Area findById(long id);

	Collection<Area> findTopoByPostalcode(String postalcode);

}
