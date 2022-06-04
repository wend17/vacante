package com.example.vacantes.controller;

import com.example.vacantes.model.Vacante;
import com.example.vacantes.service.IVacantesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IVacantesService serviceVacantes;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = serviceVacantes.buscartodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDestalle(Model model) {
        Vacante vacante = new Vacante(); // variable tipo objeto
        vacante.setNombre("Ingeniero de Comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte");
        vacante.setFecha(new Date());
        vacante.setSalario(9500.0);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }
    @GetMapping("/listado")
    public String MostrarListado(Model model) {
        List<String> lista = new LinkedList<>(); // variable lista enlazada
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("vendedor");
        lista.add("Arquitecta");
        model.addAttribute("empleos", lista);
        return "listado";
    }
    @GetMapping("/")
    public String mostrarHome(Model model) {
        String nombre = "Auxiliar de Contabilidad";
        Date fechaPub = new Date();
        double salario = 9000.0;
        boolean vigente = true;
        model.addAttribute("nombre", nombre);
        model.addAttribute("fecha", new Date());
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);
        return "home";
    }

    private List<Vacante> getVacantes(){ // método, regresa una lista de obj de tipo Vacante
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante>lista=new LinkedList<>(); // lista contiene objetos de tipo vacante
        try{
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Se solicita ingeniero para diseñar puente peatonal");
            vacante1.setFecha(sdf.parse("08-02-2019"));
            vacante1.setSalario(9500.0);

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador Publico");
            vacante2.setDescripcion("Se solicita contador con cinco años de experiencia");
            vacante2.setFecha(sdf.parse("09-02-2019"));
            vacante2.setSalario(12000.0);

            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero de Software");
            vacante3.setDescripcion("Se solicita ingeniero con diez años de experiencia");
            vacante3.setFecha(sdf.parse("08-02-2019"));
            vacante3.setSalario(10500.0);

            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Ingeniero Civil");
            vacante4.setDescripcion("Se solicita ingeniero para diseñar puente peatonal");
            vacante4.setFecha(sdf.parse("08-02-2019"));
            vacante4.setSalario(7500.0);

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;

    }

}


