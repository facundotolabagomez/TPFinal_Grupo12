package ar.edu.unju.fi.entity;

/**
 * Clase que representa idioma/s registrados por el postulante
 * 
 * @author Elio
 * @version 1.0
 */
public class Idioma {
	private long idioma_id;
	private String idioma;

	/**
	 * Contructor por defecto
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
	public Idioma(long idioma_id, String idioma) {
		super();
		this.idioma_id = idioma_id;
		this.idioma = idioma;
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
	public String getIdioma() {
		return idioma;
	}

	/**
	 * Asigna valor a idioma de Idioma
	 * 
	 * @param idioma
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
