package br.gov.to.egefaz.security.service;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * realização da CRUD e chamada do CSVVS
 *
 * @author 83633162100
 */
@Stateless
public class UsuarioService extends AbstractService {

    private static final long serialVersionUID = 1L;

    public UsuarioEgefaz findByCpfInDataBaseSystem(String cpf) {
        try {
            return (UsuarioEgefaz) getEm().createNamedQuery("UsuarioEgefaz.findByUsrCpf").setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public UsuarioEgefaz autenticarUsuarioEgefaz(String cpf, String senha) {
        try {
            return (UsuarioEgefaz) getEm().createNamedQuery("UsuarioEgefaz.findByUsrCpfSenha").setParameter("cpf", cpf).setParameter("senha", senha).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    //busca usuario no add
    private UsuarioEgefaz findByCpfInAd(String cpf) {
        UsuarioEgefaz usrAd = new UsuarioEgefaz();
        usrAd.setNome("servidor serfaz");
        usrAd.setCpf(cpf);

        return usrAd;
    }
    
//    public boolean isSenhaValida(String CPF, String Senha) {
//        return false;
//    }
//
//    public void salvarUsuario(UsuarioEgefaz usuario) {
//        getEm().merge(usuario);
//        getEm().flush();
//    }

}
