package ar.edu.unju.fi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	//@OneToOne
	@JoinColumn(name = "CIUDADANO_ID")
	private Ciudadano ciudadano;
	
	@OneToMany(
			mappedBy = "curriculum", 
			cascade = CascadeType.ALL, 
			orphanRemoval = false)
	private List<ExperienciaLaboral> expLaboral;
	
	@ManyToOne()
	@JoinColumn(name = "EDUCACION_ID")
	private Educacion educacion;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name= "rel_curriculums_idiomas",
			joinColumns= {@JoinColumn(name="CURRICULUM_ID")},
			inverseJoinColumns= {@JoinColumn(name="IDIOMA_ID")}
			)
	
	private List <Idioma> idiomas;
	
	@Column(name = "CONOC_INFOR", length = 50)
	//@NotNull(message = "Debe completar Conocimientos Informaticos")
	@Size(min=20, max=50)	
	private String conocInfor;
	
	@Column(name = "INFO_COMPLEMEN", length = 50)
	//@NotNull(message = "Debe completar Info Complementaria")
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


	public Curriculum(long curriculum_id, Ciudadano ciudadano, List<ExperienciaLaboral> expLaboral, Educacion educacion,
			List<Idioma> idiomas,
			@NotNull(message = "Debe completar Conocimientos Informaticos") @Size(min = 20, max = 50) String conocInfor,
			@NotNull(message = "Debe completar Info Complementaria") @Size(min = 20, max = 50) String infoComplem,
			boolean existeCurriculum) {
		super();
		this.curriculum_id = curriculum_id;
		this.ciudadano = ciudadano;
		this.expLaboral = expLaboral;
		this.educacion = educacion;
		this.idiomas = idiomas;
		this.conocInfor = conocInfor;
		this.infoComplem = infoComplem;
		this.existeCurriculum = existeCurriculum;
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


	public List<Idioma> getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
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