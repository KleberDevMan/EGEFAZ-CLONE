/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.egefaz.security.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 06250631127
 */
public abstract class AbstractView {

    //retorna a instancia altual do FacesConstext
    public FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
    
    //colocar uma msg na instancia atual do FacesConstext
    public void exibirMensagem(String msg) {
        getContext().addMessage(null, new FacesMessage(msg));
    }

    //retorna a instancia altual do sessao do usuario
    public HttpSession getHttpSession() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return (HttpSession) request.getSession();
    }

}
