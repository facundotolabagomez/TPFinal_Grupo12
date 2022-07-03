package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.ExperienciaLaboral;

public interface IExperienciaLaboralService {
	public ExperienciaLaboral getExperiencia();
	public boolean guardarExperiencia(ExperienciaLaboral experiencia);
	public void modificarExperiencia (ExperienciaLaboral experiencia);
	public void eliminarExperiencia (long experiencia_id);
	public List<ExperienciaLaboral> getListaExperienciaLaboral();
	public ExperienciaLaboral buscarExperiencia(long experiencia_id);
	
}
