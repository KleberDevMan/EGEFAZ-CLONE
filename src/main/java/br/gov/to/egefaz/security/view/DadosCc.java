package br.gov.to.egefaz.security.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang.StringUtils;

import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

/**
 * Dados funcionais de um cidadao comum
 * 
 * @author 06250631127
 */
@ManagedBean
@RequestScoped
public class DadosCc extends AbstractView {

	private static final String REDIRECIONA_PAGINA_DADOS_COMPLEMENTARES = "dadoscomplementares?faces-redirect=true";
	private static final String REDIRECIONA_PRIMEIRO_ACESSO = "primeiroAcesso?faces-redirect=true";

	private UsuarioEgefaz usuario;
	private boolean check = false;
	private boolean form = false;

	@PostConstruct
	public void init() {
		if (usuario == null) {
			this.usuario = (UsuarioEgefaz) pegaDaSessao("usuario");
		}
	}

	public void habilitarForm() {
		this.form = true;
	}

	public String btnProceguir() {
//
//		if (!isAceite()) {
//			exibirMensagem("Confirme veracidade das informações");
//			return StringUtils.EMPTY;
//		}
//		adicionaNaSessao(VariaveisSessao.USUARIO, usuario);
		return REDIRECIONA_PAGINA_DADOS_COMPLEMENTARES;
	}
	
	public String btnCancelar() {
		removeDaSessao("usuario");
		return REDIRECIONA_PRIMEIRO_ACESSO;
	}

	public UsuarioEgefaz getUsuario() {
		return usuario;
	}
	
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public boolean isForm() {
		return form;
	}

	public void setForm(boolean form) {
		this.form = form;
	}

	public void setUsuario(UsuarioEgefaz usuario) {
		this.usuario = usuario;
	}


	public List<String> getCidades() {
		return Arrays.asList("Palmas", "Porto Nacional");
	}

}
