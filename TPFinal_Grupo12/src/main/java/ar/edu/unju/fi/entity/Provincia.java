package ar.edu.unju.fi.entity;

/**
 * Clase que representa provincia de residencia
 * 
 * @author Elio
 * @version 1.0
 */
public class Provincia {
	private long provincia_id;
	private String nombre;

	/**
	 * Constructor por defecto
	 */
	public Provincia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param provincia_id valor de id de Provincia
	 * @param nombre       valor de nombre de Provincia
	 */
	public Provincia(long provincia_id, String nombre) {
		super();
		this.provincia_id = provincia_id;
		this.nombre = nombre;
	}

	/*
	 * metodos accesores
	 */

	/**
	 * Devuelve id de Provincia
	 * 
	 * @return provincia_id
	 */
	public long getProvincia_id() {
		return provincia_id;
	}

	/**
	 * Asigna un valor a id de Provincia(verificar)
	 * 
	 * @param provincia_id
	 */
	public void setProvincia_id(long provincia_id) {
		this.provincia_id = provincia_id;
	}

	/**
	 * Devuelve nombre de Provincia
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna valor a nombre de Provincia
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
