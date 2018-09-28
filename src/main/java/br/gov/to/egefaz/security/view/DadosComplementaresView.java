package br.gov.to.egefaz.security.view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.gov.to.egefaz.security.domain.Escolaridade;
import br.gov.to.egefaz.security.domain.Sexo;
import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;

/**
 *
 * @author 06250631127
 */
@ManagedBean
@ViewScoped
public class DadosComplementaresView extends AbstractView {

	private static final String REDIRECT_PRIMEIRO_ACESSO = "primeiroAcesso?faces-redirect=true";
	private UsuarioEgefaz usuario;
	@EJB
	private UsuarioService usuarioService;
	private boolean check = false;
	private String nomeImagem;
	
	@PostConstruct
	public void init() {
		if (usuario == null) {
			this.usuario = (UsuarioEgefaz) pegaDaSessao(VariaveisSessao.USUARIO);
		}
	}

	public void validatorSenha(FacesContext fc, UIComponent component, Object value) throws ValidatorException {

		String senhaRepetida = value.toString();

		if (senhaRepetida.equals(usuario.getSenha())) {
			throw new ValidatorException(new FacesMessage("senhas diferem"));
		}
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public void setUsuario(UsuarioEgefaz usuario) {
		this.usuario = usuario;
	}

	public UsuarioEgefaz getUsuario() {
		return usuario;
	}

	public String proceguir() {
		System.out.println("cadastrando dados complementares....");
		System.out.println(usuario);
		return "";
	}

	public String btnCancelar() {
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

	//Método que faz o Upload dos arquivos
	public void upload(FileUploadEvent fileUploadEvent) throws IOException {

		UploadedFile uploadedFile = fileUploadEvent.getFile();

		this.nomeImagem = uploadedFile.getFileName();
		
		//converte para bit[]
		InputStream initialStream = uploadedFile.getInputstream();
		byte[] targetArray = new byte[initialStream.available()];
		initialStream.read(targetArray);
		initialStream.close();
		
		usuario.setFoto(targetArray);
	}
	
	//provisorio -- depois apagar --
	public void btnCadastrarTestClick() {
        usuarioService.salvarUsuario(usuario);
    }
}
