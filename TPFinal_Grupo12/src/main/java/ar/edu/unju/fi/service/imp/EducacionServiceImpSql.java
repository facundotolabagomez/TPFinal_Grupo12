package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Educacion;
import ar.edu.unju.fi.repository.IEducacionRepository;
import ar.edu.unju.fi.service.IEducacionService;

@Service("EducacionServiceImpSql")
public class EducacionServiceImpSql implements IEducacionService {
	
	@Autowired
	private IEducacionRepository educacionRepository;

	@Override
	public Educacion getEducacion() {
		// TODO Auto-generated method stub
		return new Educacion();
	}

	@Override
	public boolean guardarEducacion(Educacion educacion) {
		// TODO Auto-generated method stub
		if (educacionRepository.save(educacion)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarEducacion(Educacion educacion) {
		// TODO Auto-generated method stub
		educacionRepository.save(educacion);
		
	}

	@Override
	public void eliminarEducacion(long educacion_id) {
		// TODO Auto-generated method stub
		educacionRepository.deleteById(educacion_id);
		
	}

	@Override
	public List<Educacion> getListaEducacion() {
		// TODO Auto-generated method stub
		return educacionRepository.findAll();
	}

	@Override
	public Educacion buscarEducacion(String nivelAlcanzado) {
		// TODO Auto-generated method stub
		return educacionRepository.findByNivelAlcanzado(nivelAlcanzado);
	}

}
