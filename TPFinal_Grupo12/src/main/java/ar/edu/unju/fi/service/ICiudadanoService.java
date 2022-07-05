package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ciudadano;


public interface ICiudadanoService {
	
	public Ciudadano getCiudadano();
	public boolean guardarCiudadano(Ciudadano ciudadano);
	public void modificarCiudadano (Ciudadano  ciudadano);
	public void eliminarCiudadano (long ciudadano_id);
	public List<Ciudadano> getListaCiudadano();
	public Ciudadano buscarCiudadano(int dni);
	public Ciudadano buscarCiudadanoPorEmail(String email);
	public Ciudadano buscarCiudadanoPorOferta(long oferta_id);

}
