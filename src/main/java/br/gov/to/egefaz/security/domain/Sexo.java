package br.gov.to.egefaz.security.domain;

public enum Sexo {
	MASCULINO("M", "Masculino"), 
	FEMININO("F", "Feminino");
	
	private String descricao;
    private String codigo;

    private Sexo(String codigo, String label) {
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
