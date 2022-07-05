package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Curso;

public interface ICursoService {
	
	public Curso buscarCurso(long curso_id);
	public List<Curso> getListaCurso();

}
