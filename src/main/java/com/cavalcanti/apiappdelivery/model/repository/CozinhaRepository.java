package com.cavalcanti.apiappdelivery.model.repository;

import com.cavalcanti.apiappdelivery.model.entity.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> findAll();
    Cozinha findById(Long id);
    Cozinha insertOrUpdate (Cozinha cozinha);
    void remove(Cozinha cozinha);

}
