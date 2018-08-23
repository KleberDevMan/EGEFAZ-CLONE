package br.gov.to.egefaz.security.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VinculoFuncionalCidadao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String empresaEmpregadora;
	private String municipio;
	private String funcaoNaEmpresa;
	private String telefone;

	public String getEmpresaEmpregadora() {
		return empresaEmpregadora;
	}

	public void setEmpresaEmpregadora(String empresaEmpregadora) {
		this.empresaEmpregadora = empresaEmpregadora;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getFuncaoNaEmpresa() {
		return funcaoNaEmpresa;
	}

	public void setFuncaoNaEmpresa(String funcaoNaEmpresa) {
		this.funcaoNaEmpresa = funcaoNaEmpresa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
