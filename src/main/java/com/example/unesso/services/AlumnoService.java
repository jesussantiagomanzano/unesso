package com.example.unesso.services;


import com.example.unesso.model.Alumno;

import java.util.List;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de alumnos en el sistema.
 */
public interface AlumnoService {
    void saveAlumno(Alumno alumno);

    List<Alumno> alumnos();
    Alumno findById(Integer idAlumno);
    void eliminarAlumno(Integer idAlumno);
    void guardarPaso1(Alumno alumno);
    
}
