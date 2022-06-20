package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa a un empleador que desea registrarse
 * 
 * @author Elio
 * @version 1.0
 */
public class Empleador {
	private long empleador_id;
	private String cuit;
	private String password;
	private String razonSocial;
	private String nombreComercial;
	private LocalDate inicioActividad;
	private String email;
	private String telefono;
	private String domicilio;
	private List<Provincia> provincia;
	private String pagWeb;
	private String descripcion;

	/**
	 * Constructor por defecto
	 */
	public Empleador() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param empleador_id    identificador univoco BD
	 * @param cuit            valor de cuit de Empleador
	 * @param password        valor de password de Empleador
	 * @param razonSocial     valor de razon social de Empleador
	 * @param nombreComercial valor de nombre comercial de Empleador
	 * @param inicioActividad valor de inicio de actividad de Empleador
	 * @param email           valor de email de Empleador
	 * @param telefono        valor de telefono de Empleador
	 * @param domicilio       valor de domicilio de Empleador
	 * @param provincia       valor de tipo Provincia de Empleador
	 * @param pagWeb          valor de pagina web de Empleador
	 * @param descripcion     valor de descripcion de Empleador
	 */
	public Empleador(long empleador_id, String cuit, String password, String razonSocial, String nombreComercial,
			LocalDate inicioActividad, String email, String telefono, String domicilio, List<Provincia> provincia,
			String pagWeb, String descripcion) {
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
	}

	/**
	 * Devuelve id de Empleador
	 * 
	 * @return empleador_id
	 */
	public long getEmpleador_id() {
		return empleador_id;
	}

	/**
	 * Asigna valor a id de Empleador
	 * 
	 * @param empleador_id
	 */
	public void setEmpleador_id(long empleador_id) {
		this.empleador_id = empleador_id;
	}

	/**
	 * Devuelve de cuit de Empleador
	 * 
	 * @return cuit
	 */
	public String getCuit() {
		return cuit;
	}

	/**
	 * Asigna valor a cuit de Empleador
	 * 
	 * @param cuit
	 */
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	/**
	 * Devuelve password de Empleador
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Asigna valor a password de Empleador
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Devuelve razon social de Empleador
	 * 
	 * @return razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * Asigna valor a razon social de Empleador
	 * 
	 * @param razonSocial
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * Devuelve nombre comercial de Empleador
	 * 
	 * @return nombreComercial
	 */
	public String getNombreComercial() {
		return nombreComercial;
	}

	/**
	 * Asigna valor a nombre comercial de Empleador
	 * 
	 * @param nombreComercial
	 */
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	/**
	 * Devuelve fecha de inicio de actividad de Empleador
	 * 
	 * @return inicioActividad
	 */
	public LocalDate getInicioActividad() {
		return inicioActividad;
	}

	/**
	 * Asigna valor a fecha de inicio de actividad de Empleador
	 * 
	 * @param inicioActividad
	 */
	public void setInicioActividad(LocalDate inicioActividad) {
		this.inicioActividad = inicioActividad;
	}

	/**
	 * Devuelve email de Empleador
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Asigna valor a email de Empleador
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve telefono de Empleador
	 * 
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Asigna valor a telefono de Empleador
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve domicilio de Empleador
	 * 
	 * @return domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * Asigna valor a domicilio de Empleador
	 * 
	 * @param domicilio
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * Devuelve provincia de Empleador
	 * 
	 * @return provincia
	 */
	public List<Provincia> getProvincia() {
		return provincia;
	}

	/**
	 * Asigna valor de tipo Provincia a provincia de Empleador
	 * 
	 * @param provincia
	 */
	public void setProvincia(List<Provincia> provincia) {
		this.provincia = provincia;
	}

	/**
	 * Devuelve pagina web(url) de Empleador
	 * 
	 * @return pagWeb
	 */
	public String getPagWeb() {
		return pagWeb;
	}

	/**
	 * Asigna valor a pagina web (url) de Empleador
	 * 
	 * @param pagWeb
	 */
	public void setPagWeb(String pagWeb) {
		this.pagWeb = pagWeb;
	}

	/**
	 * Devuelve breve descripcion de Empleador
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Asigna valor a descripcion de Empleador
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
