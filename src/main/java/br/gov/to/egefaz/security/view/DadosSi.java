package br.gov.to.egefaz.security.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

/**
 * Dados funcionais de um servidor interno
 * @author 06250631127
 */
@ManagedBean
@ViewScoped
public class DadosSi extends AbstractView{

    private static final String REDIRECIONA_PRIMEIRO_ACESSO = "primeiroAcesso?faces-redirect=true";
	private static final String REDIRECIONA_DADOS_COMPLEMENTARES = "dadosComplementares?faces-redirect=true";
	private UsuarioEgefaz usuario;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) pegaDaSessao(VariaveisSessao.USUARIO);
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public String btnProceguir() {
        adicionaNaSessao(VariaveisSessao.USUARIO, usuario);
        return REDIRECIONA_DADOS_COMPLEMENTARES;
    }
    
    public String btnCancelar() {
        removeDaSessao(VariaveisSessao.USUARIO);
        return REDIRECIONA_PRIMEIRO_ACESSO;
    }

    
}
