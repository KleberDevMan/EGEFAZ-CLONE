package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@RequestScoped
public class HomeView extends AbstractView{

    private UsuarioEgefaz usuario;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) getHttpSession().getAttribute("ID_USUARIO");
        }
    }
    
    public String deslogar() {
        getHttpSession().removeAttribute("ID_USUARIO");
        return "login_2?faces-redirect=true";
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
}
