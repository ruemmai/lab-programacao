package com.lab_programacao.lab.models.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

  @Test
  void deveVerificarObterVendasPorData() {
    // Cenário
    List<Vendas> vendas = new ArrayList<Vendas>();

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2020);

    calendar.set(Calendar.MONTH, Calendar.OCTOBER);
    calendar.set(Calendar.DAY_OF_MONTH, 02);
    Date dateVendaA = calendar.getTime();
    Vendas vendaA = Vendas.builder().dataVenda(dateVendaA).build();
    vendas.add(vendaA);

    calendar.set(Calendar.MONTH, Calendar.OCTOBER);
    calendar.set(Calendar.DAY_OF_MONTH, 01);
    Date dataVendaB = calendar.getTime();
    Vendas vendaB = Vendas.builder().dataVenda(dataVendaB).build();
    vendas.add(vendaB);

    calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
    calendar.set(Calendar.DAY_OF_MONTH, 01);
    Date dataVendaC = calendar.getTime();
    Vendas vendaC = Vendas.builder().dataVenda(dataVendaC).build();
    vendas.add(vendaC);

    for (Vendas venda : vendas) {
      repository.save(venda);
    }

    // Ação
    Calendar obterVendasCalendar = Calendar.getInstance();
    obterVendasCalendar.set(Calendar.YEAR, 2020);
    obterVendasCalendar.set(Calendar.MONTH, Calendar.OCTOBER);
    obterVendasCalendar.set(Calendar.DAY_OF_MONTH, 01);

    Date dataObterVendas = obterVendasCalendar.getTime();

    List<Vendas> vendasObtidas = repository.findVendasByData(dataObterVendas);

    // Verificação
    for (Vendas vendaObtida : vendasObtidas) {
      Assertions.assertEquals(vendaObtida.getDataVenda(), dataObterVendas);
    }

  }
}
