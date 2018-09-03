package br.gov.to.egefaz.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public abstract class AbstractService {

    @PersistenceContext
    protected EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public Session getSession() {
        return em.unwrap(Session.class);
    }
}
