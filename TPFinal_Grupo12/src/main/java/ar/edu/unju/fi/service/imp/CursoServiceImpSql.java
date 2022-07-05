package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.ICursoRepository;
import ar.edu.unju.fi.service.ICursoService;

@Service("CursoServiceImpSql")
public class CursoServiceImpSql implements ICursoService {
	
	@Autowired
	private ICursoRepository cursoRepository;

	@Override
	public Curso buscarCurso(long curso_id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(curso_id);
	}

	@Override
	public List<Curso> getListaCurso() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

}
