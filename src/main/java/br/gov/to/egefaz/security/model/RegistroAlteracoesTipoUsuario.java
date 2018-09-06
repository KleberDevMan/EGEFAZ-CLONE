package br.gov.to.egefaz.security.model;

import br.gov.to.egefaz.security.domain.TipoUsuario;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RegistroAlteracoesTipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAlteracao;
    private String motivo;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoAnterior;
    @Enumerated(EnumType.STRING)
    private TipoUsuario novoTipo;
    @ManyToOne
    @JoinColumn(name = "usuarioEgefaz_id")
    private UsuarioEgefaz usuarioModificado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoUsuario getTipoAnterior() {
        return tipoAnterior;
    }

    public void setTipoAnterior(TipoUsuario tipoAnterior) {
        this.tipoAnterior = tipoAnterior;
    }

    public TipoUsuario getNovoTipo() {
        return novoTipo;
    }

    public void setNovoTipo(TipoUsuario novoTipo) {
        this.novoTipo = novoTipo;
    }

    public UsuarioEgefaz getUsuarioModificado() {
        return usuarioModificado;
    }

    public void setUsuarioModificado(UsuarioEgefaz usuarioModificado) {
        this.usuarioModificado = usuarioModificado;
    }

    public Calendar getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Calendar dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroAlteracoesTipoUsuario)) {
            return false;
        }
        RegistroAlteracoesTipoUsuario other = (RegistroAlteracoesTipoUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.to.egefaz.security.model.RegistroAlteracoesTipoUsuario[ id=" + id + " ]";
    }

}
