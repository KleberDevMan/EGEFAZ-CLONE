package br.gov.to.egefaz.security.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

@ManagedBean
@ViewScoped
public class HomeView extends AbstractView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final String REDIRECIONA_LOGIN = "login?faces-redirect=true";
	private UsuarioEgefaz usuario;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) pegaDaSessao(VariaveisSessao.USUARIO);
        }
    }
    
    public String deslogar() {
    	removeDaSessao(VariaveisSessao.USUARIO);
    	return REDIRECIONA_LOGIN;
    }

    
    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public boolean isExisteFoto() {
		try {
			return this.usuario.getFoto().length > 0;
		} catch (Exception e) {
			return false;
		}
	}
}
