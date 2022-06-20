package ar.edu.unju.fi.entity;

/**
 * Clase que representa el nivel de educacion alcanzado por el postulante
 * @author Elio
 * @version 1.0
 */
public class Educacion {
	private long educacion_id;
	private String nivelAlcanzado;

	/**
	 * Constructor por defecto
	 */
	public Educacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param educacion_id   identificador univoco BD
	 * @param nivelAlcanzado valor de nivel de educacion alcanzado de Educacion
	 */
	public Educacion(long educacion_id, String nivelAlcanzado) {
		super();
		this.educacion_id = educacion_id;
		this.nivelAlcanzado = nivelAlcanzado;
	}

	/*
	 * metodos accesores
	 */

	/**
	 * Devuelve id de Educacion
	 * 
	 * @return educacion_id
	 */
	public long getEducacion_id() {
		return educacion_id;
	}

	/**
	 * Asigna un valor a educacion_id
	 * 
	 * @param educacion_id
	 */
	public void setEducacion_id(long educacion_id) {
		this.educacion_id = educacion_id;
	}

	/**
	 * Devuelve nivel de educacion alcanzado de Educaion
	 * 
	 * @return nivelAlcanzado
	 */
	public String getNivelAlcanzado() {
		return nivelAlcanzado;
	}

	/**
	 * Asigna valor a nivel de educacion alcanzado de Educacion
	 * 
	 * @param nivelAlcanzado
	 */
	public void setNivelAlcanzado(String nivelAlcanzado) {
		this.nivelAlcanzado = nivelAlcanzado;
	}

}
