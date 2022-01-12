package com.cchaparro.springfacturacurso.models.services;

import java.util.List;

import com.cchaparro.springfacturacurso.models.entity.Cliente;

public interface IClienteServices {

    public void save(Cliente cliente);
    public List<Cliente> findAll();
    public Cliente finfById( Long id);
    
}
