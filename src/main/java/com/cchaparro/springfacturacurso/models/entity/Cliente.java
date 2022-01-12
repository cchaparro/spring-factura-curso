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

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    @DateTimeFormat (pattern = "yyyy-mmdd")
    private Date createAt;
    @OneToMany(mappedBy = "cliente",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List <Factura> listFacturas;

    private String foto;

    public Cliente(){

        listFacturas=new ArrayList<>();
    }

    public void addFactura(Factura factura){
        listFacturas.add(factura);
    }
    private static final long serialVersionUID= 1L;
}
