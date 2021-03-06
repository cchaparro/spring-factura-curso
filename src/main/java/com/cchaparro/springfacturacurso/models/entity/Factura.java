package com.cchaparro.springfacturacurso.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String descripcion;
  private String observacion;

  @Temporal(TemporalType.DATE)
  @Column(name = "create_at")
  private Date createAt;

  @ManyToOne(fetch = FetchType.LAZY)
  private Cliente cliente;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "factura_id")
  List<ItemFactura> listItems;

  public Factura() {
    this.listItems = new ArrayList<>();
  }

  @PrePersist
  public void prePersist() {
    createAt = new Date();
  }

  public void addItemFactura(ItemFactura itemFactura) {
    listItems.add(itemFactura);
  }

  public Double getTotal() {
    Double total = 0.0;

    for (int i = 0; i < listItems.size(); i++) {
      total = total + listItems.get(i).cacularImport();
    }

    return total;
  }

  private static final long serialVersionUID = 1L;
}
