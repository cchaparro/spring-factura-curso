package com.cchaparro.springfacturacurso.models.services;

import java.util.List;

import com.cchaparro.springfacturacurso.models.dao.ClienteDao;
import com.cchaparro.springfacturacurso.models.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicesImpl implements IClienteServices {

    @Autowired
    ClienteDao clienteDao;

    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);

    }

    @Override
    public List<Cliente> findAll() {

        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente finfById(Long id) {

        return clienteDao.findById(id).get();
    }

}
