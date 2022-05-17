package com.example.vacantes.controller;

import com.example.vacantes.model.Vacante;
import com.example.vacantes.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacantesService serviceVacantes;

    @GetMapping("/create")
    public String crear() {
        return "vacantes/formVacante";
    }
    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre,
                          @RequestParam("descripcion") String descripcion,
                          @RequestParam("estatus") String estatus,
                          @RequestParam("fecha") String fecha,
                          @RequestParam("destacado") int destacado,
                          @RequestParam("salario") double salario,
                          @RequestParam("detalles") String detalles) {
        System.out.println("nombre Vacante" + nombre);
        System.out.println("Descripcion" + descripcion);
        System.out.println("Estatus" + estatus);
        System.out.println("Fecha Publicacion" + fecha);
        System.out.println("nombre Destacado" + destacado);
        System.out.println("Salario ofrecido" + salario);
        System.out.println("detalles" + detalles);
        return "vacantes/listVacantes";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {
        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        System.out.println("vacante: " + vacante);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model) {
        System.out.println("Borrando vacante con id:" + idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";
    }
}

