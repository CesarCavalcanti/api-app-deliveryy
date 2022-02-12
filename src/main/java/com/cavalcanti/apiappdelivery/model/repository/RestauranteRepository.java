package com.cavalcanti.apiappdelivery.model.repository;

import com.cavalcanti.apiappdelivery.model.entity.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> findAll();
    Restaurante findById(Long id);
    Restaurante insertOrUpdate (Restaurante restaurante);
    void remove(Restaurante restaurante);

}
