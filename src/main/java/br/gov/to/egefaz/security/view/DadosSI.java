package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 06250631127
 */
@ManagedBean
@RequestScoped
public class DadosSI extends AbstractView{

    private UsuarioEgefaz usuario;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) getHttpSession().getAttribute("ID_USUARIO");
        }
    }

    
    
    public UsuarioEgefaz getUsuario() {
        return usuario;
    }

}
