package com.cavalcanti.apiappdelivery.model.repository;

import com.cavalcanti.apiappdelivery.model.entity.FormaPagamento;

import java.util.List;

public interface FormaDePagamentoRepository {

    List<FormaPagamento> findAll();
    FormaPagamento findById(Long id);
    FormaPagamento insertOrUpdate (FormaPagamento formaPagamento);
    void remove(FormaPagamento formaPagamento);

}
