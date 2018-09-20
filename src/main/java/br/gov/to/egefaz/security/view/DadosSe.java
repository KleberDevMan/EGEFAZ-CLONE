package br.gov.to.egefaz.security.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

/**
 * Dados funcionais de um servidor externo
 * @author 06250631127
 */
@ManagedBean
@ViewScoped
public class DadosSe extends AbstractView{
	
	private static final String REDIRECIONA_DADOS_COMPLEMENTARES = "dadosComplementares?faces-redirect=true";
	private static final String REDIRECIONA_PRIMEIRO_ACESSO = "primeiroAcesso?faces-redirect=true";

    private UsuarioEgefaz usuario;
    private boolean confirmacao;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) pegaDaSessao(VariaveisSessao.USUARIO);
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public boolean isConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(boolean aceite) {
		this.confirmacao = aceite;
	}

	public String btnProceguir() {
		
		if (!isConfirmacao()) {
			
			exibirMensagem("Confirme que as informações são verdadeiras");
			return StringUtils.EMPTY;
		}
		
        adicionaNaSessao(VariaveisSessao.USUARIO, usuario);
        
        return REDIRECIONA_DADOS_COMPLEMENTARES;
    }
    
    public String btnCancelar() {
        removeDaSessao(VariaveisSessao.USUARIO);
        return REDIRECIONA_PRIMEIRO_ACESSO;
    }
    
    public List<String> getCidades() {
    	return Arrays.asList("Palmas", "Porto Nacional");
    }

}
