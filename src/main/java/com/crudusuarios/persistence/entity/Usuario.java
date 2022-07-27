package com.crudusuarios.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long idUsuario;
	private String nombre;
	private String apellidos;
	@Column(name = "telefono_celular")
	private long telefonoCelular;
	private String direccion;
	@Column(name = "correo_electronico")
	private String correoElectronico;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public long getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(long telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
}
