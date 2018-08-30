package br.gov.to.egefaz.security.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public abstract class AbstractService {
	
	@PersistenceContext
	protected EntityManager em;
	
	public EntityManager getEm(){
		return em;
	}
}
