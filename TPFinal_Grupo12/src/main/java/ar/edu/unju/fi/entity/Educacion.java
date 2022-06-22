package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa el nivel de educacion alcanzado por el postulante
 * @author Elio
 * @version 1.0
 */

@Entity
@Table( name = "educaciones")
public class Educacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EDUCACION_ID")
	private long educacion_id;
	
	@Column(name = "NIVEL_EDUCACION", length = 30)
	@NotNull(message = "Debe completar Estado Civil")
	@Size(min=10, max=30)
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
