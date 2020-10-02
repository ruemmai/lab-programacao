package com.lab_programacao.lab.models.repositories;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lab_programacao.lab.models.entities.Vendas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VendasRepositoryTest {

  @Autowired
  VendasRepository repository;

  @Test
  void deveVerificarSalvarVenda() {
    // Cenário
    Vendas venda = Vendas.builder().dataVenda(new Date()).build();

    // Ação
    Vendas salvo = repository.save(venda);

    // Verificação
    Assertions.assertNotNull(salvo);
    Assertions.assertNotEquals(venda.getId(), salvo.getId());
    Assertions.assertEquals(venda.getDataVenda(), salvo.getDataVenda());
  }
}
