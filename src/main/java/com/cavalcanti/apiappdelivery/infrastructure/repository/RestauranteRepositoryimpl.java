package com.cavalcanti.apiappdelivery.infrastructure.repository;

import com.cavalcanti.apiappdelivery.model.entity.Restaurante;
import com.cavalcanti.apiappdelivery.model.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RestauranteRepositoryimpl implements RestauranteRepository {


    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> findAll(){
        return manager.createQuery("", Restaurante.class).getResultList();
    }

    @Override
    @Transactional
    public Restaurante insertOrUpdate(Restaurante restaurante){
        return manager.merge(restaurante);
    }

    @Override
    public Restaurante findById(Long id){
        return manager.find(Restaurante.class,id);
    }
    @Override
    @Transactional
    public void remove(Restaurante restaurante){
        //Tira o objeto do estado transient para o estado gerenciavel
        restaurante = findById(restaurante.getId());
        manager.remove(restaurante);
    }


}
