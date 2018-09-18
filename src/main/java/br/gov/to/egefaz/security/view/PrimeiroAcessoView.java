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

    private UsuarioEgefaz usuario = new UsuarioEgefaz();
    @EJB
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = new UsuarioEgefaz();
        }
    }

    public String btnPesquisarClick() {

        if (usuarioService.findByCpfInDataBaseSystem(usuario.getCpf()) != null) {
            exibirMensagem("voce ja esta cadastrado. Tente recuperar sua senha");
            this.usuario = new UsuarioEgefaz();
            return "";
        } else {
            UsuarioEgefaz usrAd = usuarioService.findByCpfInAd(usuario.getCpf());
            //verificacao 2 (se é servidor interno)
            if (usrAd != null) {
                usuario = usrAd;
                usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
                usuario.setEmailInstitucional(usuario.getCpf() + "@sefaz.to.gov.br");
                adicionaNaSessao("usuario", usuario);
                return "dadossf?faces-redirect=true";
            } else {
                this.usuario = new UsuarioEgefaz();
                return "tipocadastro?faces-redirect=true";
            }
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
}
