package ar.edu.unju.fi.entity;

public class Idioma {
	private long idioma_id;
	private String idioma;
	
	public Idioma() {
		// TODO Auto-generated constructor stub
	}

	public Idioma(long idioma_id, String idioma) {
		super();
		this.idioma_id = idioma_id;
		this.idioma = idioma;
	}

	public long getIdioma_id() {
		return idioma_id;
	}

	public void setIdioma_id(long idioma_id) {
		this.idioma_id = idioma_id;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	

}
