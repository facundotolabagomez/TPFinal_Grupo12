package ar.edu.unju.fi.entity;

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
	
	public OfertaLaboral() {
		// TODO Auto-generated constructor stub
	}

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

	public long getVacante_id() {
		return vacante_id;
	}

	public void setVacante_id(long vacante_id) {
		this.vacante_id = vacante_id;
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
	
	

}
