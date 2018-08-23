package br.gov.to.egefaz.security.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class UsuarioCidadaoComum extends UsuarioExterno {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private VinculoFuncionalCidadao vinculoFuncional;

	public VinculoFuncionalCidadao getVinculoFuncional() {
		return vinculoFuncional;
	}

	public void setVinculoFuncional(VinculoFuncionalCidadao vinculoFuncional) {
		this.vinculoFuncional = vinculoFuncional;
	}

}
