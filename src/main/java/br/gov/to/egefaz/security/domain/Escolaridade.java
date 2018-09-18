package br.gov.to.egefaz.security.domain;

public enum Escolaridade {
	FUNDAMENTAL("FUNDAMENTAL", "Fundamental"), 
	MEDIO_INCOMPLETO("MEDIO_INCOMPLETO", "Médio incompleto"), 
	MEDIO("MEDIO", "Médio"), 
	SUPERIOR_INCOMPLETO("SUPERIOR_INCOMPLETO", "Superior incompleto"), 
	SUPERIOR("SUPERIOR", "Superior"), 
	POS_GRADUADO("POS_GRADUADO", "Pós graduação"), 
	ESPECIALISTA("ESPECIALISTA", "Especialista"), 
	MBA("MBA", "MBA"), 
	MESTRADO("MESTRADO", "Mestrado"), 
	DOUTORADO("DOUTORADO", "Doutorado");
	
	private String descricao;
    private String codigo;
	
	private Escolaridade(String codigo, String label) {
        this.codigo = codigo;
        this.descricao = label;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return getCodigo();
    }
}
