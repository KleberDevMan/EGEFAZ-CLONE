package br.gov.to.egefaz.security.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;

@ManagedBean
@RequestScoped
public class TipoCadastroView extends AbstractView{

    private UsuarioEgefaz usuario;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) pegaDaSessao("usuario");
            this.usuario.setTipoUsuario(TipoUsuario.CIDADAO_COMUM);
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public List<TipoUsuario> getTiposUser() {
    	return Arrays.asList(TipoUsuario.SERVIDOR_EXTERNO, TipoUsuario.CIDADAO_COMUM);
    }
    
    public String proceguir() {
        adicionaNaSessao("usuario", usuario);
        return "dadoscomplementares?faces-redirect=true";
    }

    
}
