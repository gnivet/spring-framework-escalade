package org.springframework.samples.escalade.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Length;

public interface LengthRepository {

	Length findById(Integer id);
	void saveLength(Length length)throws DataAccessException;

}
