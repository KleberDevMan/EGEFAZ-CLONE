package br.gov.to.egefaz.security.view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

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
	
	private Part foto;
	
    public Part getFoto() {
		return foto;
	}

	public void setFoto(Part foto) {
		this.foto = foto;
	}

	@PostConstruct
    public void init() {
        if (usuario == null) {
        	this.usuario = (UsuarioEgefaz) pegaDaSessao(VariaveisSessao.USUARIO);
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public String proceguir() {
    	
    	//salva a imagem no servidor
    	try {
			foto.write("/EGEFAZ/imagens" + foto.getSubmittedFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
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
}
