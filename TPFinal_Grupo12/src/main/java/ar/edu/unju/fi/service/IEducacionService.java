package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Educacion;

public interface IEducacionService {

	public Educacion getEducacion();
	public boolean guardarEducacion(Educacion educacion);
	public void modificarEducacion (Educacion educacion);
	public void eliminarEducacion (long educacion_id);
	public List<Educacion> getListaEducacion();
	public Educacion buscarEducacion(String nivelAlcanzado);
}
