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

@Entity
@Table( name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CURSO_ID")
	private long curso_id;
	
	@Column(name = "NOMBRE_CURSO", length = 20)
	@NotNull(message = "Debe completar Nombre de Curso")
	@Size(min=5, max=20)
	private String nombreCurso;
	
	@ManyToMany(mappedBy="cursos")
	private List<Ciudadano> ciudadano;
	
	@Column(name = "CATEGORIA_CURSO", length =50)
	@NotNull(message = "Debe completar Categoria de Curso")
	@Size(min=5, max=50)
	private String categoria;
	
	@Column(name = "DETALLES_CURSO", length = 140)
	@NotNull(message = "Debe completar Detalles de Curso")
	@Size(min=5, max=140)
	private String detalles;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(long curso_id,
			@NotNull(message = "Debe completar Nombre de Curso") @Size(min = 5, max = 20) String nombreCurso,
			List<Ciudadano> ciudadano,
			@NotNull(message = "Debe completar Categoria de Curso") @Size(min = 5, max = 50) String categoria,
			@NotNull(message = "Debe completar Detalles de Curso") @Size(min = 5, max = 140) String detalles) {
		super();
		this.curso_id = curso_id;
		this.nombreCurso = nombreCurso;
		this.ciudadano = ciudadano;
		this.categoria = categoria;
		this.detalles = detalles;
	}

	public long getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(long curso_id) {
		this.curso_id = curso_id;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public List<Ciudadano> getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(List<Ciudadano> ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	
	
}
