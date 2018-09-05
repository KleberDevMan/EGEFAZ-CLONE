package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;

@Named()
@SessionScoped
public class UsuarioView implements Serializable {

    private static final long serialVersionUID = 1L;
    private UsuarioEgefaz usuario = new UsuarioEgefaz();
    @EJB
    private UsuarioService usuarioService;

    public String btnLoginClick() {
        System.out.println("usuario do form: "+usuario.getCpf()+" - " +usuario.getSenha());
        
        UsuarioEgefaz usr = usuarioService.autenticarUsuarioEgefaz(usuario.getCpf(), usuario.getSenha());

        if (usr!=null) {
            System.out.println("usuario vindo do banco -> " + usr.getNome() + usr.getCpf());
        }
        
        FacesContext context = FacesContext.getCurrentInstance();

        if (usr == null) {
            //habilita o escopo flash (a msg dura apenas um request)
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            //exibe msg
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("usuario nao encontrado."));
            return "login_1.xhtml";
        } else {
            return "home.xhtml?faces-redirect=true";
        }
    }

    public String btnPrimeiroAcessoClick() {
        return "usuario/primeiroAcesso_1.xhtml?faces-redirect=true";
    }

    public void btnPesquisarClick() {

        FacesContext context = FacesContext.getCurrentInstance();

        //verifica se esta cadastrado na base do sistema
        if (usuarioService.findByCpfInDataBaseSystem(usuario.getCpf()) != null) {
            //mensgem na tela dizendo que ja existe um usuario cadastrado com esse cpf
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("já existe um usuario cadastrado com este cpf."));
        } else {
//            //verifica no add se é o cpf de um usuario interno
//            UsuarioEgefaz usrAd = findByCpfInAd(usuario.getCpf());
//
//            if (usrAd != null) {
//                //sim: importa dados e coloca na tela (dadossf) com os campos desabilitados para edicao
//                
//            } else {
//                //nao: solicita escolha de um tipo de acesso (sp ou cc)
//                
//            }
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("verificando se o cpf é de um usuario interno..."));
        }
        //sp: mantem o cpf e direciona para (dadossp)
        //cc: mantem o cpf e direciona para (dadoscc)
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
}
