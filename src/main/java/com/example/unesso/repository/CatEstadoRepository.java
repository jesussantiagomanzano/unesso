package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatEstado;

@Description("Esta clase realiza operaciones CRUD en la entidad CatEstado de la Base de datos unesso") 
public interface CatEstadoRepository extends JpaRepository<CatEstado, Integer> {

}
