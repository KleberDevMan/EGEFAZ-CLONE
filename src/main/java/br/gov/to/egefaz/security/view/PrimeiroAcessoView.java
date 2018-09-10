/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.domain.Sexo;
import br.gov.to.egefaz.security.domain.TipoUsuario;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import br.gov.to.egefaz.security.service.UsuarioService;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author 06250631127
 */
@Named
@SessionScoped
public class PrimeiroAcessoView implements Serializable {

    private static final long serialVersionUID = 1L;
    private UsuarioEgefaz usuario;
    @EJB
    private UsuarioService usuarioService;

    
    public PrimeiroAcessoView(){
        
    }
    
    
    
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
                return "dadossf_1?faces-redirect=true";
            } //nao: solicita escolha de um tipo de acesso (sp ou cc)

        }
        return "tipocadastro_1?faces-redirect=true";
        //sp: mantem o cpf e direciona para (dadossp)
        //cc: mantem o cpf e direciona para (dadoscc)

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
        return "dadosComplementaresUsuarioExterno?faces-redirect=true";
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEgefaz usuario) {
        this.usuario = usuario;
    }

//    public TipoUsuario getServidorPublico() {
//        return servidorPublico;
//    }
//
//    public TipoUsuario getCidadaoComunidade() {
//        return cidadaoComunidade;
//    }
    
    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = new UsuarioEgefaz();
            usuario.setTipoUsuario(TipoUsuario.SERVIDOR_INTERNO);
        }
    }
    
    public TipoUsuario[] getTiposUsuario() {
        return TipoUsuario.values();
    }

}
