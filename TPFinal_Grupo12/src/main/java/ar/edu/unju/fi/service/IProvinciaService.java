package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Provincia;

public interface IProvinciaService {
	
	public Provincia getProvincia();
	public boolean guardarProvincia(Provincia provincia);
	public void modificarProvincia (Provincia provincia);
	public void eliminarProvincia (long provincia_id);
	public List<Provincia> getListaProvincia();
	public Provincia buscarProvincia(String nombreProvincia);

}
