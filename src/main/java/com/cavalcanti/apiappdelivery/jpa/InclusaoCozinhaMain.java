package com.cavalcanti.apiappdelivery.jpa;

import com.cavalcanti.apiappdelivery.ApiAppDeliveryApplication;
import com.cavalcanti.apiappdelivery.model.entity.Cozinha;
import com.cavalcanti.apiappdelivery.model.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ApiAppDeliveryApplication.class)
                .web(WebApplicationType.NONE).run(args);

        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");

        cozinha1 = cadastroCozinha.insertOrUpdate(cozinha1);
        cozinha2 = cadastroCozinha.insertOrUpdate(cozinha2);

        System.out.printf("%d - %s\n",cozinha1.getId(),cozinha1.getNome());
        System.out.printf("%d - %s\n",cozinha2.getId(),cozinha2.getNome());
    }


}
