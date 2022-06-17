package ar.edu.unju.fi.entity;

public class Provincia {
	private long provincia_id;
	private String nombre;
	
	public Provincia() {
		// TODO Auto-generated constructor stub
	}

	public Provincia(long provincia_id, String nombre) {
		super();
		this.provincia_id = provincia_id;
		this.nombre = nombre;
	}

	public long getProvincia_id() {
		return provincia_id;
	}

	public void setProvincia_id(long provincia_id) {
		this.provincia_id = provincia_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
