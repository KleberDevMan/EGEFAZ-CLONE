package br.gov.to.egefaz.security.domain;

public enum TipoUsuario {

    SERVIDOR_INTERNO("1","servidor interno"),
    SERVIDOR_EXTERNO("2","servidor externo"),
    CIDADAO_COMUM("3","cidadao comum");

    public static TipoUsuario fromCodigo(String tipoUsuario) {

        if (tipoUsuario == null) {
            tipoUsuario = "1";
        }
        
        for (final TipoUsuario tipo : TipoUsuario.values()) {

            if (tipoUsuario.equals(tipo.getCodigo())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Codigo nao encontrado: ".concat(tipoUsuario));
    }

    private String label;
    private String codigo;

    private TipoUsuario(String codigo, String label) {
        this.label = label;
        this.codigo = codigo;
    }
    
    public String getLabel() {
        return label;
    }

    public String getCodigo() {
        return codigo;
    }

    

}
