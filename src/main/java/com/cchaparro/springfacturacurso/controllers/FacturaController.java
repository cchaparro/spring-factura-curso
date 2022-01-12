package com.cchaparro.springfacturacurso.controllers;

import com.cchaparro.springfacturacurso.models.entity.Cliente;
import com.cchaparro.springfacturacurso.models.entity.Factura;
import com.cchaparro.springfacturacurso.models.services.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/factura")
@SessionAttributes(value = "factura")
public class FacturaController {

    @Autowired
    IClienteServices clienteServices;

    @GetMapping("/form/{clienteID}")
    public String crear(
            @PathVariable(value = "clienteID") Long clienteID,
            Model model,
            RedirectAttributes fash) {

        Cliente cliente = clienteServices.finfById(clienteID);

        if (cliente == null) {

            fash.addAttribute("error", "El cliente no existe");
            return "redirect:listar";
        }

        Factura factura = new Factura();

        factura.setCliente(cliente);

        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Crear Factura");

        return "factura/form";
    }
}
