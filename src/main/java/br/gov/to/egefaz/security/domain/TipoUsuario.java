package br.gov.to.egefaz.security.domain;

public enum TipoUsuario {

    SERVIDOR_INTERNO("SI", "servidor interno"),
    SERVIDOR_EXTERNO("SE", "servidor externo"),
    CIDADAO_COMUM("CC", "cidadao comum");

    private String descricao;
    private String codigo;

    private TipoUsuario(String codigo, String label) {
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
        return getCodigo(); //To change body of generated methods, choose Tools | Templates.
    }
}
