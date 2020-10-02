package com.lab_programacao.lab.repositories;

import java.util.Date;
import java.util.List;

import com.lab_programacao.lab.models.Vendas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VendasRepository extends JpaRepository<Vendas, Long> {
  @Query("SELECT v FROM vendas v WHERE v.data_venda=:data ORDER BY numerovenda ASC")
  public List<Vendas> findByData(@Param(":data") Date data);
}
