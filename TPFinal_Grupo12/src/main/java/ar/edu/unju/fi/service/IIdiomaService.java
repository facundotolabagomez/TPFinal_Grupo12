package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Idioma;


public interface IIdiomaService {
	
	public Idioma getIdioma();
	public boolean guardarIdioma(Idioma idioma);
	public void modificarIdioma (Idioma idioma);
	public void eliminarIdioma (String nombreIdioma);
	public List<Idioma> getListaIdioma();
	public Idioma buscarIdioma(String nombreIdioma);

}
