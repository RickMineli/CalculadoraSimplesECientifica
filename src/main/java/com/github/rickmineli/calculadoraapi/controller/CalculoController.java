package com.github.rickmineli.calculadoraapi.controller;

import com.github.rickmineli.calculadoraapi.dto.CalculoDTO;
import com.github.rickmineli.calculadoraapi.model.Calculo;
import com.github.rickmineli.calculadoraapi.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/calculos")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @PostMapping
    public Calculo postCalculo(@RequestBody CalculoDTO calculo){
        return calculoService.salvaNovoCalculo(calculo.getEquacaoEmLista(),calculo.getTipoDeCalculo());
    }
}
