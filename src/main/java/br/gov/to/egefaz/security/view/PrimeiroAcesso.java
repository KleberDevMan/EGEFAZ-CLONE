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

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = new UsuarioEgefaz();
        }
    }

    public String btnPesquisarClick() {
        //verifica se esta cadastrado na base do sistema
        if (usuarioService.findByCpfInDataBaseSystem(usuario.getCpf()) != null) {
            exibirMensagem("você já está cadastrado.");
            return "";
        } else {
            //verifica no add se é o cpf de um usuario interno
            UsuarioEgefaz usrAd = usuarioService.findByCpfInAd(usuario.getCpf());

            if (usrAd != null) {
                usuario = usrAd;
                usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
                return "dadossf_1?faces-redirect=true";
            }
        }
        //nao: solicita escolha de um tipo de acesso (sp ou cc)
        return "tipocadastro_1?faces-redirect=true";
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }

}
