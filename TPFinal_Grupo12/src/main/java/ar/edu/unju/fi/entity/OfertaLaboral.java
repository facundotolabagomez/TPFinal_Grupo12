package ar.edu.unju.fi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "ofertas")
public class OfertaLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OFERTA_ID")
	private long oferta_id;

	@Column(name = "CANT_VACANTES")
	//@NotEmpty(message = "Debe completar Cantidad de Vacantes")
	private int cantVacantes;

	@Column(name = "PUESTO_REQ", length = 50)
	//@NotNull(message = "Debe completar Puesto Requerido")
	//@Size(min = 10, max = 50)
	private String puestoRequerido;

	@Column(name = "RESUMEN_PUESTO", length = 150)
	//@NotNull(message = "Debe completar Resumen de Puesto")
	//@Size(min = 10, max = 150)
	private String resumenPuesto;

	@Column(name = "DISP_HORARIA", length = 15)
	//@NotNull(message = "Debe completar Disponibilidad Horaria")
	//@Size(min = 5, max = 15)
	private String dispHoraria;

	@Column(name = "PRINC_TAREAS", length = 150)
	//@NotNull(message = "Debe completar Principales Tareas")
	//@Size(min = 10, max = 150)
	private String princTareas;

	@Column(name = "DATOS_CONTACTO", length = 20)
	//@NotNull(message = "Debe completar Datos de Contacto")
	//@Size(min = 5, max = 20)
	private String datosContacto;

	@Column(name = "JORNADA", length = 15)
	//@NotNull(message = "Debe completar Jornada")
	//@Size(min = 5, max = 15)
	private String jornada;

	@Column(name = "REQUISITOS", length = 100)
	//@NotNull(message = "Debe completar Requisitos")
	//@Size(min = 10, max = 100)
	private String requisitos;

	@Column(name = "SALARIO", length = 10)
	//@NotNull(message = "Debe completar Salario")
	//@Size(min = 4, max = 10)
	private double salario;

	@Column(name = "BENEFICIOS", length = 100)
	//@NotNull(message = "Debe completar Beneficios")
	@Size(min = 5, max = 100)
	private String beneficios;

	@Column(name = "DISPONIBLE")
	private boolean disponible;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLEADOR_ID")
	private Empleador empleador;

	@ManyToMany(mappedBy = "ofertas")
	private List<Ciudadano> ciudadano;

	@Column(name = "EXISTEOFERTA")
	private boolean existeOferta;

	/**
	 * Constructor por defecto
	 */
	public OfertaLaboral() {
		// TODO Auto-generated constructor stub
	}

	public OfertaLaboral(long oferta_id, @NotEmpty(message = "Debe completar Cantidad de Vacantes") int cantVacantes,
			@NotNull(message = "Debe completar Puesto Requerido") @Size(min = 10, max = 50) String puestoRequerido,
			@NotNull(message = "Debe completar Resumen de Puesto") @Size(min = 10, max = 150) String resumenPuesto,
			@NotNull(message = "Debe completar Disponibilidad Horaria") @Size(min = 5, max = 15) String dispHoraria,
			@NotNull(message = "Debe completar Principales Tareas") @Size(min = 10, max = 150) String princTareas,
			@NotNull(message = "Debe completar Datos de Contacto") @Size(min = 5, max = 20) String datosContacto,
			@NotNull(message = "Debe completar Jornada") @Size(min = 5, max = 15) String jornada,
			@NotNull(message = "Debe completar Requisitos") @Size(min = 10, max = 100) String requisitos,
			@NotNull(message = "Debe completar Salario") @Size(min = 4, max = 10) double salario,
			@NotNull(message = "Debe completar Beneficios") @Size(min = 5, max = 100) String beneficios,
			boolean disponible, Empleador empleador, List<Ciudadano> ciudadano, boolean existeOferta) {
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
		this.salario = salario;
		this.beneficios = beneficios;
		this.disponible = disponible;
		this.empleador = empleador;
		this.ciudadano = ciudadano;
		this.existeOferta = existeOferta;
	}

	public long getOferta_id() {
		return oferta_id;
	}

	public void setOferta_id(long oferta_id) {
		this.oferta_id = oferta_id;
	}

	public int getCantVacantes() {
		return cantVacantes;
	}

	public void setCantVacantes(int cantVacantes) {
		this.cantVacantes = cantVacantes;
	}

	public String getPuestoRequerido() {
		return puestoRequerido;
	}

	public void setPuestoRequerido(String puestoRequerido) {
		this.puestoRequerido = puestoRequerido;
	}

	public String getResumenPuesto() {
		return resumenPuesto;
	}

	public void setResumenPuesto(String resumenPuesto) {
		this.resumenPuesto = resumenPuesto;
	}

	public String getDispHoraria() {
		return dispHoraria;
	}

	public void setDispHoraria(String dispHoraria) {
		this.dispHoraria = dispHoraria;
	}

	public String getPrincTareas() {
		return princTareas;
	}

	public void setPrincTareas(String princTareas) {
		this.princTareas = princTareas;
	}

	public String getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(String datosContacto) {
		this.datosContacto = datosContacto;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public List<Ciudadano> getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(List<Ciudadano> ciudadano) {
		this.ciudadano = ciudadano;
	}

	public boolean isExisteOferta() {
		return existeOferta;
	}

	public void setExisteOferta(boolean existeOferta) {
		this.existeOferta = existeOferta;
	}

	
}