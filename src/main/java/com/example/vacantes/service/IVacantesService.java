package com.example.vacantes.service;

import com.example.vacantes.model.Vacante;

import java.util.List;

public interface IVacantesService {
    List<Vacante> buscartodas();
    Vacante buscarPorId(Integer idvacante);
}
