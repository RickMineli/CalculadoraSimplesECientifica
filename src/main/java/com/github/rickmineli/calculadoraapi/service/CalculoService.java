package com.github.rickmineli.calculadoraapi.service;

import com.github.rickmineli.calculadoraapi.model.Calculo;
import com.github.rickmineli.calculadoraapi.model.TipoDeCalculo;
import com.github.rickmineli.calculadoraapi.repository.CalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculoService {

    @Autowired
    private CalculoRepository calculoRepository;

    public Calculo salvaNovoCalculo(List<Object> equacaoEmLista, TipoDeCalculo tipoDeCalculo){
        return calculoRepository.save(new Calculo(equacaoEmLista,tipoDeCalculo));
    }

}
