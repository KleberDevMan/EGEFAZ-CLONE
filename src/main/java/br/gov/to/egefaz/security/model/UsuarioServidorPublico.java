package br.gov.to.egefaz.security.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class UsuarioServidorPublico extends UsuarioExterno {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private VinculoFuncionalSevidor vinculoFuncional;

	public VinculoFuncionalSevidor getVinculoFuncional() {
		return vinculoFuncional;
	}

	public void setVinculoFuncional(VinculoFuncionalSevidor vinculoFuncional) {
		this.vinculoFuncional = vinculoFuncional;
	}

}
