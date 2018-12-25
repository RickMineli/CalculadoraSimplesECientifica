package com.github.rickmineli.calculadoraapi.model;

import java.util.List;

public enum TipoDeCalculo {

    SIMPLES {
        @Override
        public Double executaEquacao(List<Object> equacaoEmLista) {
            Double numeroUm = (Double) equacaoEmLista.get(0);
            Double numeroDois;
            Operacao operacao;

            for (int i = 1; i < equacaoEmLista.size(); i = i + 2) {
                operacao = Operacao.valueOf((String) equacaoEmLista.get(i));
                numeroDois = (Double) equacaoEmLista.get(i + 1);
                numeroUm = operacao.executarOperacao(numeroUm, numeroDois);
            }
            return numeroUm;
        }
    },
    CIENTIFICA {
        @Override
        public Double executaEquacao(List<Object> equacaoEmLista) {
            return null;
        }
    };

    public abstract Double executaEquacao(List<Object> equacaoEmLista);
}
