package br.gov.to.egefaz.security.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.gov.to.egefaz.security.domain.VariaveisSessao;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

//ultilitario para converter a foto do usuario em byte[] 
//para o StreamedContent do Primefaces
@ManagedBean
@RequestScoped
public class FotoBean extends AbstractView {

	private UsuarioEgefaz usuario;

	@PostConstruct
	public void init() {
		this.usuario = (UsuarioEgefaz) pegaDaSessao(VariaveisSessao.USUARIO);
	}

	public StreamedContent getFoto() {
		try {
			// UMA EXCESSAO ??
			FacesContext context = FacesContext.getCurrentInstance();
			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				return new DefaultStreamedContent();
			}

			// RETORNA A IMAGEM CONVERTIDA
			InputStream is = new ByteArrayInputStream(usuario.getFoto());
			DefaultStreamedContent dsc = new DefaultStreamedContent(is);
			is.close();
			return dsc;

		} catch (Exception e) {
			return new DefaultStreamedContent();
		}
	}
	
}
