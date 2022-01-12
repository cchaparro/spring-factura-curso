package com.cchaparro.springfacturacurso.controllers;

import com.cchaparro.springfacturacurso.models.entity.Cliente;
import com.cchaparro.springfacturacurso.models.services.IClienteServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @Autowired
    IClienteServices clienteServices;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("Titulo", "listado de cliente");
        model.addAttribute("Clientes", clienteServices.findAll());

        return "listar";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String crear(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("Titulo", "Formulario de cliente");
        model.addAttribute("cliente", cliente);

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String guardar(Cliente cliente) {
        clienteServices.save(cliente);

        return "redirect:listar";
    }

}
