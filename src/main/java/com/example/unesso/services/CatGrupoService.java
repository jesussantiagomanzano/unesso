package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatGrupo;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatGrupo en el sistema.
 */
public interface CatGrupoService {
    List<CatGrupo> findAll();
    CatGrupo findById(Integer idGroup);
    CatGrupo findByIdCarreraIdSemestre(Integer idCarrera, Integer idSemestre);
    CatGrupo findByName(String nombreGrupo);
}
