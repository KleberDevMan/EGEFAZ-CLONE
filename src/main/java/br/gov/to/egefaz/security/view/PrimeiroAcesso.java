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
public class PrimeiroAcesso extends AbstractView {

    private UsuarioEgefaz usuario;
    @EJB
    private UsuarioService usuarioService;
//    //variavel usada para renderizar ou nao o campo de insercao de senha paro o SI
    private boolean isUsrInterno = false;
//    //variavel usada para saber se o botao prosseguir irá autenticar SI ou proceguir para UE(usuario esterno)
//    private boolean EParaAutenticar = false;
//    //USUARIO VINDO DO AD
//    UsuarioEgefaz usrAd = null;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = new UsuarioEgefaz();
        }
        if (usuario.getTipoUsuario() == TipoUsuario.SERVIDOR_INTERNO) {
            isUsrInterno = true;
        }
    }

    private String autenticarAd() {
        return "";
    }

    public String btnPesquisarClick() {

        if (usuarioService.findByCpfInDataBaseSystem(usuario.getCpf()) != null) {
            exibirMensagem("voce ja esta cadastrado. Tente recuperar sua senha");
            return "";
        } else {
            UsuarioEgefaz usrAd = usuarioService.findByCpfInAd(usuario.getCpf());
            //verificacao 2 (se é servidor interno)
            if (usrAd != null) {
                usuario = usrAd;
                usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
                usuario.setEmailInstitucional(usuario.getCpf() + "@sefaz");
                adicionaNaSessao("usuario", usuario);
                return "dadossf_1?faces-redirect=true";
            } else {
                return "tipocadastro_1?faces-redirect=true";
            }
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }

    public boolean isIsUsrInterno() {
        return isUsrInterno;
    }
    
}
