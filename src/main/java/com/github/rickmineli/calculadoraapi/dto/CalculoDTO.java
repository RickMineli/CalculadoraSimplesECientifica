package com.github.rickmineli.calculadoraapi.dto;

import com.github.rickmineli.calculadoraapi.model.TipoDeCalculo;

import java.util.List;

public class CalculoDTO {
    private List<Object> equacaoEmLista;
    private TipoDeCalculo tipoDeCalculo;

    public List<Object> getEquacaoEmLista() {
        return equacaoEmLista;
    }

    public void setEquacaoEmLista(List<Object> equacaoEmLista) {
        this.equacaoEmLista = equacaoEmLista;
    }

    public TipoDeCalculo getTipoDeCalculo() {
        return tipoDeCalculo;
    }

    public void setTipoDeCalculo(TipoDeCalculo tipoDeCalculo) {
        this.tipoDeCalculo = tipoDeCalculo;
    }
}
