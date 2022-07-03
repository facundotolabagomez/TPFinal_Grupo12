package ar.edu.unju.fi.service;


import ar.edu.unju.fi.entity.Curriculum;


public interface ICurriculumService {
	
	public Curriculum getCurriculum();
	public boolean guardarCurriculum(Curriculum curriculum);
	public void modificarCurriculum(Curriculum curriculum);
	public void eliminarCiudadano (long curriculum_id);
	public Curriculum buscarCurriculum(long curriculum_id);
	//public Curriculum buscarCurriculumPorCiudadanoId(long ciudadano_id); 

}
