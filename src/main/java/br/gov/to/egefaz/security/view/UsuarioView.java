/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.model.Usuario;
import br.gov.to.egefaz.security.service.UsuarioService;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;





/**
 *
 * @author 83633162100
 */
@ViewScoped
@ManagedBean(name = "usuarioView")

public class UsuarioView implements Serializable {

    /**
     * serial default.
     */
    private static final long serialVersionUID = 1L;

    /**
     * nome do usuario autenticado no momento.
     */
    private Usuario usuario;

    @EJB
    private UsuarioService usuarioService;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Construtor defaut.
     */
    public UsuarioView() {

    }

    /**
     * @return retorna a data atual.
     */
    public String getData() {
        DateFormat dfmt = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy.");
        return dfmt.format(new Date());
    }

    /**
     * @return retorna o nome do usuario logado.
     */
    public String getNome() {
        return usuario.getUsername();
    }

    public void salvarUsuario() {
        usuarioService.salvarUsuario(usuario);
    }

    @PostConstruct
    public void init() {

    }
}
