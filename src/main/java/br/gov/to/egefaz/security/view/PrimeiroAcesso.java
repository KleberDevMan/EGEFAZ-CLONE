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
    //variavel usada para renderizar ou nao o campo de insercao de senha paro o SI
    private boolean isUsrInterno = false;
    //variavel usada para saber se o botao prosseguir irá autenticar SI ou proceguir para UE(usuario esterno)
    private boolean EParaAutenticar = false;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = new UsuarioEgefaz();
        }
    }

    private String autenticarAd() {
        return "";
    }
    
    
    
    private boolean jaEUmUsuario() {
        if (usuarioService.findByCpfInDataBaseSystem(usuario.getCpf()) != null) {
            exibirMensagem("você já está cadastrado.");
            return true;
        }
        return false;
    }
    
    public String btnPesquisarClick() {

        //USUARIO VINDO DO AD
        UsuarioEgefaz usrAd = null;
        
        if (!EParaAutenticar) {
            if (jaEUmUsuario()) {
                return "";
            } else {
                usrAd = usuarioService.findByCpfInAd(usuario.getCpf());
                //verificacao 2 (se é servidor interno)
                if (usrAd != null) {
                    isUsrInterno = true;
                    EParaAutenticar = true;
                    usuario = usrAd;
                    usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
                    exibirMensagem("Digite a senha de rede para fazermos a importação de dados");
                    return "";
                } else {
                    return "tipocadastro_1?faces-redirect=true";
                }
            }
        }else{
            //verificar senha de rede
            if (usrAd.getSenha().equals(usuario.getSenha())) {
                return "dadossf_1?faces-redirect=true";
            } else {
                exibirMensagem("senha de rede incorreta.");
                return "";
            }
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }

    public boolean getIsUsrInterno() {
        return isUsrInterno;
    }

}
