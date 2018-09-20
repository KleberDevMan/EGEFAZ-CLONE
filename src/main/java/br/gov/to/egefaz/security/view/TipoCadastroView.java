package br.gov.to.egefaz.security.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

@ManagedBean
@ViewScoped
public class TipoCadastroView extends AbstractView{

    private static final String REDIRECIONA_DADOSCC = "dadosCc?faces-redirect=true";
	private static final String REDIRECIONA_DADOSSP = "dadosSe?faces-redirect=true";
	private UsuarioEgefaz usuario;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) pegaDaSessao(VariaveisSessao.USUARIO);
            this.usuario.setTipoUsuario(TipoUsuario.SERVIDOR_EXTERNO);
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public List<TipoUsuario> getTiposUser() {
    	return Arrays.asList(TipoUsuario.SERVIDOR_EXTERNO, TipoUsuario.CIDADAO_COMUM);
    }
    
    public String proceguir() {
        adicionaNaSessao(VariaveisSessao.USUARIO, usuario);
        
        if (this.usuario.getTipoUsuario() == TipoUsuario.SERVIDOR_EXTERNO) 
        	return REDIRECIONA_DADOSSP;
		else
        return REDIRECIONA_DADOSCC;
    }

    
}
