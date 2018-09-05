package br.gov.to.egefaz.security.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Classe que fornece o EntityManager
 * @author kleber
 */
public abstract class AbstractService {
	
	@PersistenceContext
	protected EntityManager em;
	
	public EntityManager getEm(){
		return em;
	}
}
