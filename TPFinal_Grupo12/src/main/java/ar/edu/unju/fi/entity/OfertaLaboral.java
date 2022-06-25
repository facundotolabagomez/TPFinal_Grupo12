package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa la oferta laboral que se desea registrar
 * 
 * @author Elio
 * @version 1.0
 */

@Entity
@Table ( name = "ofertas")
public class OfertaLaboral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OFERTA_ID")
	private long oferta_id;
	
	
	@Column(name = "CANT_VACANTES")
	@NotEmpty(message = "Debe completar Cantidad de Vacantes")	
	private int cantVacantes;
	
	@Column(name = "PUESTO_REQ", length = 50)
	@NotNull(message = "Debe completar Puesto Requerido")
	@Size(min=10, max=50)
	private String puestoRequerido;
	
	@Column(name = "RESUMEN_PUESTO", length = 150)
	@NotNull(message = "Debe completar Resumen de Puesto")
	@Size(min=10, max=150)
	private String resumenPuesto;
	
	@Column(name = "DISP_HORARIA", length = 15)
	@NotNull(message = "Debe completar Disponibilidad Horaria")
	@Size(min=5, max=15)	
	private String dispHoraria;
	
	@Column(name = "PRINC_TAREAS", length = 150)
	@NotNull(message = "Debe completar Principales Tareas")
	@Size(min=10, max=150)	
	private String princTareas;
	
	@Column(name = "DATOS_CONTACTO", length = 20)
	@NotNull(message = "Debe completar Datos de Contacto")
	@Size(min=5, max=20)
	private String datosContacto;
	
	@Column(name = "JORNADA", length = 15)
	@NotNull(message = "Debe completar Jornada")
	@Size(min=5, max=15)
	private String jornada;
	
	@Column(name = "REQUISITOS", length = 100)
	@NotNull(message = "Debe completar Requisitos")
	@Size(min=10, max=100)
	private String requisitos;
	
	@Column(name = "EXISTEOFERTA")
	private boolean existeOferta;

	/**
	 * Constructor por defecto
	 */
	public OfertaLaboral() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Contructor parametrizado
	 * 
	 * @param vacante_id      identificador univoco BD
	 * @param cantVacantes    valor de cantidad de vacantes de OfertaLaboral
	 * @param puestoRequerido valor de puesto requerido de OfertaLaboral
	 * @param resumenPuesto   valor de resumen de puesto de OfertaLaboral
	 * @param dispHoraria     valor de disponibilidad horaria de OfertaLaboral
	 * @param princTareas     valor de principales tareas de OfertaLaboral
	 * @param datosContacto   valor de datos de contacto de OfertaLaboral
	 * @param jornada         valor de tipo de jornada de OfertaLaboral
	 * @param requisitos      valor de requisitos de OfertaLaboral
	 */
	public OfertaLaboral(long oferta_id, int cantVacantes, String puestoRequerido, String resumenPuesto,
			String dispHoraria, String princTareas, String datosContacto, String jornada, String requisitos) {
		super();
		this.oferta_id = oferta_id;
		this.cantVacantes = cantVacantes;
		this.puestoRequerido = puestoRequerido;
		this.resumenPuesto = resumenPuesto;
		this.dispHoraria = dispHoraria;
		this.princTareas = princTareas;
		this.datosContacto = datosContacto;
		this.jornada = jornada;
		this.requisitos = requisitos;
	}

	/**
	 * Devuelve id de vacante de OfertaLaboral
	 * 
	 * @return vacante_id
	 */
	public long getOferta_id() {
		return oferta_id;
	}

	/**
	 * Asigna valor a id de vacante de OfertaLaboral
	 * 
	 * @param vacante_id
	 */
	public void setOferta_id(long vacante_id) {
		this.oferta_id = vacante_id;
	}

	/**
	 * Devuelve cantidad de vacantes de OfertaLaboral
	 * 
	 * @return cantVacantes
	 */
	public int getCantVacantes() {
		return cantVacantes;
	}

	/**
	 * Asigna cantidad de vacantes de OfertaLaboral
	 * 
	 * @param cantVacantes
	 */
	public void setCantVacantes(int cantVacantes) {
		this.cantVacantes = cantVacantes;
	}

	/**
	 * Devuelve puesto requerido de OfertaLaboral
	 * 
	 * @return puestoRequerido
	 */
	public String getPuestoRequerido() {
		return puestoRequerido;
	}

	/**
	 * Asigna valor a puesto requerido de OfertaLaboral
	 * 
	 * @param puestoRequerido
	 */
	public void setPuestoRequerido(String puestoRequerido) {
		this.puestoRequerido = puestoRequerido;
	}

	/**
	 * Devuelve resumen de puesto requerido de OfertaLaboral
	 * 
	 * @return resumenPuesto
	 */
	public String getResumenPuesto() {
		return resumenPuesto;
	}

	/**
	 * Asigna valor a resumen de puesto de OfertaLaboral
	 * 
	 * @param resumenPuesto
	 */
	public void setResumenPuesto(String resumenPuesto) {
		this.resumenPuesto = resumenPuesto;
	}

	/**
	 * Devuelve disponibilidad horaria de OfertaLaboral
	 * 
	 * @return dispHoraria
	 */
	public String getDispHoraria() {
		return dispHoraria;
	}

	/**
	 * Asigna valor a disponibilidad horaria de OfertaLaboral
	 * 
	 * @param dispHoraria
	 */
	public void setDispHoraria(String dispHoraria) {
		this.dispHoraria = dispHoraria;
	}

	/**
	 * Devuelve pricipales tareas de OfertaLaboral
	 * 
	 * @return princTareas
	 */
	public String getPrincTareas() {
		return princTareas;
	}

	/**
	 * Asigna valor a principales tareas de OfertaLaboral
	 * 
	 * @param princTareas
	 */
	public void setPrincTareas(String princTareas) {
		this.princTareas = princTareas;
	}

	/**
	 * Devuelve datos de contacto de OfertaLaboral
	 * 
	 * @return datosContacto
	 */
	public String getDatosContacto() {
		return datosContacto;
	}

	/**
	 * Asigna valor a datos de contacto de OfertaLaboral
	 * 
	 * @param datosContacto
	 */
	public void setDatosContacto(String datosContacto) {
		this.datosContacto = datosContacto;
	}

	/**
	 * Devuelve jornada(full - part time) de OfertaLboral
	 * 
	 * @return jornada
	 */
	public String getJornada() {
		return jornada;
	}

	/**
	 * Asigna valor a jornada (full - part time) de OfertaLaboral
	 * 
	 * @param jornada
	 */
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	/**
	 * Devuelve requisitos de OfertaLaboral
	 * 
	 * @return requisitos
	 */
	public String getRequisitos() {
		return requisitos;
	}

	/**
	 * Asigna valor a requisitos de OfertaLboral
	 * 
	 * @param requisitos
	 */
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public boolean isExisteOferta() {
		return existeOferta;
	}

	public void setExisteOferta(boolean existeOferta) {
		this.existeOferta = existeOferta;
	}
	
	

}
