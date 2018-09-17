package br.gov.to.egefaz.security.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

@ManagedBean
@RequestScoped
public class TipoCadastro extends AbstractView{

    private UsuarioEgefaz usuario;
    
    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) pegaDaSessao("usuario");
        }
    }
    
    public String deslogar() {
        getHttpSession().removeAttribute("ID_USUARIO");
        return "login_2?faces-redirect=true";
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public List<TipoUsuario> getTiposUsuario() {
    	return Arrays.asList(TipoUsuario.SERVIDOR_EXTERNO, TipoUsuario.CIDADAO_COMUM);
    }
}
