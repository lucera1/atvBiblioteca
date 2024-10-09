package com.curso.domains.enums;

public enum Conservacao {
    EXCELENTE(0,"EXCELENTE"), BOM(1,"BOM"), MARCASDEUSO(2,"MARCAS DE USO"), GASTO(3,"GASTO");
    private Integer id;
    private String estadoLivro;

    Conservacao(Integer id, String estadoLivro) {
        this.id = id;
        this.estadoLivro = estadoLivro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstadoLivro() {
        return estadoLivro;
    }

    public void setEstadoLivro(String estadoLivro) {
        this.estadoLivro = estadoLivro;
    }

    public static Conservacao toEnum(Integer id) {
        if(id == null) return null;
        for(Conservacao x : Conservacao.values()) {
            if(id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Estado de conservação invalido");
    }

}
