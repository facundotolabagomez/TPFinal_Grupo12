package ar.edu.unju.fi.entity;

/**
 * Clase que representa la oferta laboral que se desea registrar
 * 
 * @author Elio
 * @version 1.0
 */
public class OfertaLaboral {
	private long vacante_id;
	private int cantVacantes;
	private String puestoRequerido;
	private String resumenPuesto;
	private String dispHoraria;
	private String princTareas;
	private String datosContacto;
	private String jornada;
	private String requisitos;

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
	public OfertaLaboral(long vacante_id, int cantVacantes, String puestoRequerido, String resumenPuesto,
			String dispHoraria, String princTareas, String datosContacto, String jornada, String requisitos) {
		super();
		this.vacante_id = vacante_id;
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
	public long getVacante_id() {
		return vacante_id;
	}

	/**
	 * Asigna valor a id de vacante de OfertaLaboral
	 * 
	 * @param vacante_id
	 */
	public void setVacante_id(long vacante_id) {
		this.vacante_id = vacante_id;
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

}
