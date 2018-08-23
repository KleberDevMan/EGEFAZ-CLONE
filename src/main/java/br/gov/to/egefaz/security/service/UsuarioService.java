/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.egefaz.security.service;

import br.gov.to.egefaz.security.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author 83633162100
 */
public class UsuarioService implements UserDetailsService, Serializable {

    /**
     * serial default.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Cria um novo Servico para usuarios.
     */
    public UsuarioService() {

    }

    /**
     * Busca os dados de um usuario com base em seu login.
     *
     * @param login o login do usuario que ser pesquisado.
     * @return retorna os detalhes de um usuario.
     */
    @Override
    public Usuario loadUserByUsername(final String login) throws UsernameNotFoundException {
        /*
    try {

      final TypedQuery<Usuario> query = emf.createNamedQuery("User.buscarPorLogin", Usuario.class);
      query.setParameter("login", login);

      if (!query.getResultList().isEmpty()) {
        return query.getSingleResult();
      }

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new UsernameNotFoundException("Falha ao realizar a autenticação");
    }

    throw new UsernameNotFoundException("Usuario ou senha inválidos");
         */
        
       Usuario  usuario  = new Usuario();
       
       
        
        return usuario;
    }
}
