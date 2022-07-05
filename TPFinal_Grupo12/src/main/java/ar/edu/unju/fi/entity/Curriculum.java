package ar.edu.unju.fi.entity;

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

/**
 * Clase que representa los datos del postulante
 * 
 * 
 */

@Entity
@Table(name = "curriculums")
public class Curriculum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CURRICULUM_ID")	
	private long curriculum_id;
	
	
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "CIUDADANO_ID")
	private Ciudadano ciudadano;
	
	@Column(name = "IDIOMA", length = 50)
	//@NotNull(message = "Debe completar Conocimientos Informaticos")
	//@Size(min=20, max=50)	
	private String idioma;
	
	@Column(name = "EXP_LABORAL", length = 50)
	//@NotNull(message = "Debe completar Conocimientos Informaticos")
	//@Size(min=20, max=50)	
	private String expLab;
	
	@ManyToOne()
	@JoinColumn(name = "EDUCACION_ID")
	private Educacion educacion;
	
	@Column(name = "CONOC_INFOR", length = 50)
	//@NotNull(message = "Debe completar Conocimientos Informaticos")
	//@Size(min=20, max=50)	
	private String conocInfor;
	
	@Column(name = "INFO_COMPLEMEN", length = 50)
	//@NotNull(message = "Debe completar Info Complementaria")
	//@Size(min=20, max=50)	
	private String infoComplem;
	
	@Column(name = "EXISTECURRICULUM")
	private boolean existeCurriculum;
	

	/**
	 * Constructor por defecto
	 */
	public Curriculum() {
		// TODO Auto-generated constructor stub
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


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public String getExpLab() {
		return expLab;
	}


	public void setExpLab(String expLab) {
		this.expLab = expLab;
	}


	public Educacion getEducacion() {
		return educacion;
	}


	public void setEducacion(Educacion educacion) {
		this.educacion = educacion;
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


	public boolean isExisteCurriculum() {
		return existeCurriculum;
	}


	public void setExisteCurriculum(boolean existeCurriculum) {
		this.existeCurriculum = existeCurriculum;
	}


	
	
}