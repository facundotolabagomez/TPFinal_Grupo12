package ar.edu.unju.fi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa provincia de residencia
 * 
 * @author Elio
 * @version 1.0
 */
@Entity
@Table (name = "provincias")
public class Provincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROVINCIA_ID")
	private long provincia_id;
	
	@OneToMany(
			mappedBy = "provincia", 
			cascade = CascadeType.ALL, 
			orphanRemoval = false)
	private List<Ciudadano> ciudadanos;
	
	@OneToMany(
			mappedBy = "provincia", 
			cascade = CascadeType.ALL, 
			orphanRemoval = false)
	private List<Empleador> empleadores;
	
	
	@Column(name = "NOMBRE_PROVINCIA", length = 20)
	@NotNull(message = "Debe Ingresar Contraseña")
	@Size(min=5, max=20)
	private String nombreProvincia;

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
	public Provincia(long provincia_id, String nombreProvincia) {
		super();
		this.provincia_id = provincia_id;
		this.nombreProvincia = nombreProvincia;
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
	public String getNombreProvincia() {
		return nombreProvincia;
	}

	/**
	 * Asigna valor a nombre de Provincia
	 * 
	 * @param nombre
	 */
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public List<Empleador> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(List<Empleador> empleadores) {
		this.empleadores = empleadores;
	}
	
	

}
