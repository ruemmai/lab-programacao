package com.lab_programacao.lab.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venda_mercadoria")
public class VendaMercadoria {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "venda_mercadoria")
  private int id;

  @Column(name = "numerovenda")
  private Long venda;

  @Column(name = "codigo")
  private Long mercadoria;
}
