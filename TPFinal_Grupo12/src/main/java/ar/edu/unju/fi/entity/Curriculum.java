package ar.edu.unju.fi.entity;

import java.util.List;

public class Curriculum {
	private long curriculum_id;
	private Ciudadano ciudadano;
	private List<ExperienciaLaboral> expLaboral;
	private Educacion educacion;
	private Idioma idioma;
	private String conocInfor;
	private String infoComplem; 
	
	public Curriculum() {
		// TODO Auto-generated constructor stub
	}

	public Curriculum(long curriculum_id, Ciudadano ciudadano, List<ExperienciaLaboral> expLaboral, Educacion educacion,
			Idioma idioma, String conocInfor, String infoComplem) {
		super();
		this.curriculum_id = curriculum_id;
		this.ciudadano = ciudadano;
		this.expLaboral = expLaboral;
		this.educacion = educacion;
		this.idioma = idioma;
		this.conocInfor = conocInfor;
		this.infoComplem = infoComplem;
	}

	public long getCurriculum_id() {
		return curriculum_id;
	}

	public void setCurriculum_id(long curriculum_id) {
		this.curriculum_id = curriculum_id;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public List<ExperienciaLaboral> getExpLaboral() {
		return expLaboral;
	}

	public void setExpLaboral(List<ExperienciaLaboral> expLaboral) {
		this.expLaboral = expLaboral;
	}

	public Educacion getEducacion() {
		return educacion;
	}

	public void setEducacion(Educacion educacion) {
		this.educacion = educacion;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public String getConocInfor() {
		return conocInfor;
	}

	public void setConocInfor(String conocInfor) {
		this.conocInfor = conocInfor;
	}

	public String getInfoComplem() {
		return infoComplem;
	}

	public void setInfoComplem(String infoComplem) {
		this.infoComplem = infoComplem;
	}
	
	

}
