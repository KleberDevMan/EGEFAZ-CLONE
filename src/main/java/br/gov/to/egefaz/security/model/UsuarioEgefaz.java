package br.gov.to.egefaz.security.model;

import br.gov.to.egefaz.security.domain.Escolaridade;
import br.gov.to.egefaz.security.domain.Sexo;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
//@NamedQueries({
//    @NamedQuery(name = "UsuarioEgefaz.findByUsrCpf", query = "SELECT u FROM UsuarioEgefaz u WHERE u.cpf = :cpf")})
public class UsuarioEgefaz implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String cidade;

    //USUARIO
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @ManyToOne
    @JoinColumn(name = "tipoUsuario_id")
    private TipoUsuario tipoUsuario; //chave estrangeira
    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;
    private String celular;
    private String appMensagem;
    private String numeroAppMsg;
//	private Part foto;
    private Boolean status;
    private Boolean permissaoAcesso;

    //USUARIO EXTERNO
    private String emailPessoal;
    private String senha;

    //ATRIBUTOS COMUNS AO VINCULO FUNCIONAL (CIDADAO E SERVIDOR)
    private String municipio;
    private String telefone;

    //ATRIBUTOS ESPECIFICOS - VINCULO FUNCIONAL CIDADAO
    private String empresaEmpregadora;
    private String funcaoNaEmpresa;

    //ATRIBUTOS ESPECIFICOS - VINCULO FUNCIONAL SERVIDOR
    private String orgao;
    private String lotacao;
    private String emailInstitucional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof UsuarioEgefaz)) {
            return false;
        }
        UsuarioEgefaz other = (UsuarioEgefaz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.to.egefaz.security.model.UsuarioEgefaz[ id=" + id + " ]";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getAppMensagem() {
        return appMensagem;
    }

    public void setAppMensagem(String appMensagem) {
        this.appMensagem = appMensagem;
    }

    public String getNumeroAppMsg() {
        return numeroAppMsg;
    }

    public void setNumeroAppMsg(String numeroAppMsg) {
        this.numeroAppMsg = numeroAppMsg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getPermissaoAcesso() {
        return permissaoAcesso;
    }

    public void setPermissaoAcesso(Boolean permissaoAcesso) {
        this.permissaoAcesso = permissaoAcesso;
    }

    public String getEmailPessoal() {
        return emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresaEmpregadora() {
        return empresaEmpregadora;
    }

    public void setEmpresaEmpregadora(String empresaEmpregadora) {
        this.empresaEmpregadora = empresaEmpregadora;
    }

    public String getFuncaoNaEmpresa() {
        return funcaoNaEmpresa;
    }

    public void setFuncaoNaEmpresa(String funcaoNaEmpresa) {
        this.funcaoNaEmpresa = funcaoNaEmpresa;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

}
