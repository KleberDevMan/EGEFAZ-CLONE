package br.gov.to.egefaz.security.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.gov.to.egefaz.security.domain.VariaveisSessao;

/**
 *
 * @author 06250631127
 */
public abstract class AbstractView {

    //RETORNA A INSTANCIA DO FACES CONTEXT
    public FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
    
    //RETORNA UMA REQUISICAO
    public HttpServletRequest getRequest() {
    	return (HttpServletRequest) getContext().getExternalContext().getRequest();
    }
    
    //RETORNA A SESSAO ATUAL
    public HttpSession getSession() {
    	return getRequest().getSession(Boolean.TRUE);
    }

    //EXIBE MENSAGEM
    public void exibirMensagem(String msg) {
        getContext().addMessage(null, new FacesMessage(msg));
    }

    //ADICIONA UM OBJ NA SESSAO
    public void adicionaNaSessao(VariaveisSessao chave, Object obj) {
        getSession().setAttribute(chave.name(), obj);
    }
    
    //REMOVE UM OBJ DA SESSAO
    public void removeDaSessao(VariaveisSessao chave) {
        getSession().removeAttribute(chave.name());
    }

    //PEGA UM OBJ DA SESSAO
    public Object pegaDaSessao(VariaveisSessao chave) {
        return getSession().getAttribute(chave.name());
    }

}
