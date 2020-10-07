package com.lab_programacao.lab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.lab_programacao.lab.models.entities.Mercadorias;
import com.lab_programacao.lab.models.entities.VendaMercadoria;
import com.lab_programacao.lab.models.entities.Vendas;
import com.lab_programacao.lab.models.repositories.MercadoriasRepository;
import com.lab_programacao.lab.models.repositories.VendaMercadoriaRepository;
import com.lab_programacao.lab.models.repositories.VendasRepository;

@Service
public class VendasServices {

  @Autowired
  VendasRepository vendasRepository;

  @Autowired
  MercadoriasRepository mercadoriasRepository;

  @Autowired
  VendaMercadoriaRepository vendaMercadoriaRepositiry;

  public Vendas salvar(Vendas venda) {
    Vendas salvo = vendasRepository.save(venda);
    return salvo;
  }

  public List<Vendas> obterVendasPorData(Date data) {
    List<Vendas> vendasPorData;
    vendasPorData = vendasRepository.findVendasByData(data);
    return vendasPorData;
  }

  public Vendas venderMecadoria(Mercadorias mercadorias) {
    Vendas novaVenda = Vendas.builder().dataVenda(new Date()).build();
    vendasRepository.save(novaVenda);

    Mercadorias mercadoriaSalva;
    mercadoriaSalva = mercadoriasRepository.save(mercadorias);

    VendaMercadoria novaVendaMercadoria = VendaMercadoria.builder().venda(Long.valueOf(novaVenda.getId()))
        .mercadoria(Long.valueOf(mercadoriaSalva.getId())).build();

    vendaMercadoriaRepositiry.save(novaVendaMercadoria);

    return novaVenda;
  }
}
