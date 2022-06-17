package ar.edu.unju.fi.entity;

public class Educacion {
	private long educacion_id;
	private String nivelAlcanzado;
	
	public Educacion() {
		// TODO Auto-generated constructor stub
	}

	public Educacion(long educacion_id, String nivelAlcanzado) {
		super();
		this.educacion_id = educacion_id;
		this.nivelAlcanzado = nivelAlcanzado;
	}

	public long getEducacion_id() {
		return educacion_id;
	}

	public void setEducacion_id(long educacion_id) {
		this.educacion_id = educacion_id;
	}

	public String getNivelAlcanzado() {
		return nivelAlcanzado;
	}

	public void setNivelAlcanzado(String nivelAlcanzado) {
		this.nivelAlcanzado = nivelAlcanzado;
	}
	
	

}
