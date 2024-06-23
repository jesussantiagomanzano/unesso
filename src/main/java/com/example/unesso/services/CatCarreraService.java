package com.example.unesso.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.unesso.model.CatCarrera;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de catCarrera en el sistema.
 */
@Service
public interface CatCarreraService {
    List<CatCarrera> listaCarreras();
    CatCarrera findCarreraByCarrera(String nombreCarrera);
    

}
