package com.example.unesso.services.db;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Usuario;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.UsuarioRepository;
import com.example.unesso.services.UsuarioService;

@Service
@Primary
public class UsuarioServiceJPA implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public Usuario findByCorreo(String correo) {
		return usuarioRepo.findByCorreo(correo);
	}

	@Override
    public void eliminarAlumno(Integer idAlumno) {
        usuarioRepo.deleteById(idAlumno);
    }

	@Override
    public Usuario findById(Integer idAlumno) {
		if(usuarioRepo.findById(idAlumno).isPresent()){
			return usuarioRepo.findById(idAlumno).get();
		}
		else{
			throw new RuntimeErrorException(null, "Usuario no encontrado");
		}
    }

}
