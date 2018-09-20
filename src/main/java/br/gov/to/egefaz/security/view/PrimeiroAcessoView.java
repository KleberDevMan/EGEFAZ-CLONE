package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PrimeiroAcessoView extends AbstractView {

	private static final String REDIRECIONA_TIPOCADASTRO = "tipoCadastro?faces-redirect=true";
	private static final String REDIRECIONA_DADOSSF = "dadosSi?faces-redirect=true";
	private static final String EMAIL_INSTITUCIONAL_SEFAZ = "@sefaz.to.gov.br";
	
	@EJB
	private UsuarioService usuarioService;

	private UsuarioEgefaz usuario;
	private UsuarioEgefaz servidorInternoImportado;
	private boolean isServiodorInterno = false;

	@PostConstruct
	public void init() {
		if (usuario == null) {
			this.usuario = new UsuarioEgefaz();
		}
	}

	public String btnPesquisarClick() {

		// VERIFICA SE O SERVIDOR EXISTE JA ESTA CADASTRADO
		if (usuarioService.findByCpfInDataBaseSystem(usuario.getCpf()) != null) {
			exibirMensagem("voce ja esta cadastrado. Tente recuperar sua senha");
			this.usuario = new UsuarioEgefaz();
			return "";
		} else {
			servidorInternoImportado = usuarioService.findByCpfInAd(usuario.getCpf());
			// VERIFICA SE É UM SERVIDOR INTERNO
			if (servidorInternoImportado != null) {
				isServiodorInterno = true;
				return "";
			}
			// ORIENTA PARA CADASTRO DE SERVIDOR EXTERNO
			else {
				adicionaNaSessao(VariaveisSessao.USUARIO, usuario);
				this.usuario = new UsuarioEgefaz();
				return REDIRECIONA_TIPOCADASTRO;
			}
		}
	}
	
	public String autenticaServidorInterno() {
		
		//VERIFICA SENHA DIGITADA
		if (usuario.getSenha().equals(servidorInternoImportado.getSenha())) {
			importaServidorInterno();
			return REDIRECIONA_DADOSSF;
		}else {
			exibirMensagem("senha incorreta");
			this.usuario.setSenha("");
			return "";
		}
		
	}
	public void importaServidorInterno() {
		this.usuario = servidorInternoImportado;
		this.usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
		this.usuario.setEmailInstitucional(usuario.getCpf() + EMAIL_INSTITUCIONAL_SEFAZ);
		this.usuario.setSenha("");
		adicionaNaSessao(VariaveisSessao.USUARIO, this.usuario);
	} 

	public UsuarioEgefaz getUsuario() {
		return usuario;
	}

	public boolean getIsServiodorInterno() {
		return isServiodorInterno;
	}

	public void setServiodorInterno(boolean isServiodorInterno) {
		this.isServiodorInterno = isServiodorInterno;
	}

	
	
	

}
