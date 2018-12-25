package com.github.rickmineli.calculadoraapi.repository;

import com.github.rickmineli.calculadoraapi.model.Calculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculoRepository extends JpaRepository<Calculo, Long> {
}
