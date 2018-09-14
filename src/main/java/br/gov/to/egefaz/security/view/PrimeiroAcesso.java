package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PrimeiroAcesso extends AbstractView {

    private UsuarioEgefaz usuario;
    @EJB
    private UsuarioService usuarioService;
    private boolean isUsrInterno = false;

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = new UsuarioEgefaz();
        }
    }

    public String btnPesquisarClick() {

        //USUARIO VINDO DO AD
        UsuarioEgefaz usrAd = null;

        //verificacao 1 (se ja ta cadastrado)
        if (usuarioService.findByCpfInDataBaseSystem(usuario.getCpf()) != null) {
            exibirMensagem("você já está cadastrado.");
            return "";
        }else{
            usrAd = usuarioService.findByCpfInAd(usuario.getCpf());
            //verificacao 2 (se é servidor interno)
            if (usrAd != null) {
                this.isUsrInterno = true;
                usuario = usrAd;
                usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
                exibirMensagem("Digite a senha de rede para fazermos a importação de dados");
                return "";
            } else {
                return "tipocadastro_1?faces-redirect=true";
            }   
        }

//        
//        
//        if (isUsrInterno) {
//            //verificar senha de rede
//            if (usrAd.getSenha().equals(usuario.getSenha())) {
//                return "dadossf?faces-redirect=true";
//            } else {
//                exibirMensagem("senha de rede incorreta.");
//                return "";
//            }
//        }

    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }

    public boolean getIsUsrInterno() {
        return isUsrInterno;
    }

}
