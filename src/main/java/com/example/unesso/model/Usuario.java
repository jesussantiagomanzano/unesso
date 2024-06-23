package com.example.unesso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name="idCatRol")
	private CatRol catRol;
	
	private String correo;

	@Column(name = "contraseña")
	private String contrasenia;
	
	private Boolean estatus;

	
	public Integer getIdUser() {
		return idUsuario;
	}

	public void setIdUser(Integer idUser) {
		this.idUsuario = idUser;
	}

	public CatRol getCatRol() {
		return catRol;
	}

	public void setCatRol(CatRol catRol) {
		this.catRol = catRol;
	}


	public String getPassword() {
		return contrasenia;
	}

	public void setPassword(String password) {
		this.contrasenia = password;
	}

	public Boolean getStatus() {
		return estatus;
	}

	public void setStatus(Boolean status) {
		this.estatus = status;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"idUsuario=" + idUsuario +
				", catRol=" + catRol +
				", correo='" + correo + '\'' +
				", contrasenia='" + contrasenia + '\'' +
				", estatus=" + estatus +
				'}';
	}
}
