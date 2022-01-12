package com.cchaparro.springfacturacurso.models.dao;

import com.cchaparro.springfacturacurso.models.entity.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
}
