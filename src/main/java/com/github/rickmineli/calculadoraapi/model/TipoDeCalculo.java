package com.github.rickmineli.calculadoraapi.model;

import java.util.List;

public enum TipoDeCalculo {

    SIMPLES {
        @Override
        public Double executaEquacao(List<Object> equacaoEmLista) {
            Double primeroNumero = (Double) equacaoEmLista.get(0);
            Double segundoNumero;
            Operacao operacao;

            for (int i = 1; i < equacaoEmLista.size(); i = i + 2) {
                operacao = Operacao.valueOf((String) equacaoEmLista.get(i));
                segundoNumero = (Double) equacaoEmLista.get(i + 1);
                primeroNumero = operacao.executarOperacao(primeroNumero, segundoNumero);
            }
            return primeroNumero;
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
