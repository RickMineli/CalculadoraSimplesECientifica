package com.github.rickmineli.calculadoraapi.model;

import com.github.rickmineli.calculadoraapi.exception.JSONInvalidoException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "calculo")
public class Calculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private List<Object> equacaoEmLista;

    @Column(name = "equacao", nullable = false)
    private String equacao = "";

    @Column(name = "resultado", length = 12, nullable = false)
    private Double resultado;

    @Column(name = "tipoDeCalculo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDeCalculo tipoDeCalculo;

    @Column(name = "dataCalculo", nullable = false)
    private LocalDateTime dataCalculo;

    protected Calculo() {
    }

    public Calculo(List<Object> equacaoEmLista, TipoDeCalculo tipoDeCalculo) {
        if (equacaoEmLista.isEmpty())
            throw new JSONInvalidoException("Lista Vazia");
        for (int i = 0; i < equacaoEmLista.size(); i = i + 2) {
            equacaoEmLista.set(i,Double.parseDouble((String) equacaoEmLista.get(i)));
        }
        verificaValoresNegativos(equacaoEmLista);
        verificaDivisaoPorZero(equacaoEmLista);
        this.equacaoEmLista = equacaoEmLista;
        this.equacao = equacaoEmLista.toString().replaceAll("[\\s|,|\\[|\\]]", "")
                .replaceAll("SOMA", "+")
                .replaceAll("SUBTRACAO", "-")
                .replaceAll("MULTIPLICACAO", "*")
                .replaceAll("DIVISAO", "/");
        this.tipoDeCalculo = tipoDeCalculo;
        this.dataCalculo = LocalDateTime.now();
        this.resultado = this.tipoDeCalculo.executaEquacao(this.equacaoEmLista);
    }

    private void verificaDivisaoPorZero(List<Object> equacaoEmLista) {
        for (int i = 1; i < equacaoEmLista.size(); i = i + 2) {
            if ((equacaoEmLista.get(i).equals(Operacao.DIVISAO.toString())) && ((Double) equacaoEmLista.get(i+1) == 0.0))
                throw new JSONInvalidoException("Divisao por zero.");
        }
    }

    private void verificaValoresNegativos(List<Object> equacaoEmLista) {
        for (int i = 0; i < equacaoEmLista.size(); i = i + 2) {
            if ((Double) equacaoEmLista.get(i) < 0)
                throw new JSONInvalidoException("Valores Negativos");
        }
    }

    public Long getId() {
        return id;
    }

    public String getEquacao() {
        return equacao;
    }

    public Double getResultado() {
        return resultado;
    }

    public TipoDeCalculo getTipoDeCalculo() {
        return tipoDeCalculo;
    }

    public LocalDateTime getDataCalculo() {
        return dataCalculo;
    }
}
