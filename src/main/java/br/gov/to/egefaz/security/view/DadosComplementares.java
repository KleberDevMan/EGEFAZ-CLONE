package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.domain.Escolaridade;
import br.gov.to.egefaz.security.domain.Sexo;
import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author 06250631127
 */
@ManagedBean
@RequestScoped
public class DadosComplementares extends AbstractView{

    private UsuarioEgefaz usuario;
    private Calendar dataNacimento;

    public Calendar getDataNacimento() {
        return dataNacimento;
    }

    
    

    @PostConstruct
    public void init() {
        if (usuario == null) {
            this.usuario = (UsuarioEgefaz) pegaDaSessao("usuario");
            this.usuario.setEscolaridade(Escolaridade.FUNDAMENTAL);
        }
    }

    public UsuarioEgefaz getUsuario() {
        return usuario;
    }
    
    public String proceguir() {
        adicionaNaSessao("usuario", usuario);
//        return "dadoscomplementares?faces-redirect=true";
        System.out.println(usuario.getDataNascimento());
        return "";
    }

    public List<Sexo> getSexos() {
        return Arrays.asList(Sexo.values());
    }
    
    public List<Escolaridade> getEscolaridades() {
        return Arrays.asList(Escolaridade.values());
    }
}
