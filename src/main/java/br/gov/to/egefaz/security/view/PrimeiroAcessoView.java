package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PrimeiroAcessoView extends AbstractView {

	private UsuarioEgefaz usuario;
	@EJB
	private UsuarioService usuarioService;
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
			UsuarioEgefaz usrAd = usuarioService.findByCpfInAd(usuario.getCpf());
			// VERIFICA SE É UM SERVIDOR INTERNO
			if (usrAd != null) {
				isServiodorInterno = true;
//				usuario = usrAd;
//				usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
//				usuario.setEmailInstitucional(usuario.getCpf() + "@sefaz.to.gov.br");
//				adicionaNaSessao("usuario", usuario);
//				return "dadossf?faces-redirect=true";
				return "";
			}
			// ORIENTA PARA CADASTRO DE SERVIDOR EXTERNO
			else {
				adicionaNaSessao("usuario", usuario);
				this.usuario = new UsuarioEgefaz();
				return "tipocadastro?faces-redirect=true";
			}
		}
	}
	
	public String autenticaServidorInterno() {
		return "";
	}
	public String importaServidorInterno() {
		return "";
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
