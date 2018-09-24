package br.gov.to.egefaz.security.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.gov.to.egefaz.security.domain.Escolaridade;
import br.gov.to.egefaz.security.domain.Sexo;
import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

/**
 *
 * @author 06250631127
 */
@ManagedBean
@ViewScoped
public class DadosComplementaresView extends AbstractView{

    private static final String REDIRECT_PRIMEIRO_ACESSO = "primeiroAcesso?faces-redirect=true";
	private UsuarioEgefaz usuario;
	private boolean check = false;

    @PostConstruct
    public void init() {
        if (usuario == null) {
        	this.usuario = (UsuarioEgefaz) pegaDaSessao(VariaveisSessao.USUARIO);
        }
    }
    
    
    

	public boolean isCheck() {
		return check;
	}




	public void setCheck(boolean check) {
		this.check = check;
	}




	public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public String proceguir() {
    	System.out.println("cadastrando dados complementares....");
        System.out.println(usuario);
        return "";
    }
    
    public String btnCancelar(){
    	removeDaSessao(VariaveisSessao.USUARIO);
    	return REDIRECT_PRIMEIRO_ACESSO;
    }
    

    public List<Sexo> getSexos() {
        return Arrays.asList(Sexo.values());
    }
    
    public List<Escolaridade> getEscolaridades() {
        return Arrays.asList(Escolaridade.values());
    }
    
    public TipoUsuario getServidorInterno() {
    	return TipoUsuario.SERVIDOR_INTERNO;
    }
    
    public TipoUsuario getCidadaoComum() {
    	return TipoUsuario.CIDADAO_COMUM;
    }
}
