package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.NamedEntity;

public interface LengthRepository {


	Length saveLength(Length length)throws DataAccessException;
	Collection<Length> findLengthByName(String name)throws DataAccessException;
	Length findLengthById(Integer lengthId)throws DataAccessException;
	NamedEntity updateLength(Length length)throws DataAccessException;
}
