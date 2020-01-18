package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.samples.escalade.model.Site;

public interface SiteRepository {

	Site findById(long id);

	Collection<Site> findSiteByPostalcode(String postalcode);
}
