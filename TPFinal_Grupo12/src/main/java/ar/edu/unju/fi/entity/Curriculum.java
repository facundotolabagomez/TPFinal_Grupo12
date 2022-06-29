package ar.edu.unju.fi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa los datos del postulante
 * 
 * @author Elio
 * @version 1.0
 */

@Entity
@Table(name = "curriculums")
public class Curriculum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CURRICULUM_ID")	
	private long curriculum_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CIUDADANO_ID")
	@NotNull (message= "Debe Seleccionar el Ciudadano")
	private Ciudadano ciudadano;
	
	@OneToMany(
			mappedBy = "curriculum", 
			cascade = CascadeType.ALL, 
			orphanRemoval = false)
	private List<ExperienciaLaboral> expLaboral;
	
	@ManyToOne()
	@JoinColumn(name = "EDUCACION_ID")
	private Educacion educacion;
	
	@OneToMany(
			mappedBy = "curriculum", 
			cascade = CascadeType.ALL, 
			orphanRemoval = false)
	private List<Idioma> idiomas;
	
	@Column(name = "CONOC_INFOR", length = 50)
	@NotNull(message = "Debe completar Conocimientos Informaticos")
	@Size(min=20, max=50)	
	private String conocInfor;
	
	@Column(name = "INFO_COMPLEMEN", length = 50)
	@NotNull(message = "Debe completar Info Complementaria")
	@Size(min=20, max=50)	
	private String infoComplem;
	
	@Column(name = "EXISTECURRICULUM")
	private boolean existeCurriculum;
	

	/**
	 * Constructor por defecto
	 */
	public Curriculum() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Contructor parametrizado
	 * 
	 * @param curriculum_id identificador univoco BD
	 * @param ciudadano     valor de tipo Ciudadano de Curriculum
	 * @param expLaboral    valor de tipo ExperienciaLaboral de Curriculum
	 * @param educacion     valor de tipo Educacion de Curriculum
	 * @param idioma        valor de tipo Idioma de Curriculum
	 * @param conocInfor    valor de conociemientos informaticos de Curriculum
	 * @param infoComplem   valor de informacion complementaria de Curriculum
	 */
	public Curriculum(long curriculum_id, Ciudadano ciudadano, List<ExperienciaLaboral> expLaboral, Educacion educacion,
			List<Idioma> idiomas, String conocInfor, String infoComplem) {
		super();
		this.curriculum_id = curriculum_id;
		this.ciudadano = ciudadano;
		this.expLaboral = expLaboral;
		this.educacion = educacion;
		this.idiomas = idiomas;
		this.conocInfor = conocInfor;
		this.infoComplem = infoComplem;
	}

	/*
	 * metodos accesores
	 */

	/**
	 * Devuelve id de Curriculum
	 * 
	 * @return curriculum_id
	 */
	public long getCurriculum_id() {
		return curriculum_id;
	}

	/**
	 * Asigna un valor a curriculum_id
	 * 
	 * @param curriculum_id
	 */
	public void setCurriculum_id(long curriculum_id) {
		this.curriculum_id = curriculum_id;
	}

	/**
	 * Devuelve ciudadano de Curriculum
	 * 
	 * @return ciudadano
	 */
	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	/**
	 * Asigna un valor de tipo Ciudadano a ciudadano de Curriculum
	 * 
	 * @param ciudadano
	 */
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	/**
	 * Devuelve experiencia laboral de Curriculum
	 * 
	 * @return expLaboral
	 */
	public List<ExperienciaLaboral> getExpLaboral() {
		return expLaboral;
	}

	/**
	 * Asigna valor de tipo ExperienciaLaboral a experiencia laboral de Currriculum
	 * 
	 * @param expLaboral
	 */
	public void setExpLaboral(List<ExperienciaLaboral> expLaboral) {
		this.expLaboral = expLaboral;
	}

	/**
	 * Devuelve educacion de Curriculum
	 * 
	 * @return educacion
	 */
	public Educacion getEducacion() {
		return educacion;
	}

	/**
	 * Asigna valor de tipo Educacion a educacion de Curriculum
	 * 
	 * @param educacion
	 */
	public void setEducacion(Educacion educacion) {
		this.educacion = educacion;
	}

	/**
	 * Devuelve idioma de Curriculum
	 * 
	 * @return idioma
	 */
	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	/**
	 * Asigna valor de tipo Idioma a idioma de Curriculum
	 * 
	 * @param idioma
	 */
	public void setIdiomas(List<Idioma> idioma) {
		this.idiomas = idioma;
	}

	/**
	 * Devuelve conociemientos informaticos de Curriculum
	 * 
	 * @return conocInfor
	 */
	public String getConocInfor() {
		return conocInfor;
	}

	/**
	 * Asigna valor a conociemientos informaticos de Curriculum
	 * 
	 * @param conocInfor
	 */
	public void setConocInfor(String conocInfor) {
		this.conocInfor = conocInfor;
	}

	/**
	 * Devuelve informacion complementaria de Curriculum
	 * 
	 * @return infoComplem
	 */
	public String getInfoComplem() {
		return infoComplem;
	}

	/**
	 * Asigna valor a informacion complementaria de Curriculum
	 * 
	 * @param infoComplem
	 */
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
