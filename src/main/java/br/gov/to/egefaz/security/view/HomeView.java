package br.gov.to.egefaz.security.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

@ManagedBean
@ViewScoped
public class HomeView extends AbstractView{

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
}
