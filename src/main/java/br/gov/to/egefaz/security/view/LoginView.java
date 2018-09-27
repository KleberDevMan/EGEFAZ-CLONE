package br.gov.to.egefaz.security.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;

@ManagedBean
@RequestScoped
public class LoginView extends AbstractView implements Serializable {

    private static final String REDIRECIONA_RECUPERAR_SENHA = "usuario/recuperarSenha?faces-redirect=true";
	private static final String REDIRECIONA_HOME = "home.xhtml?faces-redirect=true";
	private static final String REDIRECIONA_PRIMEIRO_ACESSO = "usuario/primeiroAcesso?faces-redirect=true";
	
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
        return REDIRECIONA_RECUPERAR_SENHA;
    }
    
    public String btnLoginClick() {
        //BUSCA NA BASE DE DADOS DO SISTEMA
        UsuarioEgefaz usr = usuarioService.autenticarUsuarioEgefaz(usuario.getCpf(), usuario.getSenha());
        if (usr == null) {
            exibirMensagem("usuario nao encontrado");
            usuario = new UsuarioEgefaz();
            return "";
        } else {
            adicionaNaSessao(VariaveisSessao.USUARIO, this.usuario);
            return REDIRECIONA_HOME;
        }
    }

    public String btnPrimeiroAcessoClick() {
        return REDIRECIONA_PRIMEIRO_ACESSO;
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public void btnCadastrarTestClick() {
        usuarioService.salvarUsuario(usuario);
    }
}
