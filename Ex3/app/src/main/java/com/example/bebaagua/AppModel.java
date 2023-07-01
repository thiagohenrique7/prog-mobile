package com.example.bebaagua;

public class AppModel {
    private final Integer MILILITRO_POR_COPO = 150;
    private Double quilos;
    private Integer qtdFaltante;
    private Integer qtdBebida;
    private Integer qtdCopos;

    public AppModel() {
        this.qtdCopos = null;
        this.quilos = null;
        this.qtdBebida = 0;
        this.qtdFaltante = 0;
    }

    public Double getQuilos() {
        return quilos;
    }

    public void setQuilos(Double quilos) {
        this.quilos = quilos;
    }

    public Integer getQtdCopos() {
        return qtdCopos;
    }

    public void setQtdCopos() {
        Double mililitros = Math.ceil(this.quilos*35);
        qtdCopos = (int) Math.floor(mililitros/MILILITRO_POR_COPO);
        this.qtdCopos = qtdCopos;
    }

    public Integer getQtdFaltante() {
        return qtdFaltante;
    }

    public void setQtdFaltante(Integer qtdFaltante) {
        this.qtdFaltante = qtdFaltante;
    }

    public Integer getQtdBebida() {
        return qtdBebida;
    }

    public void setQtdBebida(Integer qtdBebida) {
        this.qtdBebida = qtdBebida;
    }
}
