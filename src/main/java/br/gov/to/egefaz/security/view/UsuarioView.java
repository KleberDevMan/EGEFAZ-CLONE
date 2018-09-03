package br.gov.to.egefaz.security.view;

import br.gov.to.egefaz.security.model.UsuarioEgefaz;
import org.springframework.security.core.context.SecurityContextHolder;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named("UsuarioView")
public class UsuarioView implements Serializable {

    private static final long serialVersionUID = 1L;

    private UsuarioEgefaz usuario;

    public UsuarioView() {
        usuario = (UsuarioEgefaz) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public String getData() {

        DateFormat dfmt = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy.");
        return dfmt.format(new Date());

    }

    public String getNome() {
        return usuario.getUsername();
    }
}
