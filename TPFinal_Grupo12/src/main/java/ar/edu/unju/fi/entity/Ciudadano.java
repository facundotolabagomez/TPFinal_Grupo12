package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa a un ciudadano que desea registrarse
 * 
 * @author Elio
 * @version 1.0
 */
public class Ciudadano {
	private long ciudadano_id;
	private int dni;
	private long numeroTramite;
	private String estadoCivil;
	private List <Provincia> provincia;
	private String telefono;
	private LocalDate fechaNac;
	private String password;
	private Curriculum curriculum;

	/**
	 * Constructor por defecto
	 */
	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor Parametrizado
	 * 
	 * @param ciudadano_id  Identificador univoco BD
	 * @param dni           valor del numero documento de Ciudadano
	 * @param numeroTramite valor del numero del tramite de Ciudadano
	 * @param estadoCivil   valor del estado civil de Ciudadano
	 * @param provincia     valor de tipo Provincia de Ciudadano
	 * @param telefono      valor de telefono de Ciudadano
	 * @param fechaNac      valor de fecha nacimiento de Ciudadano
	 * @param pasword       valor de password registrada de Ciudadano
	 * @param curriculum    valor de tipo Curriculum de Ciudadano
	 */
	public Ciudadano(long ciudadano_id, int dni, long numeroTramite, String estadoCivil, List <Provincia> provincia,
			String telefono, LocalDate fechaNac, String password, Curriculum curriculum) {
		super();
		this.ciudadano_id = ciudadano_id;
		this.dni = dni;
		this.numeroTramite = numeroTramite;
		this.estadoCivil = estadoCivil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.password = password;
		this.curriculum = curriculum;
	}

	/*
	 * metodos accesores
	 */

	/**
	 * Devuelve id de Ciudadano
	 * 
	 * @return ciudadadano_id
	 */
	public long getCiudadano_id() {
		return ciudadano_id;
	}

	/**
	 * Asigna un valor a ciudadano_id
	 * 
	 * @param ciudadano_id
	 */
	public void setCiudadano_id(long ciudadano_id) {
		this.ciudadano_id = ciudadano_id;
	}

	/**
	 * Devuelve dni de Ciudadano
	 * 
	 * @return dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * Asigna un valor a dni de Ciudadano
	 * 
	 * @param dni
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve el numero de tramite de Ciudadano
	 * 
	 * @return numeroTramite
	 */
	public long getNumeroTramite() {
		return numeroTramite;
	}

	/**
	 * Asigna un valor al numero de tramite de Ciudadano
	 * 
	 * @param numeroTramite
	 */
	public void setNumeroTramite(long numeroTramite) {
		this.numeroTramite = numeroTramite;
	}

	/**
	 * Devuelve estado civil de Ciudadano
	 * 
	 * @return estadoCivil
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * Asigna un valor a estado civil de Ciudadano
	 * 
	 * @param estadoCivil
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * Devuelve procincia de Ciudadano
	 * 
	 * @return provincia
	 */
	public List<Provincia> getProvincia() {
		return provincia;
	}

	/**
	 * Asigna valor de tipo Provincia a provincia de Ciudadano
	 * 
	 * @param provincia
	 */
	public void setProvincia(List<Provincia> provincia) {
		this.provincia = provincia;
	}

	/**
	 * Devuelve  telefono de Ciudadano
	 * 
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Asigna un valor a telefeno de Ciudadano
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve fecha de naciemiento de Ciudadano
	 * 
	 * @return fechanac
	 */
	public LocalDate getFechaNac() {
		return fechaNac;
	}

	/**
	 * Asigna un valor a fecha de nacieminto de Ciudadano
	 * 
	 * @param fechaNac
	 */
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * Devuelve password de Ciudadano
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Asigna un valor a password de Ciudadano
	 * 
	 * @param pasword
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Devuelve Curriculum de Ciudadano
	 * 
	 * @return curriculum
	 */
	public Curriculum getCurriculum() {
		return curriculum;
	}

	/**
	 * Asigna un valor a curriculum de Ciudadano
	 * 
	 * @param curriculum
	 */
	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}
