package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatCarrera;
import com.example.unesso.repository.CatCarreraRepository;
import com.example.unesso.services.CatCarreraService;

@Service
@Primary
public class CatCarreraServiceJPA implements CatCarreraService {
	@Autowired
	private CatCarreraRepository catCarreraRepo;

	@Override
	public List<CatCarrera> listaCarreras(){
		return catCarreraRepo.findAll();
	}

	@Override
	public CatCarrera findCarreraByCarrera(String nombreCarrera) {
		return catCarreraRepo.findByCarrera(nombreCarrera);
	}

	
	
}
