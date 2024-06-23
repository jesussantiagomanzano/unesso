package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatSemestre;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatSemestre en el sistema.
 */
public interface CatSemestreService {
    List<CatSemestre> findAll();
    CatSemestre findByIdCatSemestre(Integer idSemestre);
}
