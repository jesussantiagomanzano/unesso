package com.example.unesso.services.db;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatGrupo;
import com.example.unesso.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.AlumnoRepository;
import com.example.unesso.repository.CatGrupoRepository;
import com.example.unesso.repository.UsuarioRepository;
import com.example.unesso.services.AlumnoService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;


@Service
@Primary
public class AlumnoServiceJPA implements  AlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepo;

	@Autowired 
	UsuarioRepository usuarioRepository;

	@Override
	public void saveAlumno(Alumno alumno) {
		alumnoRepo.save(alumno);
	}
	
	@Autowired
	CatGrupoRepository catGrupoRepository ;


	@Override
	public List<Alumno> alumnos(){
		return alumnoRepo.findAll();
	}

	@Override
    public Alumno findById(Integer idAlumno) {
        Optional<Alumno> alumno = alumnoRepo.findById(idAlumno);

		if(alumno.isPresent()){
			return alumno.get();
		}
		else{
			throw new RuntimeErrorException(null, "Alumno no encontrado");
		}
    }


	@Transactional
	@Override
    public void guardarPaso1(Alumno alumno) {
		Optional<Alumno> alumnoTmp = alumnoRepo.findById(alumno.getIdAlumno());
		if(alumnoTmp.isPresent()){
			Alumno alumnoValidar = alumnoTmp.get();
			if(!alumnoValidar.getNombre().equals(alumno.getNombre()) && !alumno.getNombre().equals("")&& alumno.getNombre() !=null){
				alumnoValidar.setNombre(alumno.getNombre());
			}
			if(!alumnoValidar.getApellidoP().equals(alumno.getApellidoP()) && !alumno.getApellidoP().equals("")){
				alumnoValidar.setApellidoP(alumno.getApellidoP());
			}
			if(!alumnoValidar.getApellidoM().equals(alumno.getApellidoM()) && !alumno.getApellidoM().equals("")){
				alumnoValidar.setApellidoM(alumno.getApellidoM());
			}
			if(!alumnoValidar.getCurp().equals(alumno.getCurp()) && !alumno.getCurp().equals("")){
				alumnoValidar.setCurp(alumno.getCurp());
			}
			if(!alumnoValidar.getTelefono().equals(alumno.getTelefono()) && !alumno.getTelefono().equals("")){
				alumnoValidar.setTelefono(alumno.getTelefono());
			}
			if(!alumnoValidar.getMatricula().equals(alumno.getMatricula()) && !alumno.getMatricula().equals("")){
				alumnoValidar.setMatricula(alumno.getMatricula());
			}
			
			if(!alumnoValidar.getUsuario().getCorreo().equals(alumno.getUsuario().getCorreo())){
				Usuario usuario = usuarioRepository.findByCorreo(alumno.getUsuario().getCorreo());
				alumnoValidar.setUsuario(usuario);
			}

			if(!alumnoValidar.getCatGrupo().getNombreGrupo().equals(alumno.getCatGrupo().getNombreGrupo())){
				CatGrupo catGrupo = catGrupoRepository.findByNombreGrupo(alumno.getCatGrupo().getNombreGrupo());
				alumnoValidar.setCatGrupo(catGrupo);
			}

			
			alumnoRepo.save(alumnoValidar);


		}
		else{
			throw new RuntimeException("Alumno no valido");
		}
    }

	@Override
    public void eliminarAlumno(Integer idAlumno) {
		alumnoRepo.deleteById(idAlumno);
    }

}
