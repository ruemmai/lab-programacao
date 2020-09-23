package com.lab_programacao.lab.models;

import javax.persistence.*;

@Entity
@Table(name = "mercadorias")
public class Mercadorias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "codigo")
  private int id;

  @Column(name = "descricao")
  private String descricao;
}
