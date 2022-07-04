package ar.edu.unju.fi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa idioma/s registrados por el postulante
 * 
 * @author Elio
 * @version 1.0
 */
@Entity
@Table (name = "idiomas")
public class Idioma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDIOMA_ID")
	private long idioma_id;
	
	@Column(name = "NOMBRE_IDIOMA", length = 15)
	//@NotNull(message = "Debe completar Idioma")
	//@Size(min=3, max=15)	
	private String nombreIdioma;
	
	@ManyToMany(mappedBy="idiomas")
	private List<Curriculum> curriculums;

	/**
	 * Constructor por defecto
	 */
	public Idioma() {
		// TODO Auto-generated constructor stub
	}

	public Idioma(long idioma_id,
			@NotNull(message = "Debe completar Idioma") @Size(min = 3, max = 15) String nombreIdioma,
			List<Curriculum> curriculums) {
		super();
		this.idioma_id = idioma_id;
		this.nombreIdioma = nombreIdioma;
		this.curriculums = curriculums;
	}

	public long getIdioma_id() {
		return idioma_id;
	}

	public void setIdioma_id(long idioma_id) {
		this.idioma_id = idioma_id;
	}

	public String getNombreIdioma() {
		return nombreIdioma;
	}

	public void setNombreIdioma(String nombreIdioma) {
		this.nombreIdioma = nombreIdioma;
	}

	public List<Curriculum> getCurriculums() {
		return curriculums;
	}

	public void setCurriculums(List<Curriculum> curriculums) {
		this.curriculums = curriculums;
	}
	
	

}