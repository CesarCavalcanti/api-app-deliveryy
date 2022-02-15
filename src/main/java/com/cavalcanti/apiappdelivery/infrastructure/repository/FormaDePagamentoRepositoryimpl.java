package com.cavalcanti.apiappdelivery.infrastructure.repository;

import com.cavalcanti.apiappdelivery.model.entity.FormaPagamento;
import com.cavalcanti.apiappdelivery.model.repository.FormaDePagamentoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FormaDePagamentoRepositoryimpl implements FormaDePagamentoRepository {


    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> findAll(){
        return manager.createQuery("",FormaPagamento.class).getResultList();
    }

    @Override
    @Transactional
    public FormaPagamento insertOrUpdate(FormaPagamento formaPagamento){
        return manager.merge(formaPagamento);
    }
    @Override
    public FormaPagamento findById(Long id){
        return manager.find(FormaPagamento.class,id);
    }
    @Override
    @Transactional
    public void remove(FormaPagamento formaPagamento){
        //Tira o objeto do estado transient para o estado gerenciavel
        formaPagamento = findById(formaPagamento.getId());
        manager.remove(formaPagamento);
    }


}
