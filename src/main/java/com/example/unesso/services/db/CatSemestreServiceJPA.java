package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatSemestre;
import com.example.unesso.repository.CatSemestreRepository;
import com.example.unesso.services.CatSemestreService;

@Service
@Primary
public class CatSemestreServiceJPA implements CatSemestreService {
	@Autowired
	private CatSemestreRepository catSemestreRepo;

	@Override
	public List<CatSemestre> findAll() {
		return catSemestreRepo.findAll();
	}

	@Override
	public CatSemestre findByIdCatSemestre(Integer idSemestre) {
		return catSemestreRepo.findByIdCatSemestre( idSemestre);
	}


	
}
