package de.javaee8recipes.persistenceunit.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookAuthorFacade {

	@PersistenceContext(unitName = "PersistenceUnitJNDI")
	private EntityManager em;

	public String getDbVersion() {
		return em.createNativeQuery("SELECT version()").getSingleResult().toString();
	}
}
