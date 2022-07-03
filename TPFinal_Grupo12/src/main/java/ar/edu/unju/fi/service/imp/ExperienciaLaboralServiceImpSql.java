package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ExperienciaLaboral;
import ar.edu.unju.fi.repository.IExperienciaLaboralRepository;
import ar.edu.unju.fi.service.IExperienciaLaboralService;

@Service("ExperienciaLaboralServiceImpSql")
public class ExperienciaLaboralServiceImpSql implements IExperienciaLaboralService {

	@Autowired
	private IExperienciaLaboralRepository expRepository;
	
	@Override
	public ExperienciaLaboral getExperiencia() {
		// TODO Auto-generated method stub
		return new ExperienciaLaboral();
	}

	@Override
	public boolean guardarExperiencia(ExperienciaLaboral experiencia) {
		// TODO Auto-generated method stub
		if (expRepository.save(experiencia)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarExperiencia(ExperienciaLaboral experiencia) {
		// TODO Auto-generated method stub
		expRepository.save(experiencia);
		
	}

	@Override
	public void eliminarExperiencia(long experiencia_id) {
		// TODO Auto-generated method stub
		expRepository.deleteById(experiencia_id);
		
	}

	@Override
	public List<ExperienciaLaboral> getListaExperienciaLaboral() {
		// TODO Auto-generated method stub
		return expRepository.findAll();
	}

	@Override
	public ExperienciaLaboral buscarExperiencia(long experiencia_id) {
		// TODO Auto-generated method stub
		return expRepository.findById(experiencia_id);
	}

}
