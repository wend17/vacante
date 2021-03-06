package com.example.vacantes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categorias") // al nivel de la clase
public class CategoriasController {

    //@GetMapping("/index")
    @RequestMapping(value="/index",method= RequestMethod.GET) // al nivel de un método
    public String mostrarIndex(Model model){
        return "listCategorias";
    }

    //@GetMapping("/create")
    @RequestMapping(value="/create",method= RequestMethod.GET)
    public String crear (Model model){
        return "formCategorias";
    }


    //@GetMapping ("/save")
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public String guardar(@RequestParam("nombre") String nombre,@RequestParam("descripcion") String descripcion){
        System.out.println("Categoria:" + nombre);
        System.out.println("Descripcion:" + descripcion);
        return "formCategorias";
    }
}
