/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author 06250631127
 */
@Named
@SessionScoped
public class PrimeiroAcessoView implements Serializable {

    private static final long serialVersionUID = 1L;
    private UsuarioEgefaz usuario = new UsuarioEgefaz();
    private List<TipoUsuario> tiposUser;

    @EJB
    private UsuarioService usuarioService;

    public String btnPesquisarClick() {

        FacesContext context = FacesContext.getCurrentInstance();

        //verifica se esta cadastrado na base do sistema
        if (usuarioService.findByCpfInDataBaseSystem(usuario.getCpf()) != null) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CPF já cadastrado"));
            return "";
        } else {
            //verifica no add se é o cpf de um usuario interno
            UsuarioEgefaz usrAd = usuarioService.findByCpfInAd(usuario.getCpf());

            if (usrAd != null) {
                usuario = usrAd;
                usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
                return "dadossf_1?faces-redirect=true";

            }
        } //nao: solicita escolha de um tipo de acesso (sp ou cc)
        return "tipocadastro_1?faces-redirect=true";
        

    }

    public String cancelarCadastro() {
        usuario = new UsuarioEgefaz();
        return "primeiroAcesso_1?faces-redirect=true";
    }

    public String proceguirServidorSefaz() {
        return "dadosComplementaresUsuarioInterno?faces-redirect=true";
    }

    public String proceguirUsuarioExterno() {
        System.out.println(usuario);
        //sp: mantem o cpf e direciona para (dadossp)
        //cc: mantem o cpf e direciona para (dadoscc)
        return "dadosComplementaresUsuarioExterno?faces-redirect=true";
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEgefaz usuario) {
        this.usuario = usuario;
    }

//    @PostConstruct
//    public void init() {
//        if (usuario == null) {
//            this.usuario = new UsuarioEgefaz();
//            this.tiposUser = Arrays.asList(TipoUsuario.SERVIDOR_EXTERNO, TipoUsuario.CIDADAO_COMUM);
//        }
//    }

    public List getTiposUser() {
        return tiposUser;
    }

}
