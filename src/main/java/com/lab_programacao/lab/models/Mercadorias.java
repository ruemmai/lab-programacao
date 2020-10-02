package com.lab_programacao.lab.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mercadorias")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mercadorias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "codigo")
  private int id;

  @Column(name = "descricao")
  private String descricao;
}
