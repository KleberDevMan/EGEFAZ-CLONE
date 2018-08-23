package br.gov.to.egefaz.security.model;

import javax.persistence.Entity;

@Entity
public abstract class UsuarioExterno extends Usuario {

	private static final long serialVersionUID = 1L;

	private String emailPessoal;
	private String senha;

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

}
