package br.gov.to.egefaz.security.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.to.egefaz.security.domain.Escolaridade;
import br.gov.to.egefaz.security.domain.Sexo;
import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

/**
 *
 * @author 06250631127
 */
@ManagedBean
@RequestScoped
public class DadosComplementaresView extends AbstractView{

    private UsuarioEgefaz usuario;

    @PostConstruct
    public void init() {
        if (usuario == null) {
        	this.usuario = (UsuarioEgefaz) pegaDaSessao("usuario");
        	this.usuario.setSexo(Sexo.MASCULINO);
        }
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
    	removeDaSessao("usuario");
    	return "primeiroAcesso?faces-redirect=true";
    }
    

    public List<Sexo> getSexos() {
        return Arrays.asList(Sexo.values());
    }
    
    public List<Escolaridade> getEscolaridades() {
        return Arrays.asList(Escolaridade.values());
    }
    
    public TipoUsuario getUsuarioInterno() {
    	return TipoUsuario.SERVIDOR_INTERNO;
    }
}
