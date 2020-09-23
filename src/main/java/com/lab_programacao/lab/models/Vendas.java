package com.lab_programacao.lab.models;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "vendas")
public class Vendas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "numerovenda")
  private int id;

  @Column(name = "data_venda")
  private Date dataVenda;
}
