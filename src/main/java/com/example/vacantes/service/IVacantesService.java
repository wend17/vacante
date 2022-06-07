package com.example.vacantes.service;

import com.example.vacantes.model.Vacante;

import java.util.List;

public interface IVacantesService {
    List<Vacante> buscartodas(); //método que regresa una lista de objetos de tipo vacante
    Vacante buscarPorId(Integer idvacante);
}
