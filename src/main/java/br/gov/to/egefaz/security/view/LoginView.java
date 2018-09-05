package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("loginView")
@ViewScoped
public class LoginView implements Serializable {

    private static final long serialVersionUID = 1L;

    private UsuarioEgefaz usuario = new UsuarioEgefaz();

    @EJB
    private UsuarioService usuarioService;

    //busca o usuario no banco 
    public void logar() {
        UsuarioEgefaz usr = usuarioService.buscaUsuarioPorCpf(usuario.getCpf());
//        
        if (usr == null) {
            //habilita o escopo flash (a msg dura apenas um request)
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true); 
            //exibe msg
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("usuario nao encontrado."));
        }else{
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("usuario encontrado."));
        }
    }

    public void salvarUsuario() {
        usuarioService.salvarUsuario(usuario);
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
}
