package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.unesso.model.CatGrupo;


@Description("Esta clase realiza operaciones CRUD en la entidad CatGrupo de la Base de datos unesso") 
@Repository
public interface CatGrupoRepository extends JpaRepository<CatGrupo, Integer> {
    CatGrupo findByNombreGrupo(String nombreGrupo);


    CatGrupo findByCatCarreraIdCatCarreraAndCatSemestreIdCatSemestre(Integer idCatCarrera, Integer idCatSemestre);



}
