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
 * Clase que representa idioma/s registrados por el postulante
 * 
 * @author Elio
 * @version 1.0
 */
@Entity
@Table (name = "idiomas")
public class Idioma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDIOMA_ID")
	private long idioma_id;
	
	@Column(name = "NOMBRE_IDIOMA", length = 15)
	@NotNull(message = "Debe completar Idioma")
	@Size(min=5, max=15)	
	private String nombreIdioma;

	/**
	 * Constructor por defecto
	 */
	public Idioma() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construcror parametrizado
	 * 
	 * @param idioma_id identificador univoco BD
	 * @param idioma    valor idioma de Idioma
	 */
	public Idioma(long idioma_id, String nombreIdioma) {
		super();
		this.idioma_id = idioma_id;
		this.nombreIdioma = nombreIdioma;
	}

	/*
	 * metodos accesores
	 */

	/**
	 * Devuelve id de Idioma
	 * 
	 * @return idioma_id
	 */
	public long getIdioma_id() {
		return idioma_id;
	}

	/**
	 * Asigna valor al id de idioma de Idioma
	 * 
	 * @param idioma_id
	 */
	public void setIdioma_id(long idioma_id) {
		this.idioma_id = idioma_id;
	}

	/**
	 * Devuelve idioma de Idioma
	 * 
	 * @return idioma
	 */
	public String getNombreIdioma() {
		return nombreIdioma;
	}

	/**
	 * Asigna valor a idioma de Idioma
	 * 
	 * @param idioma
	 */
	public void setNombreIdioma(String nombreIdioma) {
		this.nombreIdioma = nombreIdioma;
	}

}
