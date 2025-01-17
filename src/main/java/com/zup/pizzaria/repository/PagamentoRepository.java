package com.zup.pizzaria.repository;

import com.zup.pizzaria.models.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository <PagamentoModel, Long> {
}
