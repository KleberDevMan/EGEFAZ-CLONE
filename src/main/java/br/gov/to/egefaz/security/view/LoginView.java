package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("loginView")
@ViewScoped
public class LoginView implements Serializable {

    private static final long serialVersionUID = 1L;

    private UsuarioEgefaz usuario;

    //object service
    @EJB
    private UsuarioService usuarioService;

    //busca o usuario no banco
    public UsuarioEgefaz buscarNoBanco() {
        UsuarioEgefaz u = usuarioService.findByCpfNoBanco(usuario.getCpf());
        System.out.println("usuario vindo do banco = " + u.getNome());
        return null;
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEgefaz usuario) {
        this.usuario = usuario;
    }
}
