package com.cchaparro.springfacturacurso.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "facturas_items")
@Getter
@Setter
@Entity
public class ItemFactura implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer cantidad;

  @ManyToOne(fetch = FetchType.LAZY)
  private Producto producto;

  private static final long serialVersionUID = 1L;

  public Double cacularImport() {
    return cantidad.longValue() * producto.getPrecio();
  }
}
