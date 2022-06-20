package ar.edu.unju.fi.entity;

/**
 * Clase que representa la experiencia laboral del postulante
 * 
 * @author Elio
 * @version 1.0
 */
public class ExperienciaLaboral {
	private long experiencia_id;
	private String experiencia;

	/**
	 * Contructor por defecto
	 */
	public ExperienciaLaboral() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param experiencia_id identificador univoco BD
	 * @param experiencia    valor de experiencia de ExperienciaLaboral
	 */
	public ExperienciaLaboral(long experiencia_id, String experiencia) {
		super();
		this.experiencia_id = experiencia_id;
		this.experiencia = experiencia;
	}

	/*
	 * metodos accesores
	 */

	/**
	 * Devuelve id de ExperienciaLaboral
	 * 
	 * @return experiencia_id
	 */
	public long getExperiencia_id() {
		return experiencia_id;
	}

	/**
	 * Asigna valor a id de experiencia laboral de ExperienciaLaboral
	 * 
	 * @param experiencia_id
	 */
	public void setExperiencia_id(long experiencia_id) {
		this.experiencia_id = experiencia_id;
	}

	/**
	 * Devuelve experiencia de ExperinciaLaboral
	 * 
	 * @return experiencia
	 */
	public String getExperiencia() {
		return experiencia;
	}

	/**
	 * Asigna valor a experiecia de ExperienciaLaboral
	 * 
	 * @param experiencia
	 */
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

}
