package ar.edu.unju.fi.entity;

import java.time.LocalDate;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * Clase que representa a un empleador que desea registrarse
 * 
 * @author Elio
 * @version 1.0
 */

@Entity
@Table(name = "empleadores")
public class Empleador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EMPLEADOR_ID")
	private long empleador_id;
	
	@Column(name = "CUIT", length = 13)
	//@NotNull(message = "Debe Ingresar CUIT")
	//@Size(min=13, max=13)
	private String cuit;
	
	@Column(name = "EMPLEADOR_PASS", length = 100)
	private String password;
	
	@Column(name = "RAZON_SOCIAL", length = 20)
	//@NotNull(message = "Debe Ingresar Razon Social")
	//@Size(min=5, max=20)
	private String razonSocial;
	
	@Column(name = "NOMBRE_COM", length = 20)
	//@NotNull(message = "Debe Ingresar Nombre Comercial")
	//@Size(min=5, max=20)
	private String nombreComercial;
	
	@Column(name = "INICIO_ACT", length = 10)
	//@NotNull(message="Debe ingresar Fecha de Inicio de Actividad") @Past(message="Debe ser fecha anterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inicioActividad;
	
	@Column(name = "EMAIL", length = 50)
	//@NotNull(message = "Debe completar el Email")
	@Email
	private String email;
	
	@Column(name = "TELEFONO", length = 14)	
	//@NotNull (message = "Debe completar el Telefono")
	//@Size(min=10,max=14)	
	private String telefono;
	
	@Column(name = "DOMICILIO", length = 30)	
	//@NotNull (message = "Debe completar el Domicilio")
	//@Size(min=10,max=30)
	private String domicilio;
	
	@ManyToOne()
	@JoinColumn(name = "PROVINCIA_ID")	
	private Provincia provincia;
	
	@Column(name = "PAGWEB", length = 40)	
	private String pagWeb;
	
	@Column(name = "DESCRIPCION", length = 140)
	//@NotNull(message = "Debe completar Descripcion")
	//@Size(min=10, max=140)
	private String descripcion;
	
	@OneToMany(
			mappedBy = "empleador", 
			cascade = CascadeType.ALL, 
			orphanRemoval = false)
	private List<OfertaLaboral> oferLaborales;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name= "contratados",
			joinColumns= {@JoinColumn(name="EMPLEADOR_ID")},
			inverseJoinColumns= {@JoinColumn(name="CIUDADANO_ID")}
			)
	private List <Ciudadano> ciudadanos;
	
	/*
	 @ManyToOne()
	 @JoinColumn(name = "USUARIO_ID") 
	 private Usuario usuario;
	 */
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	@Column(name = "EXISTEEMPLEADOR")
	private boolean existeEmpleador;

	/**
	 * Constructor por defecto
	 */
	public Empleador() {
		// TODO Auto-generated constructor stub
	}

	public Empleador(long empleador_id, @NotNull(message = "Debe Ingresar CUIT") @Size(min = 13, max = 13) String cuit,
			@NotNull(message = "Debe Ingresar Contraseña") @Size(min = 5, max = 15) String password,
			@NotNull(message = "Debe Ingresar Razon Social") @Size(min = 5, max = 20) String razonSocial,
			@NotNull(message = "Debe Ingresar Nombre Comercial") @Size(min = 5, max = 20) String nombreComercial,
			@NotNull(message = "Debe ingresar Fecha de Inicio de Actividad") @Past(message = "Debe ser fecha anterior a la actual") LocalDate inicioActividad,
			@NotNull(message = "Debe completar el Email") @Email String email,
			@NotNull(message = "Debe completar el Telefono") @Size(min = 10, max = 14) String telefono,
			@NotNull(message = "Debe completar el Domicilio") @Size(min = 10, max = 30) String domicilio,
			Provincia provincia, String pagWeb,
			@NotNull(message = "Debe completar Descripcion") @Size(min = 10, max = 140) String descripcion,
			List<OfertaLaboral> oferLaborales, List<Ciudadano> ciudadanos, Usuario usuario, boolean existeEmpleador) {
		super();
		this.empleador_id = empleador_id;
		this.cuit = cuit;
		this.password = password;
		this.razonSocial = razonSocial;
		this.nombreComercial = nombreComercial;
		this.inicioActividad = inicioActividad;
		this.email = email;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.provincia = provincia;
		this.pagWeb = pagWeb;
		this.descripcion = descripcion;
		this.oferLaborales = oferLaborales;
		this.ciudadanos = ciudadanos;
		this.usuario = usuario;
		this.existeEmpleador = existeEmpleador;
	}

	public long getEmpleador_id() {
		return empleador_id;
	}

	public void setEmpleador_id(long empleador_id) {
		this.empleador_id = empleador_id;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public LocalDate getInicioActividad() {
		return inicioActividad;
	}

	public void setInicioActividad(LocalDate inicioActividad) {
		this.inicioActividad = inicioActividad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getPagWeb() {
		return pagWeb;
	}

	public void setPagWeb(String pagWeb) {
		this.pagWeb = pagWeb;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<OfertaLaboral> getOferLaborales() {
		return oferLaborales;
	}

	public void setOferLaborales(List<OfertaLaboral> oferLaborales) {
		this.oferLaborales = oferLaborales;
	}

	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isExisteEmpleador() {
		return existeEmpleador;
	}

	public void setExisteEmpleador(boolean existeEmpleador) {
		this.existeEmpleador = existeEmpleador;
	}

	
	
}
