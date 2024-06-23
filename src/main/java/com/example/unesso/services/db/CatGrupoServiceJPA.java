package com.example.unesso.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatGrupo;
import com.example.unesso.repository.CatGrupoRepository;
import com.example.unesso.services.CatGrupoService;

@Service
@Primary
public class CatGrupoServiceJPA implements CatGrupoService {
	@Autowired
	private CatGrupoRepository catGrupoRepo;	

	@Override
	public List<CatGrupo> findAll(){
		return catGrupoRepo.findAll();
	}

	@Override
	public CatGrupo findById(Integer idGroup){
		return catGrupoRepo.findById(idGroup).get();
	}

	@Override
	public CatGrupo findByIdCarreraIdSemestre(Integer idCatCarrera, Integer idCatSemestre) {
		return catGrupoRepo.findByCatCarreraIdCatCarreraAndCatSemestreIdCatSemestre(idCatCarrera, idCatSemestre);
	}

	
	public CatGrupo findByName(String nombreGrupo) {
		return catGrupoRepo.findByNombreGrupo(nombreGrupo);
	}

}
