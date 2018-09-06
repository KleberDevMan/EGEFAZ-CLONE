package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

@Named()
@ViewScoped
public class LoginView implements Serializable {

    private static final long serialVersionUID = 1L;
    private UsuarioEgefaz usuario = new UsuarioEgefaz();
    @EJB
    private UsuarioService usuarioService;

    public String btnLoginClick() {
        
        UsuarioEgefaz usr = usuarioService.autenticarUsuarioEgefaz(usuario.getCpf(), usuario.getSenha());
        FacesContext context = FacesContext.getCurrentInstance();
        if (usr == null) {
            //habilita o escopo flash (a msg dura apenas um request)
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            //exibe msg
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("usuario nao encontrado"));
            usuario = new UsuarioEgefaz();
            return "login_1?faces-redirect=true";
        } else {
            usuario = new UsuarioEgefaz();
            return "home.xhtml?faces-redirect=true";
        }
    }

    public String btnPrimeiroAcessoClick() {
        return "usuario/primeiroAcesso_1?faces-redirect=true";
    }
    
    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
}
