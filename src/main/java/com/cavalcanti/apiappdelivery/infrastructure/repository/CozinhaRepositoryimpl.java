package com.cavalcanti.apiappdelivery.infrastructure.repository;

import com.cavalcanti.apiappdelivery.model.entity.Cozinha;
import com.cavalcanti.apiappdelivery.model.repository.CozinhaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryimpl implements CozinhaRepository {


    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> findAll(){
        return manager.createQuery("",Cozinha.class).getResultList();
    }

    @Override
    @Transactional
    public Cozinha insertOrUpdate(Cozinha cozinha){
        return manager.merge(cozinha);
    }
    @Override
    public Cozinha findById(Long id){
        return manager.find(Cozinha.class,id);
    }
    @Override
    @Transactional
    public void remove(Cozinha cozinha){
        //Tira o objeto do estado transient para o estado gerenciavel
        cozinha = findById(cozinha.getId());
        manager.remove(cozinha);
    }


}
