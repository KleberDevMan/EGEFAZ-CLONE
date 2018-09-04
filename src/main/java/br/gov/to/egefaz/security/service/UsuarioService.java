package br.gov.to.egefaz.security.service;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * realização da CRUD e chamada do CSVVS
 *
 * @author 83633162100
 */
@Stateless
public class UsuarioService extends AbstractService {

    private static final long serialVersionUID = 1L;

//    public List<UsuarioEgefaz> listaUsuarios() {
//        return getEm().createNamedQuery("Usuario.findAll").getResultList();
//    }
    public UsuarioEgefaz buscaUsuarioPorCpf(String cpf) {
        try {
            return (UsuarioEgefaz) getEm().createNamedQuery("UsuarioEgefaz.findByUsrCpf").setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
//
//    public UsuarioEgefaz buscaUsuarioPorCpfAD(String cpf) {
//        return null;
//    }
//
//    public boolean isSenhaValida(String CPF, String Senha) {
//        return false;
//    }
//
    public void salvarUsuario(UsuarioEgefaz usuario) {
        getEm().merge(usuario);
        getEm().flush();
    }

}
