package ar.edu.unju.fi.entity;

import java.time.LocalDate;

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
	private Provincia provincia;
	private String pagWeb;
	private String descripcion;
	
	public Empleador() {
		// TODO Auto-generated constructor stub
	}

	public Empleador(long empleador_id, String cuit, String password, String razonSocial, String nombreComercial,
			LocalDate inicioActividad, String email, String telefono, String domicilio, Provincia provincia,
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
	
	

}
