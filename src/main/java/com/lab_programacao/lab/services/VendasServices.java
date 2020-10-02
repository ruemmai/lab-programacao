package com.lab_programacao.lab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

import java.sql.Date;

import com.lab_programacao.lab.models.Vendas;
import com.lab_programacao.lab.repositories.VendasRepository;

@Service
public class VendasServices {

  @Autowired
  VendasRepository repository;

  public Vendas salvar(Vendas venda) {
    Vendas salvo = repository.save(venda);
    return salvo;
  }

  public List<Vendas> obterPorData(Date data) {
    return repository.findAll();
  }
}
