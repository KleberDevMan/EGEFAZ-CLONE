/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.egefaz.security.view;



import br.gov.to.egefaz.security.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author 83633162100
 */@ViewScoped
@Named("UsuarioView")
public class UsuarioView implements Serializable {
  /**
   * serial default.
   */
  private static final long serialVersionUID = 1L;

  /**
   * nome do usuario autenticado no momento.
   */
  private Usuario usuario;

  /**
   * Construtor defaut.
   */
  public UsuarioView() {
    usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
}
