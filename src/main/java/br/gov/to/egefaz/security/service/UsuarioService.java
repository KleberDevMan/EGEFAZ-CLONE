package br.gov.to.egefaz.security.service;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
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

    public UsuarioEgefaz findByCpfInDataBaseSystem(String cpf) {
        try {
            return (UsuarioEgefaz) getEm().createNamedQuery("UsuarioEgefaz.findByUsrCpf").setParameter("cpf", cpf).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public UsuarioEgefaz autenticarUsuarioEgefaz(String cpf, String senha) {
        try {
            return (UsuarioEgefaz) getEm().createNamedQuery("UsuarioEgefaz.findByUsrCpfSenha", UsuarioEgefaz.class).setParameter("cpf", cpf).setParameter("senha", senha).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    //busca usuario no add
    public UsuarioEgefaz findByCpfInAd(String cpf) {

        UsuarioEgefaz usrAd = null;

        if (cpf.equals("06250631127")) {
            usrAd = new UsuarioEgefaz();
            usrAd.setNome("Kleber (SI)");
            usrAd.setOrgao("Secretaria da Fazenda");
            usrAd.setLotacao("Desenvolvimento");
            usrAd.setMunicipio("Palmas");
            usrAd.setEmailInstitucional("kleber.chaves@sefaz.com");
            usrAd.setTelefone("3221-3234");
            usrAd.setSenha("444");

            usrAd.setCpf(cpf);
        }

        return usrAd;
    }

    //busca usuario no add
    public boolean autenticarUserAd(String cpf, String senha) {
        if (cpf.equals("44444444444") && senha.equals("444")) {
            return true;
        }
        return false;
    }

//    public boolean isSenhaValida(String CPF, String Senha) {
//        return false;
//    }
//
    public void salvarUsuario(UsuarioEgefaz usuario) {
        getEm().merge(usuario);
        getEm().flush();
    }

    public UsuarioEgefaz autenticarUsuarioEgefazInAdd(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
