package com.lab_programacao.lab.models;

import java.sql.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "numerovenda")
  private int id;

  @Column(name = "data_venda")
  private Date dataVenda;
}
