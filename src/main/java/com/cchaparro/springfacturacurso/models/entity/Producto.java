package com.cchaparro.springfacturacurso.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Table(name = "productos")
@Getter
@Setter
@Entity
public class Producto implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  private String nombre;

  @NotEmpty
  private Double precio;

  @NotNull
  @Temporal(TemporalType.DATE)
  @Column(name = "create_at")
  private Date createAt;

  @PrePersist
  public void prePersist() {
    createAt = new Date();
  }

  private static final long serialVersionUID = 1L;
}
