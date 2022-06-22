package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * Clase que representa a un ciudadano que desea registrarse
 * 
 * @author Elio
 * @version 1.0
 */
@Entity
@Table(name = "ciudadanos")
public class Ciudadano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CIUDADANO_ID")	
	private long ciudadano_id;
	
	@Column(name = "DNI", length = 8)
	@Min(value=999999, message = "DNI No valido")
	private int dni;
	
	@Column(name = "NUMERO_TRAMITE", length = 11)
	@Min(value=999999999, message = "Numero de Tramite No Valido")
	private long numeroTramite;
	
	@Column(name = "ESTADO_CIVIL", length = 15)
	@NotNull(message = "Debe completar Estado Civil")
	@Size(min=5, max=15)	
	private String estadoCivil;
	
	@ManyToOne()
	@JoinColumn(name = "PROVINCIA_ID")	
	private Provincia provincia;
	
	@Column(name = "TELEFONO", length = 14)	
	@NotNull (message = "Debe completar el Telefono")
	@Size(min=7,max=14)
	private String telefono;
	
	@Column(name = "FECHA_NAC", length = 10)
	@NotNull(message="Debe ingresar Fecha de Nacimiento") @Past(message="Debe ser fecha anterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;
	
	@Column(name = "CIUDADANO_PASS", length = 15)
	@NotNull(message = "Debe completar Contraseña")
	@Size(min=5, max=15)	
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CURRICULUM_ID")
	@NotNull (message= "Debe Seleccionar el Curriculum")
	private Curriculum curriculum;
	
	@Column(name = "EXISTECIUDADANO")
	private boolean existeCiudadano;

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
	public Ciudadano(long ciudadano_id, int dni, long numeroTramite, String estadoCivil, Provincia provincia,
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
	public Provincia getProvincia() {
		return provincia;
	}

	/**
	 * Asigna valor de tipo Provincia a provincia de Ciudadano
	 * 
	 * @param provincia
	 */
	public void setProvincia (Provincia provincia) {
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

	public boolean isExisteCiudadano() {
		return existeCiudadano;
	}

	public void setExisteCiudadano(boolean existeCiudadano) {
		this.existeCiudadano = existeCiudadano;
	}
	
	

}
