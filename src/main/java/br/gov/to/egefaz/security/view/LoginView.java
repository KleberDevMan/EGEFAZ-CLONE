package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginView extends AbstractView implements Serializable {

    private static final long serialVersionUID = 1L;
    private UsuarioEgefaz usuario = new UsuarioEgefaz();
    @EJB
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            usuario = new UsuarioEgefaz();
        }
    }

    public String btnEsqueciSenhaClick() {
        return "usuario/recuperar-senha?faces-redirect=true";
    }
    
    public String btnLoginClick() {
        //busca na base local
        UsuarioEgefaz usr = usuarioService.autenticarUsuarioEgefaz(usuario.getCpf(), usuario.getSenha());
        if (usr == null) {
            exibirMensagem("usuario nao encontrado");
            usuario = new UsuarioEgefaz();
            return "";
        } else {
            //salva usuario em sessao
            adicionaNaSessao("usuario", this.usuario);
            return "home.xhtml?faces-redirect=true";
        }
    }

    public String btnPrimeiroAcessoClick() {
        return "usuario/primeiroAcesso?faces-redirect=true";
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public void btnCadastrarTestClick() {
        usuarioService.salvarUsuario(usuario);
    }
}
