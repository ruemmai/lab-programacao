package com.lab_programacao.lab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.lab_programacao.lab.models.entities.Vendas;
import com.lab_programacao.lab.models.repositories.VendasRepository;

@Service
public class VendasServices {

  @Autowired
  VendasRepository repository;

  public Vendas salvar(Vendas venda) {
    Vendas salvo = repository.save(venda);
    return salvo;
  }

  public List<Vendas> obterVendasPorData(Date data) {
    List<Vendas> vendasPorData;
    vendasPorData = repository.findVendasByData(data);
    return vendasPorData;
  }
}
