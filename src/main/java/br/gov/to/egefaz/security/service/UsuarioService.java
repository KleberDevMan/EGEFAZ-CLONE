
package br.gov.to.egefaz.security.service;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.w3c.dom.UserDataHandler;

/**
 *
 * @author 83633162100
 */
@Stateless
public class UsuarioService extends AbstractService {

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
    
   // @Override
   // public Usuario loadUserByUsername(final String login) throws UsernameNotFoundException {
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

        UsuarioEgefaz usuario = new UsuarioEgefaz();

   //     return usuario;
   // }

    public List<UsuarioEgefaz> listaUsuarios() {
        return getEm().createNamedQuery("Usuario.findAll").getResultList();
    }

    public UsuarioEgefaz buscaUsuarioPorCpf(String cpf) {
        return (UsuarioEgefaz) getEm().createNamedQuery("Usuario.findByUsrCpf").setParameter("cpf", cpf).getSingleResult();
    }

    public UsuarioEgefaz buscaUsuarioPorCpfAD(String cpf) {
        return null;
    }

    public boolean isSenhaValida(String CPF, String Senha) {
        return false;
    }


    public void salvarUsuario(UsuarioEgefaz usuario) {
        getEm().merge(usuario);
        getEm().flush();
    }

}
