package ar.edu.unju.fi.entity;

public class ExperienciaLaboral {
	private long experiencia_id;
	private String experiencia;
	
	public ExperienciaLaboral() {
		// TODO Auto-generated constructor stub
	}

	public ExperienciaLaboral(long experiencia_id, String experiencia) {
		super();
		this.experiencia_id = experiencia_id;
		this.experiencia = experiencia;
	}

	public long getExperiencia_id() {
		return experiencia_id;
	}

	public void setExperiencia_id(long experiencia_id) {
		this.experiencia_id = experiencia_id;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
	

}
