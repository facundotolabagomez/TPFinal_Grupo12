package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.time.Period;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * Clase que representa a un ciudadano que desea registrarse
 * 
 * @author Elio
 * @version 1.0
 */
@Entity
@Table(name = "ciudadanos")
public class Ciudadano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CIUDADANO_ID")	
	private long ciudadano_id;
	
	@Column(name = "DNI", length = 8)
	//@Min(value=999999, message = "DNI No valido")
	private int dni;
	
	@Column(name = "NUMERO_TRAMITE", length = 11)
	//@Min(value=999999999, message = "Numero de Tramite No valido")
	private long numeroTramite;
	
	
	@Column(name = "NOMBRES", length = 40)
	//@NotNull(message = "Debe completar Nombres")
	//@Size(min=2, max=40)	
	private String nombresCiudadano;
	
	@Column(name = "APELLIDO", length = 20)
	//@NotNull(message = "Debe completar Apellido")
	//@Size(min=3, max=20)	
	private String apellidoCiudadano;
	
	@Column(name = "EMAIL", length = 50)
	//@NotNull(message = "Debe completar el Email")
	//@Email
	private String email;
	
	@Column(name = "ESTADO_CIVIL", length = 15)
	//@NotNull(message = "Debe completar Estado Civil")
	//@Size(min=5, max=15)	
	private String estadoCivil;
	
	@ManyToOne()
	@JoinColumn(name = "PROVINCIA_ID")	
	private Provincia provincia;
	
	@Column(name = "TELEFONO", length = 14)	
	//@NotNull (message = "Debe completar el Telefono")
	//@Size(min=7,max=14)
	private String telefono;
	
	@Column(name = "FECHA_NAC", length = 10)
	//@NotNull(message="Debe ingresar Fecha de Nacimiento") 
	//@Past(message="Debe ser fecha anterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;
	
	@Column(name = "CIUDADANO_PASS", length = 100)
	private String password;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "CURRICULUM_ID")
	//@NotNull (message= "Debe Seleccionar el Curriculum")
	private Curriculum curriculum;
	
	/*
	 @ManyToOne()
	 @JoinColumn(name = "USUARIO_ID") 
	 private Usuario usuario;
	 */
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name= "rel_ciudadanos_ofertaslab",
			joinColumns= {@JoinColumn(name="CIUDADANO_ID")},
			inverseJoinColumns= {@JoinColumn(name="OFERTA_ID")}
			)
	
	private List <OfertaLaboral> ofertas;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name= "rel_ciudadanos_cursos",
			joinColumns= {@JoinColumn(name="CIUDADANO_ID")},
			inverseJoinColumns= {@JoinColumn(name="CURSO_ID")}
			)	
	private List <Curso> cursos;
	
	@ManyToMany(mappedBy="ciudadanos")
	private List<Empleador> empleadores;
	
	@Column(name = "EXISTECIUDADANO")
	private boolean existeCiudadano;

	/**
	 * Constructor por defecto
	 */
	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}

	public Ciudadano(long ciudadano_id, @Min(value = 999999, message = "DNI No valido") int dni, long numeroTramite,
			@NotNull(message = "Debe completar Nombres") @Size(min = 2, max = 40) String nombresCiudadano,
			@NotNull(message = "Debe completar Apellido") @Size(min = 3, max = 20) String apellidoCiudadano,
			@NotNull(message = "Debe completar el Email") @Email String email,
			@NotNull(message = "Debe completar Estado Civil") @Size(min = 5, max = 15) String estadoCivil,
			Provincia provincia,
			@NotNull(message = "Debe completar el Telefono") @Size(min = 7, max = 14) String telefono,
			@NotNull(message = "Debe ingresar Fecha de Nacimiento") @Past(message = "Debe ser fecha anterior a la actual") LocalDate fechaNac,
			@NotNull(message = "Debe completar Contraseña") @Size(min = 5, max = 15) String password,
			Curriculum curriculum, Usuario usuario, List<OfertaLaboral> ofertas, List<Curso> cursos,
			List<Empleador> empleadores, boolean existeCiudadano) {
		super();
		this.ciudadano_id = ciudadano_id;
		this.dni = dni;
		this.numeroTramite = numeroTramite;
		this.nombresCiudadano = nombresCiudadano;
		this.apellidoCiudadano = apellidoCiudadano;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.password = password;
		this.curriculum = curriculum;
		this.usuario = usuario;
		this.ofertas = ofertas;
		this.cursos = cursos;
		this.empleadores = empleadores;
		this.existeCiudadano = existeCiudadano;
	}

	public long getCiudadano_id() {
		return ciudadano_id;
	}

	public void setCiudadano_id(long ciudadano_id) {
		this.ciudadano_id = ciudadano_id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public long getNumeroTramite() {
		return numeroTramite;
	}

	public void setNumeroTramite(long numeroTramite) {
		this.numeroTramite = numeroTramite;
	}

	public String getNombresCiudadano() {
		return nombresCiudadano;
	}

	public void setNombresCiudadano(String nombresCiudadano) {
		this.nombresCiudadano = nombresCiudadano;
	}

	public String getApellidoCiudadano() {
		return apellidoCiudadano;
	}

	public void setApellidoCiudadano(String apellidoCiudadano) {
		this.apellidoCiudadano = apellidoCiudadano;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<OfertaLaboral> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<OfertaLaboral> ofertas) {
		this.ofertas = ofertas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Empleador> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(List<Empleador> empleadores) {
		this.empleadores = empleadores;
	}

	public boolean isExisteCiudadano() {
		return existeCiudadano;
	}

	public void setExisteCiudadano(boolean existeCiudadano) {
		this.existeCiudadano = existeCiudadano;
	}
	
	public int obtenerEdad() {
		Period p = Period.between(this.fechaNac, LocalDate.now());
		int anios = p.getYears();
		return anios;
	}
		
	

}
